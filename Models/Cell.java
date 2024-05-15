package Projects.TicTacToe.Models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState state;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.state = CellState.EMPTY;
    }

    public CellState getState() {
        return state;
    }

    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }


    public Player getPlayer() {
        return player;
    }

}
