package bankingsystem.customers;

import java.util.Date;
import bankingsystem.accounts.Account;

public class Company extends Customer {
    private String companyName;
    private String registrationNo;
    private String contactPerson;

    public Company(String email, Date dateRegistered, String companyName, String registrationNo, String contactPerson) {
        super(email, dateRegistered);
        this.companyName = companyName;
        this.registrationNo = registrationNo;
        this.contactPerson = contactPerson;
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("Account added for company: " + companyName);
    }

    @Override
    public void getCustomerDetails() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Registration No: " + registrationNo);
        System.out.println("Contact Person: " + contactPerson);
        System.out.println("Email: " + email);
        System.out.println("Date Registered: " + dateRegistered);
    }
}
