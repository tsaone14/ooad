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

public class WithdrawView {
    public void start(Stage stage) {
        Label title = new Label("Withdraw Funds");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label accountLabel = new Label("Select Account Type:");
        ComboBox<String> accountBox = new ComboBox<>();
        accountBox.getItems().addAll("Savings", "Investment", "Cheque");

        Label amountLabel = new Label("Enter Amount:");
        TextField amountField = new TextField();

        Button withdrawButton = new Button("Withdraw");
        Button backButton = new Button("Back");
        Label feedback = new Label();

        Individual user = new Individual("C2", "client@gmail.com", new Date(), "Alice", "Smith", "9876");
        AccountController controller = new AccountController();

        withdrawButton.setOnAction(e -> {
            String selected = accountBox.getValue();
            String input = amountField.getText();

            if (selected == null || input.isEmpty()) {
                feedback.setText("⚠ Please select account and enter an amount.");
                return;
            }

            try {
                double amount = Double.parseDouble(input);
                Account account;

                if (selected.equals("Investment")) {
                    account = new InvestmentAccount("002", user);
                    account.setBalance(1000); // starting balance for demo
                } else if (selected.equals("Cheque")) {
                    account = new ChequeAccount("003", user);
                    account.setBalance(1500);
                } else {
                    feedback.setText("❌ Savings account does not support withdrawals.");
                    return;
                }

                controller.withdraw(account, amount);
                feedback.setText("✅ Withdrew " + amount + " from " + selected + " account.\nNew Balance: " + account.getBalance());
            } catch (NumberFormatException ex) {
                feedback.setText("❌ Please enter a valid numeric amount.");
            }
        });

        backButton.setOnAction(e -> {
            DashboardView dashboard = new DashboardView();
            dashboard.start(stage);
        });

        VBox layout = new VBox(10, title, accountLabel, accountBox, amountLabel, amountField, withdrawButton, feedback, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 350);
        stage.setTitle("Withdraw Funds");
        stage.setScene(scene);
        stage.show();
    }
}
