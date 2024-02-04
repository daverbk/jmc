public class PlayingCat {

    public static void main(String[] args) {

        // should return false since temperature is not in range 25 - 45
        System.out.println(isCatPlaying(true, 10));

        // should return false since temperature is not in range 25 - 35 (summer parameter is false)
        System.out.println(isCatPlaying(false, 36));

        // should return true since temperature is in range 25 - 35
        System.out.println(isCatPlaying(false, 35));
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        boolean isPlaying = false;
        int lowestTemperatureForPlay = 25;
        int highestTemperatureForPlay = summer ? 45 : 35;

        if (temperature >= lowestTemperatureForPlay && temperature <= highestTemperatureForPlay) {
            isPlaying = true;
        }

        return isPlaying;
    }
}
