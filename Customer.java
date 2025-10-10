package bankingsystem.customers;

import java.util.Date;
import bankingsystem.accounts.Account;

public abstract class Customer {
    protected String customerID;    
    protected String email;
    protected Date dateRegistered;

    public Customer(String customerID, String email, Date dateRegistered) {
        this.customerID = customerID;
        this.email = email;
        this.dateRegistered = dateRegistered;
    }

    public String getCustomerID() {
        return customerID;
    }

    public abstract void addAccount(Account account);
    public abstract void getCustomerDetails();
}

