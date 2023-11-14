import java.util.Arrays;

public class ReverseArrayChallenge {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 3, 7, 2, 0 };
        System.out.println("array = " + Arrays.toString(array));

        reverse(array);
        System.out.println("reversed array = " + Arrays.toString(array));

        int[] reversedArray = reverseCopy(array);
        System.out.println("reversed array copy = " + Arrays.toString(reversedArray));
    }

    private static void reverse(int[] array) {
        int halfLength = array.length / 2;
        int maxIndex = array.length - 1;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

    private static int[] reverseCopy(int[] array) {
        int[] reversedArray = new int[array.length];

        int maxIndex = array.length - 1;
        for (int el : array) {
            reversedArray[maxIndex--] = el;
        }

        return reversedArray;
    }
}
