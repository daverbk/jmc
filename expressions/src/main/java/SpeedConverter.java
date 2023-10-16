public class SpeedConverter {

    public static void main(String[] args) {

        printConversion(1.5d);
        printConversion(10.25d);
        printConversion(-5.6d);
        printConversion(25.42d);
        printConversion(75.114d);
        printConversion(0d);
    }

    public static void printConversion(double kilometersPerHour) {
        String conversionResult = kilometersPerHour >= 0
                ? kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h"
                : "Invalid Value";

        System.out.println(conversionResult);
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        long milesPerHour = -1;

        if (kilometersPerHour >= 0) {
            double notRoundedMilesPerHour = kilometersPerHour / 1.609d;
            milesPerHour = Math.round(notRoundedMilesPerHour);
        }

        return milesPerHour;
    }
}
