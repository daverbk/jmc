package minichallenges;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Challenge Number 1");
        challengeNumberOne();

        System.out.println("Challenge Number 2 and 3");
        System.out.println(challengeNumberTwoAndThree("1234567890"));

        System.out.println("Challenge Number 4 and 5");
        System.out.println(challengeNumberFourAndFive(s -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    result.append(s.charAt(i));
                }
            }
            return result.toString();
        }, "1234567890"));

        System.out.println("Challenge Number 6 and 7");
        System.out.println(challengeNumberSixAndSeven());
    }

    public static void challengeNumberOne() {
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] prats = s.split(" ");
                for (String part : prats) {
                    System.out.println(part);
                }
            }
        };

        String words = "Let's split this up into an array";
        Consumer<String> printWordsLambda =
                s -> Arrays.asList(s.split(" ")).forEach(part -> System.out.println(part));
        printWordsLambda.accept(words);
    }

    public static String challengeNumberTwoAndThree(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        // return returnVal.toString();

        UnaryOperator<String> getEverySecondChar = s -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    result.append(s.charAt(i));
                }
            }
            return result.toString();
        };

        return getEverySecondChar.apply(source);
    }

    public static String challengeNumberFourAndFive(UnaryOperator<String> operator, String source) {
        return operator.apply(source);
    }

    public static String challengeNumberSixAndSeven() {
        Supplier<String> supplier = () -> "I love Java!";
        return supplier.get();
    }
}


