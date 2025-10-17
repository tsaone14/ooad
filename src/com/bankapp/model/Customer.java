package com.bankapp.model;

import java.util.Date;

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

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public abstract void getCustomerDetails();
}