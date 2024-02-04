public class SharedDigit {

    public static void main(String[] args) {

        System.out.println(hasSharedDigit(12, 13)); // true
    }

    public static boolean hasSharedDigit(int num1, int num2) {
        if ((num1 < 10 || num1 > 99) || (num2 < 10 || num2 > 99)) {
            return false;
        }

        int tempNum2 = num2;

        while (num1 > 0) {
            int num1LastDigit = num1 % 10;
            num1 /= 10;

            while (tempNum2 > 0) {
                int smallerNumLastDigit = tempNum2 % 10;
                tempNum2 /= 10;

                if (smallerNumLastDigit == num1LastDigit) {
                    return true;
                }
            }

            tempNum2 = num2;
        }

        return false;
    }
}
