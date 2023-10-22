import java.util.Scanner;

public class MinMaxChallenge {
    public static void main(String[] args) {

        minMaxNumber();
    }

    public static void minMaxNumber() {
        Scanner scanner = new Scanner(System.in);
        double min = 0;
        double max = 0;

        while (true) {
            System.out.println("Enter a valid number. You can enter any character to quit.");
            String nextNumber = scanner.nextLine();

            try {
                double currentNum = Double.parseDouble(nextNumber);
                min = min == 0 ? currentNum : Math.min(min, currentNum);
                max = Math.max(max, currentNum);

                System.out.println("Min num is " + min);
                System.out.println("Max num is " + max);
                System.out.println("Sum is " + (min + max));

            } catch (NumberFormatException nfe) {
                System.out.println("Thanks. Bye.");
                break;
            }
        }
    }
}
