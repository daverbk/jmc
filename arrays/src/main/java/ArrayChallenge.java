import java.util.Arrays;
import java.util.Random;

public class ArrayChallenge {
    public static void main(String[] args) {
        int[] unsortedArray = getRandomArray(3);
        int[] sortedArray = sortIntegers(unsortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(1000);
        }

        return newInt;
    }

    private static int[] sortIntegers(int[] arr) {

        System.out.println(Arrays.toString(arr));
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                    System.out.println("------>" + Arrays.toString(sortedArray));
                }
            }

            System.out.println("--->" + Arrays.toString(sortedArray));
        }

        return sortedArray;
    }
}