package setsmaps;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Emails", emails);
        printData("Phones", phones);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("rhood@sherwoodforest.com", "rhood@sherwoodforest.org");
        System.out.println(robinHood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("A ∪ B Union of emails A and phones B", unionAB);

        Set<Contact> intersectionAB = new HashSet<>(emailContacts);
        intersectionAB.retainAll(phoneContacts);
        printData("A ∩ B Intersection of emails A and phones B", intersectionAB);

        Set<Contact> intersectionBA = new HashSet<>(phoneContacts);
        intersectionBA.retainAll(emailContacts);
        printData("B ∩ A Intersection of phones B and emails A", intersectionBA);

        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData("A - B emails A and phones B", AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);
        printData("B - A emails A and phones B", BMinusA);

        Set<Contact> symmetricDifference = new HashSet<>(AMinusB);
        symmetricDifference.addAll(BMinusA);
        printData("A Δ B Symmetric Difference of emails A and phones B", symmetricDifference);

        Set<Contact> symmetricDifference2 = new HashSet<>(unionAB);
        symmetricDifference2.removeAll(intersectionAB);
        printData("A Δ B Symmetric Difference of emails A and phones B", symmetricDifference2);
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(20));
        System.out.println(header);
        System.out.println("-".repeat(20));
        contacts.forEach(System.out::println);
    }
}
