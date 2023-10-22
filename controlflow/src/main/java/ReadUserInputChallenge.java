import java.util.Scanner;

public class ReadUserInputChallenge {

    public static void main(String[] args) {

        System.out.println(sumNumber());
    }

    public static String sumNumber() {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int numbersCount = 1;

        while (numbersCount <= 5) {
            System.out.println("Enter a valid number #" + numbersCount);
            String nextNumber = scanner.nextLine();

            try {
                double currentNum = Double.parseDouble(nextNumber);
                numbersCount++;
                sum += currentNum;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number");
            }
        }

        return "So the sum is " + sum;
    }
}
