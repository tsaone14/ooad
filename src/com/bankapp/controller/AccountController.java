package com.bankapp.controller;

import com.bankapp.model.*;

public class AccountController {

    public void deposit(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        account.deposit(amount);
    }

    public void withdraw(Account account, double amount) {
        if (account instanceof Withdrawal) {
            if (amount > 0 && amount <= account.getBalance()) {
                ((Withdrawal) account).withdraw(amount);
            } else {
                System.out.println("Invalid or insufficient balance for withdrawal!");
            }
        } else {
            System.out.println("This account type does not support withdrawal!");
        }
    }

    public void calculateInterest(Account account) {
        if (account instanceof InterestBearing) {
            ((InterestBearing) account).calculateMonthlyInterest();
        } else {
            System.out.println("This account type does not bear interest!");
        }
    }
}
