public class PositiveNegativeZero {

    public static void main(String[] args) {

        checkNumber(10);
        checkNumber(-10);
        checkNumber(0);
    }

    public static void checkNumber(int number) {
        String word = number > 0 ? "positive" : (number < 0 ? "negative" : "zero");

        System.out.println(word);
    }
}
