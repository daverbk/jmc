public class PerfectNumber {

    public static void main(String[] args) {

        System.out.println(isPerfectNumber(6)); // true
    }

    public static boolean isPerfectNumber(int number) {

        if (number < 1) {
            return false;
        }

        int properDivisorsSum = 0;
        int dividedNum = number;

        while (dividedNum > 1) {

            if (number % dividedNum == 0) {
                properDivisorsSum += (number / dividedNum);
                System.out.println(number / dividedNum);
            }

            dividedNum--;
        }

        return properDivisorsSum == number;
    }
}
