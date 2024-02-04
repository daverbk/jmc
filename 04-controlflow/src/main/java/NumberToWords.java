public class NumberToWords {

    public static void numberToWords(int number) {

        if (number < 0) {
            System.out.println("Invalid Value");
        }

        int reversedNumber = reverse(number);
        int reversedVsOriginalDifference = getDigitCount(number) - getDigitCount(reversedNumber);

        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;
            System.out.println(getWordForNumber(lastDigit));
            reversedNumber /= 10;
        }

        while (reversedVsOriginalDifference > 0) {
            System.out.println("Zero");

            reversedVsOriginalDifference--;
        }
    }

    public static String getWordForNumber(int number) {

        switch (number) {
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            default:
                return null;
        }
    }

    public static int reverse(int number) {
        int reverse = 0;
        int temp = number;

        if (number < 0) {
            temp *= -1;
        }

        while (temp > 0) {
            int lastDigit = temp % 10;
            reverse *= 10;
            reverse += lastDigit;
            temp /= 10;
        }

        return number < 0 ? reverse * -1 : reverse;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }

        int count = 0;

        while (number > 0) {
            number /= 10;
            count++;
        }

        return count;
    }
}
