package com.bankapp.File;

import com.bankapp.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerFileDAO {

    private final String FILE_PATH = "data/customers.txt";

    public void saveCustomer(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            if (customer instanceof Individual ind) {
                writer.write(ind.getCustomerID() + "," +
                        ind.getEmail() + "," +
                        "Individual," +
                        ind.getFirstName() + "," +
                        ind.getLastName() + "," +
                        ind.getIdNumber());
            } else {
                Company comp = (Company) customer;
                writer.write(comp.getCustomerID() + "," +
                        comp.getEmail() + "," +
                        "Company," +
                        comp.getCompanyName() + "," +
                        comp.getRegistrationNumber());
            }

            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String id = parts[0];
                String email = parts[1];
                String type = parts[2];

                if (type.equals("Individual")) {
                    customers.add(new Individual(id, email, null, parts[3], parts[4], parts[5]));
                } else {
                    customers.add(new Company(id, email, null, parts[3], parts[4]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }
}
