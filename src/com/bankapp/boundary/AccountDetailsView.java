package com.bankapp.boundary;

import com.bankapp.controller.AccountController;
import com.bankapp.File.AccountFileDAO;
import com.bankapp.File.CustomerFileDAO;
import com.bankapp.model.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class AccountDetailsView {

    private final Customer customer;
    private final Account account;
    private final AccountController controller = new AccountController();

    public AccountDetailsView(Customer customer, Account account) {
        this.customer = customer;
        this.account = account;
    }

    public void start(Stage stage) {

        Label title = new Label("Account Details");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label custLabel = new Label("Customer: " + customer.getCustomerID());
        Label accLabel = new Label("Account Number: " + account.getAccountNumber());
        Label balLabel = new Label("Balance: " + account.getBalance());

        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        Button depositBtn = new Button("Deposit");
        Button withdrawBtn = new Button("Withdraw");
        Button backButton = new Button("Back");
        Label feedback = new Label();

        depositBtn.setOnAction(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                controller.deposit(account, amt);
                saveUpdatedBalance();
                balLabel.setText("Balance: " + account.getBalance());
                feedback.setText("✅ Deposited " + amt);
            } catch (Exception ex) {
                feedback.setText("❌ Invalid amount.");
            }
        });

        withdrawBtn.setOnAction(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                controller.withdraw(account, amt);
                saveUpdatedBalance();
                balLabel.setText("Balance: " + account.getBalance());
                feedback.setText("✅ Withdrew " + amt);
            } catch (Exception ex) {
                feedback.setText("❌ Invalid amount.");
            }
        });

        backButton.setOnAction(e -> new CustomerView().start(stage));

        VBox layout = new VBox(10, title, custLabel, accLabel, balLabel,
                amountField, depositBtn, withdrawBtn, feedback, backButton);

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        stage.setScene(new Scene(layout, 400, 400));
        stage.show();
    }

    private void saveUpdatedBalance() {
        CustomerFileDAO cdao = new CustomerFileDAO();
        AccountFileDAO adao = new AccountFileDAO();

        List<Customer> customers = cdao.loadCustomers();
        List<Account> accounts = adao.loadAccounts(customers);

        for (Account a : accounts) {
            if (a.getAccountNumber().equals(account.getAccountNumber())) {
                a.setBalance(account.getBalance());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/accounts.txt"))) {
            for (Account a : accounts) {
                writer.write(a.getAccountNumber() + "," +
                        a.getCustomer().getCustomerID() + "," +
                        a.getBalance() + "," +
                        a.getClass().getSimpleName());
                writer.newLine();
            }
        } catch (Exception ignored) { }
    }
}
