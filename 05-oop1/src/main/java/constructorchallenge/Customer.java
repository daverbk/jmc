package constructorchallenge;

public class Customer {
    String name;
    String emailAddress;
    double creditLimit;

    public Customer() {
        this("Undefined", "Undefined", 0);
    }

    public Customer(String name, String emailAddress) {
        this(name, emailAddress, 0);
    }

    public Customer(String name, String emailAddress, double creditLimit) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
