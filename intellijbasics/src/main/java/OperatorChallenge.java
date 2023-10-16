public class OperatorChallenge {

    public static void main(String[] args) {

        double myFirstDoubleValue = 20d;
        double mySecondDoubleValue = 80d;

        double calculationResult = (myFirstDoubleValue + mySecondDoubleValue) * 100d;
        double remainder = calculationResult % 40d;

        boolean isRemainderZero = remainder == 0d;
        System.out.println("Is remainder zero? is " + isRemainderZero);

        if (!isRemainderZero) {
            System.out.println("Got some remainder");
        }
    }
}
