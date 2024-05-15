package Projects.TicTacToe;

import Projects.TicTacToe.Controllers.GameController;
import Projects.TicTacToe.Exceptions.duplicateSymbolException;
import Projects.TicTacToe.Exceptions.invalidDimensionException;
import Projects.TicTacToe.Exceptions.invalidPlayerCountException;
import Projects.TicTacToe.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws invalidDimensionException, duplicateSymbolException, invalidPlayerCountException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Board Dimensions: ");
        int dimension = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        for(int i = 0; i < dimension-1; i++) {
            System.out.println("Enter Player " + (i+1) +"'s Name = " );
            String playerName = scanner.next();
            System.out.println("Enter Player " + playerName +"'s Symbol = " );
            char playerSymbol = scanner.next().charAt(0);
            System.out.println("Is Player " + playerName +" a Bot? (Y/N)" );
            char isBot = scanner.next().charAt(0);
            if(isBot == 'Y') {
                System.out.println("Enter Bot Difficulty (Easy/Medium/Hard): ");
//  TODO              String botDifficulty = scanner.next();
                players.add(new Bot(playerSymbol,playerName, PlayerType.BOT, BotDifficulty.EASY));
            } else players.add(new Player(playerSymbol,playerName, PlayerType.HUMAN));
        }

        GameController gameController = new GameController();

        Game game = gameController.createGame(dimension, players);
        while (gameController.getGameState().equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            System.out.println("Do you want to undo? (Y/N): ");
            char doUndo = scanner.next().charAt(0);
            if(doUndo == 'Y' ){
                gameController.undo();
            } else gameController.executeNextMove(game);

            if(gameController.getGameState().equals(GameState.ENDED)){
                System.out.println(gameController.getWinner().getName()+" has win the game");
            } else System.out.println("DRAW");
        }
    }
}
