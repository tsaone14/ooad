package com.bankapp.model;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected Customer customer;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public abstract String getAccountType();

    public static class InvestmentAccount extends Account implements Withdrawal {
        public InvestmentAccount(String accountNumber, Customer owner) {
            super(accountNumber, owner);
            this.customer = owner;
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
            return "Investment Account";
        }
    }
}

