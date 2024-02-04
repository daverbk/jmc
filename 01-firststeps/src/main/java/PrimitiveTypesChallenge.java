public class PrimitiveTypesChallenge {

    public static void main(String[] args) {

        byte myByteValue = 10;
        short myShortValue = 500;
        int myIntValue = 1000;

        long myLongValue = (myByteValue + myShortValue + myIntValue) * 10 + 50000;
        System.out.println("The result of the calculation is " + myLongValue);
    }
}
