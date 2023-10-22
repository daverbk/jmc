import java.util.Scanner;

public class InputCalculator {

    public static void main(String[] args) {

        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        double counter = 0d;

        while (true) {
            String nextNumber = scanner.nextLine();

            try {
                int currentNum = Integer.parseInt(nextNumber);
                sum += currentNum;
                counter++;
            } catch (NumberFormatException nfe) {
                System.out.println("SUM = " + sum + " AVG = " + Math.round((double) sum / counter));
                break;
            }
        }
    }
}
