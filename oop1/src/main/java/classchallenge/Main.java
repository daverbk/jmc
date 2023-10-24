package classchallenge;

public class Main {

    public static void main(String[] args) {

        Account bobsAccount = new Account(1000.00, "12345",
                "Bob Brown", "myemail@bob.com",
                "(087) 123-4567");

        bobsAccount.deposit(100);
        bobsAccount.withdraw(200);

        Account account = new Account();
        account.deposit(1000);
        account.withdraw(500);

        account.withdraw(600);
        account.deposit(-1000);
        account.deposit(0);
        account.withdraw(0);
        account.withdraw(-100);
    }
}
