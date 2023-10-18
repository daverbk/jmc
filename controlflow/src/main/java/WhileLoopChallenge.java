public class WhileLoopChallenge {

    public static void main(String[] args) {

        int evenNumsCounter = 0;
        int i = 5;
        while (i <= 20 && evenNumsCounter != 5) {

            if (isEvenNumber(i)) {
                System.out.println(i);
                evenNumsCounter++;
            }

            i++;
        }

        System.out.println(evenNumsCounter);
    }

    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
