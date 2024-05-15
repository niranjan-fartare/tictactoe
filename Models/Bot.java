package Projects.TicTacToe.Models;

public class Bot extends Player{
    private BotDifficulty botDifficulty;

    public Bot(char symbol, String name, PlayerType playerType, BotDifficulty botDifficulty) {
        super(symbol, name, playerType);
        this.botDifficulty = botDifficulty;
    }
}
