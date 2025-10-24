package com.bankapp.controller;

import com.bankapp.model.Account;

public class TransactionController {

    public void makeDeposit(Account account, double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void makeWithdrawal(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds!");
            return;
        }

        if (account instanceof com.bankapp.model.Withdrawal) {
            ((com.bankapp.model.Withdrawal) account).withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } else {
            System.out.println("This account type does not support withdrawals!");
        }
    }
}
