package com.bankapp.File;

import com.bankapp.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountFileDAO {

    private final String FILE_PATH = "data/accounts.txt";

    public void saveAccount(Account acc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(acc.getAccountNumber() + "," +
                    acc.getCustomer().getCustomerID() + "," +
                    acc.getBalance() + "," +
                    acc.getClass().getSimpleName());
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Account> loadAccounts(List<Customer> customers) {
        List<Account> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split(",");

                String accNum = p[0];
                String custId = p[1];
                double bal = Double.parseDouble(p[2]);
                String type = p[3];

                Customer owner = customers.stream()
                        .filter(c -> c.getCustomerID().equals(custId))
                        .findFirst().orElse(null);

                if (owner == null) continue;

                Account acc;
                if (type.equals("SavingsAccount")) acc = new SavingsAccount(accNum, owner);
                else if (type.equals("ChequeAccount")) acc = new ChequeAccount(accNum, owner);
                else acc = new InvestmentAccount(accNum, owner);

                acc.setBalance(bal);
                list.add(acc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

