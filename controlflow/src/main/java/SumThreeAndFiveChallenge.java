public class SumThreeAndFiveChallenge {

    public static void main(String[] args) {

        int sum = 0;
        int foundNumbersCount = 0;

        for (int i = 1; foundNumbersCount < 5 && i <= 1000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                sum += i;
                foundNumbersCount++;
                System.out.println(i);
            }
        }

        System.out.println(sum);
    }
}
