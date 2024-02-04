public class LargestPrime {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(199));
    }

    public static int getLargestPrime(int number) {
        if (number < 0) {
            return -1;
        }

        int largestPrime = -1;
        int i = 2;

        while (i * i <= number) {

            while (number % i == 0) {
                largestPrime = i;
                number /= i;
            }

            i++;
        }

        if (number > 1) {
            largestPrime = number;
        }

        return largestPrime;
    }
}
