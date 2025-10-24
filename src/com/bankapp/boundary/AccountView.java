package com.bankapp.boundary;

import com.bankapp.controller.AccountController;
import com.bankapp.model.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Date;

public class AccountView {
    public void start(Stage stage) {
        Label title = new Label("Open Account");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label customerTypeLabel = new Label("Select Customer Type:");
        ComboBox<String> customerTypeBox = new ComboBox<>();
        customerTypeBox.getItems().addAll("Individual", "Company");

        Label accountTypeLabel = new Label("Select Account Type:");
        ComboBox<String> accountTypeBox = new ComboBox<>();
        accountTypeBox.getItems().addAll("Savings", "Investment", "Cheque");

        Button createButton = new Button("Create Account");
        Button backButton = new Button("Back");
        Label feedback = new Label();

        AccountController controller = new AccountController();

        createButton.setOnAction(e -> {
            String customerType = customerTypeBox.getValue();
            String accountType = accountTypeBox.getValue();

            if (customerType == null || accountType == null) {
                feedback.setText("⚠ Please select both customer and account type.");
                return;
            }

            // Create the right customer object
            Customer customer;
            if (customerType.equals("Individual")) {
                customer = new Individual("C101", "jane@bank.com", new Date(), "Jane", "Doe", "12345678");
            } else {
                customer = new Company("C202", "info@techcorp.com", new Date(), "TechCorp", "RC-998877");
            }

            // Create account and link customer
            Account account;
            if (accountType.equals("Savings")) {
                account = new SavingsAccount("A001", customer);
            } else if (accountType.equals("Investment")) {
                account = new InvestmentAccount("A002", customer);
            } else {
                account = new ChequeAccount("A003", customer);
            }

            // Example controller call
            controller.deposit(account, 500);
            feedback.setText("✅ " + customerType + " customer " + " opened a " + accountType + " account successfully!");
        });

        backButton.setOnAction(e -> new DashboardView().start(stage));

        VBox layout = new VBox(10, title, customerTypeLabel, customerTypeBox,
                accountTypeLabel, accountTypeBox, createButton, feedback, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 350);
        stage.setTitle("Account Creation");
        stage.setScene(scene);
        stage.show();
    }
}
