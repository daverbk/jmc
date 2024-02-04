import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {

    public static void main(String[] args) {
        int[] integers = readIntegers();
        System.out.println("integers = " + Arrays.toString(integers));

        int min = findMin(integers);
        System.out.println("min = " + min);
    }

    private static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas:");
        String integers = scanner.nextLine();
        String[] delimited = integers.split(",");
        int[] result = new int[delimited.length];

        for (int i = 0; i < delimited.length; i++) {
            result[i] = Integer.parseInt(delimited[i].trim());
        }

        return result;
    }

    private static int findMin(int... nums) {
        int min = Integer.MAX_VALUE;

        for (int el : nums) {
            if (el < min) {
                min = el;
            }
        }

        return min;
    }
}
