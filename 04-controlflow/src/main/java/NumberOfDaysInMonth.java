public class NumberOfDaysInMonth {

    public static int getDaysInMonth(int month, int year) {
        int result = -1;

        if ((month > 0 && month <= 12) && (year > 0 && year <= 9999))
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    result = 31;
                    break;
                case 2:
                    result = isLeapYear(year) ? 29 : 28;
                    break;
                default:
                    result = 30;
            }

        return result;
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
