package linkedlistchallenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Destinations {
    private LinkedList<Destination> list;
    private ListIterator<Destination> iterator;

    public Destinations(LinkedList<Destination> list) {
        this.list = list;
        this.iterator = list.listIterator();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            printActions();
            switch (scanner.nextLine().toLowerCase()) {
                case "forward", "f" -> {
                    if (iterator.hasNext()) {
                        System.out.println("Moved forward to: " + iterator.next().getTown());
                    }
                }
                case "backward", "b" -> {
                    if (iterator.hasPrevious()) {
                        System.out.println("Moved backward to: " + iterator.previous().getTown());
                    }
                }
                case "list places", "l" -> {
                    for (Destination destination : list) {
                        System.out.println("--> " + destination.getTown());
                    }
                }
                default -> flag = false;
            }
        }
    }

    private void printActions() {
        String textBlock = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """;

        System.out.println(textBlock);
    }
}
