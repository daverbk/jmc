public class NumberPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(-1222)); // false
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            number *= -1;
        }

        int reverse = 0;
        int temp = number;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reverse *= 10;
            reverse += lastDigit;
            temp /= 10;
        }

        return number == reverse;
    }
}
