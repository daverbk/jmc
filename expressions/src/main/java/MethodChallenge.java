public class MethodChallenge {

    public static void main(String[] args) {

        int score1 = calculateHighScorePosition(1500);
        displayHighScorePosition("Player1", score1);

        int score2 = calculateHighScorePosition(1000);
        displayHighScorePosition("Player2", score2);

        int score3 = calculateHighScorePosition(500);
        displayHighScorePosition("Player3", score3);

        int score4 = calculateHighScorePosition(100);
        displayHighScorePosition("Player4", score4);

        int score5 = calculateHighScorePosition(25);
        displayHighScorePosition("Player5", score5);
    }

    public static int calculateHighScorePosition(int playersScore) {
        int position = 4;

        if (playersScore >= 1000) {
            position = 1;
        } else if (playersScore >= 500) {
            position = 2;
        } else if (playersScore >= 100) {
            position = 3;
        }

        return position;
    }

    public static void displayHighScorePosition(String playerName, int playerPosition) {
        System.out.println(playerName + " managed to get into position "
                + playerPosition + " on the high score list.");
    }
}
