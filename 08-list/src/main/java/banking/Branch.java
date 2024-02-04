package banking;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction) {
        Customer customer = findCustomer(name);

        return customer == null && customers.add(new Customer(name, initialTransaction));
    }

    public boolean addCustomerTransaction(String name, double transaction) {
        Customer customer = findCustomer(name);

        if (customer == null) {
            return false;
        }

        customer.addTransaction(transaction);
        return true;
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }

        return null;
    }
}
