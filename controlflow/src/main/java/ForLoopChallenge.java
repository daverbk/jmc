public class ForLoopChallenge {

    public static void main(String[] args) {

        printThreePrimes();
    }

    public static void printThreePrimes() {
        int primesCount = 0;

        for (int i = 10; primesCount < 3 && i <= 50; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime");
                primesCount++;
            }
        }
    }

    public static boolean isPrime(int number) {

        if (number <= 2) {
            return number == 2;
        }

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
