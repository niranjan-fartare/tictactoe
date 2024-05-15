package Projects.TicTacToe.Controllers;

import Projects.TicTacToe.Exceptions.duplicateSymbolException;
import Projects.TicTacToe.Exceptions.invalidDimensionException;
import Projects.TicTacToe.Exceptions.invalidPlayerCountException;
import Projects.TicTacToe.Models.Game;
import Projects.TicTacToe.Models.GameState;
import Projects.TicTacToe.Models.Player;

import java.util.List;

public class GameController {
    private Game game;
    public void undo(){

    }

    public Game createGame(int dimension, List<Player> players) throws invalidDimensionException, duplicateSymbolException, invalidPlayerCountException {
        game = Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();
        return game;
    }

    public Player getWinner(){
        return null;
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public GameState getGameState(){
        return game.getGameState();
    }
    public Game executeNextMove(Game game){
        return null;
    }
}
