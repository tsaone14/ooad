package com.bankapp.model;

public class SavingsAccount extends Account implements InterestBearing {
    private static final double INTEREST_RATE = 0.025;

    public SavingsAccount(String accountNumber, Customer owner) {
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
    public String getAccountType() {
        return "Savings Account";
    }
}

