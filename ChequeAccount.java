package bankingsystem.accounts;

import bankingsystem.interfaces.Withdraw;
import bankingsystem.customers.owner;

public class ChequeAccount extends Account implements Withdraw {

    public ChequeAccount(String accountNumber, Customer owner ) {
        super(accountNumber, "Cheque", customer);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Cheque Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Cheque Account.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
