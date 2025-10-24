package com.bankapp.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardView {
    public void start(Stage stage) {
        Label title = new Label("Bank Dashboard");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button depositButton = new Button("Deposit Funds");
        Button withdrawButton = new Button("Withdraw Funds");
        Button accountButton = new Button("Manage Accounts");
        Button logoutButton = new Button("Logout");
        Button customersButton = new Button("View Customers");

        depositButton.setOnAction(e -> new DepositView().start(stage));
        withdrawButton.setOnAction(e -> new WithdrawView().start(stage));
        accountButton.setOnAction(e -> new AccountView().start(stage));
        logoutButton.setOnAction(e -> new LoginView().start(stage));
        customersButton.setOnAction(e -> new CustomerView().start(stage));

        VBox layout = new VBox(15, title, depositButton, withdrawButton, accountButton, customersButton  ,logoutButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
