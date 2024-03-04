package setsmaps;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Emails", emails);
        printData("Phones", phones);
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(20));
        System.out.println(header);
        System.out.println("-".repeat(20));
        contacts.forEach(System.out::println);
    }
}
