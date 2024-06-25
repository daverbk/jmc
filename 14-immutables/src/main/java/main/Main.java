package main;

import bank.AccountType;
import bank.Bank;
import bank.BankAccount;
import bank.BankCustomer;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(321231235);
        bank.addCustomer("Joe", 500.0, 10000.00);
        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

        if (bank.doTransaction(joe.getId(), AccountType.CHECKING, new BigDecimal(35))) {
            System.out.println(joe);
        }

        if (bank.doTransaction(joe.getId(), AccountType.CHECKING, BigDecimal.valueOf(-535))) {
            System.out.println(joe);
        }

        if (bank.doTransaction(joe.getId(), AccountType.CHECKING, BigDecimal.valueOf(-535.01))) {
            System.out.println(joe);
        }

        BankAccount checking = joe.getAccount(AccountType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
