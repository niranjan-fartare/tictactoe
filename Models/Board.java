package Projects.TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public Board(int dimension){
        board = new ArrayList<>();
        for(int i = 0; i < dimension; i++){
            this.board.add(new ArrayList<>());
            for(int j = 0; j < dimension; j++){
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

//    public void displayBoard(){
//        for(int i = 0; i < board.size(); i++){
//            for(int j = 0; j < board.get(i).size(); j++){
//                if(board.get(i).get(j).getState() == CellState.EMPTY){
//                    System.out.print("|_|");
//                } else System.out.print("|"+board.get(i).get(j).getPlayer().getSymbol()+"|");
//            }
//            System.out.println();
//        }
//    }
public void displayBoard() {
    for (int i = 0; i < board.size(); i++) {
        System.out.print("|");
        for (int j = 0; j < board.get(i).size(); j++) {
            if (board.get(i).get(j).getState() == CellState.EMPTY) {
                System.out.print("_|");
            } else {
                System.out.print(board.get(i).get(j).getPlayer().getSymbol() + "|");
            }
        }
        System.out.println(); // Move to a new line after printing each row
    }
}

}
