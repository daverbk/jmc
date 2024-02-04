public class IntEqualityPrinter {

    public static void main(String[] args) {

        printEqual(1, 1, 1); // All numbers are equal
        printEqual(1, 1, 2); // Neither all are equal nor different
        printEqual(-1, -1, -1); // Invalid Value
        printEqual(1, 2, 3); // All numbers are different
    }

    public static void printEqual(int num1, int num2, int num3) {
        String message = "Invalid Value";

        if (num1 >= 0 && num2 >= 0 && num3 >= 0) {

            if (num1 == num2 && num2 == num3) {
                message = "All numbers are equal";
            } else if (num1 != num2 && num2 != num3 && num1 != num3) {
                message = "All numbers are different";
            } else {
                message = "Neither all are equal or different";
            }
        }

        System.out.println(message);
    }
}
