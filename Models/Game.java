package Projects.TicTacToe.Models;

import Projects.TicTacToe.Exceptions.duplicateSymbolException;
import Projects.TicTacToe.Exceptions.invalidDimensionException;
import Projects.TicTacToe.Exceptions.invalidPlayerCountException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private Player winner;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayerIndex;

    private Game(){
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Board getBoard() {
        return board;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validate() throws invalidDimensionException, invalidPlayerCountException, duplicateSymbolException {
            if(this.players.size() != dimension - 1){
                throw new invalidPlayerCountException("Player count should be at least N-1");
            }

            if(this.dimension < 3){
                throw new invalidDimensionException("Dimension Should be at least 3");
            }

            Set<Character> verifySymbols = new HashSet<>();
            for(int i=0;i<players.size();i++){
                verifySymbols.add(players.get(i).getSymbol());
            }
            if(verifySymbols.size() != players.size()){
                throw new duplicateSymbolException("Players should have unique symbols");
            }
        }

        public Game build() throws invalidDimensionException, invalidPlayerCountException, duplicateSymbolException {
            validate();

            Game game = new Game();
            game.setBoard(new Board(this.dimension));
            game.setPlayers(new ArrayList<>());
            game.setMoves(new ArrayList<>());
            game.setGameState(GameState.IN_PROGRESS);
            game.setNextPlayerIndex(0);

            return game;
        }
    }
}
