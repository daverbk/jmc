public class LeapYearCalculator {

    public static void main(String[] args) {

        System.out.println(isLeapYear(1700)); // false
        System.out.println(isLeapYear(2017)); // false

        System.out.println(isLeapYear(1600)); // true
        System.out.println(isLeapYear(2400)); // true

        System.out.println(isLeapYear(-1600)); // false

        System.out.println(isLeapYear(1924)); // true
    }

    public static boolean isLeapYear(int year) {
        boolean isLeapYear = false;

        if (year > 0 && year <= 9999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeapYear = true;
                    }
                } else {
                    isLeapYear = true;
                }
            }
        }

        return isLeapYear;
    }
}
