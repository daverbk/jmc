package durak;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Alice"));
        game.addPlayer(new Player("Bob"));

        game.start();
    }
}
