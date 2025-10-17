package com.bankapp.model;

import java.util.Date;

public class Company extends Customer {
    private String companyName;
    private String registrationNumber;

    public Company(String customerID, String email, Date dateRegistered, String companyName, String registrationNumber) {
        super(customerID, email, dateRegistered);
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public void getCustomerDetails() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Company Name: " + companyName);
        System.out.println("Email: " + email);
        System.out.println("Registered: " + dateRegistered);
        System.out.println("Reg Number: " + registrationNumber);
    }
}

