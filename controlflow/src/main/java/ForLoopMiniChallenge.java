public class ForLoopMiniChallenge {

    public static void main(String[] args) {

        for (double rate = 7.5; rate <= 10; rate += 0.25) {
            double interest = calculateInterest(100, rate);
            System.out.println("rate = " + rate + ", interest = " + interest);
        }
    }

    public static double calculateInterest(double amount, double interestRate) {

        return amount * (interestRate / 100);
    }
}
