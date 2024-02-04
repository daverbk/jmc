package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};

        Arrays.setAll(names, (i) -> names[i] = names[i].toUpperCase());
        System.out.println("--> All to upper case");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);
        backedByArray.replaceAll(s -> s + (" " + getRandomChar('A', 'Z') + "."));
        System.out.println("--> Add middle initial");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s + " " + getReversedName(s.split(" ")[0]));
        System.out.println("--> Add last name");
        backedByArray.forEach(s -> System.out.println(s));

        List<String> list = new ArrayList<>(backedByArray);
        list.removeIf(s -> s.substring(0, s.indexOf(" "))
                .equals(s.substring(s.lastIndexOf(" ") + 1)
                ));
        System.out.println("--> Delete name where first == last");
        list.forEach(s -> System.out.println(s));
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);

    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
