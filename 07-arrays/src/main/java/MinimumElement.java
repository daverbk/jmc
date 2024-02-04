import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int[] readElements(int count) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }

        return nums;
    }

    private static int findMin(int[] nums) {
        Arrays.sort(nums);

        return nums[0];
    }
}
