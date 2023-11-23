package mobilephone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        return removeContact(oldContact) && addNewContact(newContact);
    }

    public boolean addNewContact(Contact contact) {
        boolean notPresent = queryContact(contact.getName()) == null;

        if (notPresent) {
            myContacts.add(contact);
        }

        return notPresent;
    }

    public boolean removeContact(Contact contact) {
        return myContacts.remove(contact);
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.printf("%d. %s -> %s%n", i + 1, contact.getName(), contact.getPhoneNumber());
        }
    }

    public Contact queryContact(String name) {
        int index = findContact(name);

        return index >= 0 ? myContacts.get(index) : null;
    }

    private int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }
}
