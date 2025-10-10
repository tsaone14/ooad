package bankingsystem.customers;

import java.util.Date;
import bankingsystem.accounts.Account;

public class Individual extends Customer {
    private String firstName;
    private String lastName;
    private String nationalId;

    public Individual(String email, Date dateRegistered, String firstName, String lastName, String nationalId) {
        super(email, dateRegistered);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("Account added for individual: " + firstName + " " + lastName);
    }

    @Override
    public void getCustomerDetails() {
        System.out.println("Customer Name: " + firstName + " " + lastName);
        System.out.println("National ID: " + nationalId);
        System.out.println("Email: " + email);
        System.out.println("Date Registered: " + dateRegistered);
    }
}
