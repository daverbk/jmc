package methodreferencechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};

        List<UnaryOperator<String>> operations = new ArrayList<>(List.of(
                String::toUpperCase,
                Main::addMiddleName,
                Main::addLastName
        ));

        applyChanges(names, operations);
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);

    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }

    private static String addMiddleName(String s) {
        return String.join(" ", s, String.valueOf(getRandomChar('A', 'Z')));
    }

    private static String addLastName(String s) {
        return s + " " + getReversedName(s.split(" ")[0]);
    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> operations) {
        List<String> namesBacked = new ArrayList<>(List.of(names));
        operations.forEach(o -> {
            namesBacked.replaceAll(s -> s.transform(o));
            System.out.println(namesBacked);
        });
    }
}
