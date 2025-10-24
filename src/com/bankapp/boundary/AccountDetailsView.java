package com.bankapp.boundary;

import com.bankapp.controller.AccountController;
import com.bankapp.model.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

        Label customerLabel = new Label("Customer: " + customer.getEmail());
        Label accountLabel = new Label("Account Number: " + account.getAccountNumber());
        Label balanceLabel = new Label("Balance: " + account.getBalance());

        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button backButton = new Button("Back");
        Label feedback = new Label();

        depositButton.setOnAction(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                controller.deposit(account, amt);
                balanceLabel.setText("Balance: " + account.getBalance());
                feedback.setText("✅ Deposited " + amt);
            } catch (Exception ex) {
                feedback.setText("❌ Invalid amount.");
            }
        });

        withdrawButton.setOnAction(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                controller.withdraw(account, amt);
                balanceLabel.setText("Balance: " + account.getBalance());
                feedback.setText("✅ Withdrew " + amt);
            } catch (Exception ex) {
                feedback.setText("❌ Invalid amount.");
            }
        });

        backButton.setOnAction(e -> new CustomerView().start(stage));

        VBox layout = new VBox(10, title, customerLabel, accountLabel, balanceLabel,
                amountField, depositButton, withdrawButton, feedback, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 400);
        stage.setTitle("Account Details");
        stage.setScene(scene);
        stage.show();
    }
}
