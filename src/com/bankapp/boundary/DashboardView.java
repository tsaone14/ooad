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

        Button accountButton = new Button("Manage Accounts");
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button logoutButton = new Button("Logout");

        VBox layout = new VBox(15, title, accountButton, depositButton, withdrawButton, logoutButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
