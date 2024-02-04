import java.util.*;

public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        ArrayList<String> list = new ArrayList<>();

        while (flag) {
            printActions();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItems(list);
                case 2 -> removeItems(list);
                default -> flag = false;
            }
            list.sort(Comparator.naturalOrder());
            System.out.println("Current list state = " + list);
        }
    }

    private static void printActions() {
        String textBlock = """
                    Available actions:
                    0 - to shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove any items (comma delimited list)""";
        System.out.println(textBlock);
    }

    private static void addItems(ArrayList<String> groceries) {
        System.out.println("Add item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!groceries.contains(trimmed)) {
                groceries.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries) {
        System.out.println("Remove item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
        for (String item : items) {
            String trimmed = item.trim();
            groceries.remove(trimmed);
        }
    }
}
