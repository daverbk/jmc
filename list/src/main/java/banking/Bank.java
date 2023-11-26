package banking;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public boolean addBranch(String name) {
        Branch branch = findBranch(name);

        return branch == null && branches.add(new Branch(name));
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);

        return branch != null && branch.newCustomer(customerName, initialTransaction);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);

        return branch != null && branch.addCustomerTransaction(customerName, transaction);
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        System.out.println("Customer details for branch " + branchName);
        ArrayList<Customer> customers = branch.getCustomers();

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.printf("Customer: %s[%d]%n", customer.getName(), i + 1);
            if (printTransactions) {
                System.out.println("Transactions");
                for (int j = 0; j < customer.getTransactions().size(); j++) {
                    System.out.printf("[%d] Amount %.2f%n", j + 1, customer.getTransactions().get(j));
                }
            }
        }

        return true;
    }

    private Branch findBranch(String name) {
        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(name)) {
                return branch;
            }
        }

        return null;
    }
}
