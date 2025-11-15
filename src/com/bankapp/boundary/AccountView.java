package com.bankapp.boundary;

import com.bankapp.controller.AccountController;
import com.bankapp.File.CustomerFileDAO;
import com.bankapp.File.AccountFileDAO;
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

        CustomerFileDAO cdao = new CustomerFileDAO();
        AccountFileDAO adao = new AccountFileDAO();

        createButton.setOnAction(e -> {

            String custType = customerTypeBox.getValue();
            String acctType = accountTypeBox.getValue();

            if (custType == null || acctType == null) {
                feedback.setText("⚠ Please select both customer type and account type.");
                return;
            }

            // CREATE CUSTOMER
            Customer customer = custType.equals("Individual")
                    ? new Individual("C" + (int)(Math.random()*9999), "user@gmail.com", new Date(), "Cathy", "lee", "ID123")
                    : new Company("C" + (int)(Math.random()*9999), "company@gmail.com", new Date(), "SparklesCorp", "RC222");

            cdao.saveCustomer(customer);  // save customer

            // CREATE ACCOUNT
            Account account;

            if (acctType.equals("Savings"))
                account = new SavingsAccount("A" + (int)(Math.random()*9999), customer);
            else if (acctType.equals("Investment"))
                account = new InvestmentAccount("A" + (int)(Math.random()*9999), customer);
            else
                account = new ChequeAccount("A" + (int)(Math.random()*9999), customer);

            adao.saveAccount(account);

            feedback.setText("✅ " + acctType + " Account created for " + customer.getCustomerID());
        });

        backButton.setOnAction(e -> new DashboardView().start(stage));

        VBox layout = new VBox(10, title, customerTypeLabel, customerTypeBox,
                accountTypeLabel, accountTypeBox, createButton, feedback, backButton);

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        stage.setScene(new Scene(layout, 400, 350));
        stage.show();

    }
}
