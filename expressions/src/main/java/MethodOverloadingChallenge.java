public class MethodOverloadingChallenge {

    public static void main(String[] args) {

        System.out.println(convertToCentimeters(5, 9));
        System.out.println(convertToCentimeters(69));

        System.out.println(getDurationString(10, 35));
        System.out.println(getDurationString(3945));

        System.out.println(getDurationString(-1, 15));
        System.out.println(getDurationString(10, 61));
        System.out.println(getDurationString(-260));
    }

    public static double convertToCentimeters(int feet, int inches) {
        int totalInches = (feet * 12) + inches;

        return convertToCentimeters(totalInches);
    }

    public static double convertToCentimeters(int inches) {
        return inches * 2.54d;
    }

    public static String getDurationString(int minutes, int seconds) {
        int totalSeconds = -1;

        if (minutes >= 0 && seconds >= 0 && seconds <= 59) {
            totalSeconds = (minutes * 60) + seconds;
        }

        return getDurationString(totalSeconds);
    }

    public static String getDurationString(int seconds) {
        String result = "Invalid data is passed";

        if (seconds >= 0) {
            int hours = seconds / 3600;
            int remainingSeconds = seconds % 3600;

            int minutes = remainingSeconds / 60;
            remainingSeconds %= 60;

            result = hours + "h " + minutes + "m " + remainingSeconds + "s";
        }

        return result;
    }
}
