public class LargestPrime {

    public static int getLargestPrime(int number) {
        if (number < 0) {
            return -1;
        }

        int largest = -1;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                largest = number;
            }
        }

        return largest;
    }
}
