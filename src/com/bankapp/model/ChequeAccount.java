package com.bankapp.model;
public class ChequeAccount extends Account implements Withdrawal, InterestBearing {
    private static final double INTEREST_RATE = 0.075;

    public ChequeAccount(String accountNumber, Customer owner) {
        super(accountNumber, owner);
        this.customer = owner;
    }

    @Override
    public void calculateMonthlyInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest of " + interest + " added. New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public String getAccountType() {
        return "Cheque Account";
    }
}
