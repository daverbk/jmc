package constructorchallenge;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer();
        System.out.println(customer.name);
        System.out.println(customer.emailAddress);
        System.out.println(customer.creditLimit);

        Customer secondCustomer = new Customer("Harvey", "harvey@email.com", 1000);
        System.out.println(secondCustomer.name);
        System.out.println(secondCustomer.emailAddress);
        System.out.println(secondCustomer.creditLimit);
    }
}
