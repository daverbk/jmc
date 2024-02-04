package classchallenge;

public class Account {
    private double balance;
    private String number;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account() {
        this(2.5, "56789", "Default name",
                "Default address", "Default phone");

        System.out.println("Empty constructor called");
    }

    public Account(double balance, String number, String customerName, String email, String phoneNumber) {
        System.out.println("Account constructor with parameters called");
        this.balance = balance;
        this.number = number;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Incorrect value");
        } else {
            balance += amount;
            System.out.println("Deposit went successful. Current balance " + balance);
        }
    }

    public void withdraw(int amount) {
        if ((balance - amount) < 0 || amount <= 0) {
            System.out.println("Incorrect amount or not enough amount on the balance");
        } else {
            balance -= amount;
            System.out.println(amount
                    + " has been withdrawn from the account. Current balance is "
                    + balance);
        }
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
