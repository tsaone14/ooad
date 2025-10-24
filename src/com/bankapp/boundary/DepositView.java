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

public class DepositView {
    public void start(Stage stage) {
        Label title = new Label("Deposit Funds");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label accountLabel = new Label("Select Account Type:");
        ComboBox<String> accountBox = new ComboBox<>();
        accountBox.getItems().addAll("Savings", "Investment", "Cheque");

        Label amountLabel = new Label("Enter Amount:");
        TextField amountField = new TextField();

        Button depositButton = new Button("Deposit");
        Button backButton = new Button("Back");
        Label feedback = new Label();

        // Create mock user and controller
        Individual user = new Individual("C1", "user@gmail.com", new Date(), "John", "Doe", "1234");
        AccountController controller = new AccountController();

        depositButton.setOnAction(e -> {
            String selected = accountBox.getValue();
            String input = amountField.getText();

            if (selected == null || input.isEmpty()) {
                feedback.setText("⚠ Please select account and enter an amount.");
                return;
            }

            try {
                double amount = Double.parseDouble(input);
                Account account;

                // Pick which account type to simulate
                if (selected.equals("Savings")) {
                    account = new SavingsAccount("001", user);
                } else if (selected.equals("Investment")) {
                    account = new InvestmentAccount("002", user);
                } else {
                    account = new ChequeAccount("003", user);
                }

                controller.deposit(account, amount);
                feedback.setText("✅ Deposited " + amount + " into " + selected + " account.\nNew Balance: " + account.getBalance());
            } catch (NumberFormatException ex) {
                feedback.setText("❌ Please enter a valid numeric amount.");
            }
        });

        backButton.setOnAction(e -> {
            DashboardView dashboard = new DashboardView();
            dashboard.start(stage);
        });

        VBox layout = new VBox(10, title, accountLabel, accountBox, amountLabel, amountField, depositButton, feedback, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 350);
        stage.setTitle("Deposit Funds");
        stage.setScene(scene);
        stage.show();
    }
}
