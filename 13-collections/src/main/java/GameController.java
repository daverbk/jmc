import games.poker.PokerGame;

public class GameController {
    public static void main(String[] args) {
        PokerGame game = new PokerGame(8, 5);
        game.startPlay();
    }
}
