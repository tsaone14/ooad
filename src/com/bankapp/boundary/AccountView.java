package com.bankapp.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountView {
    public void start(Stage stage) {
        Label title = new Label("Account Management");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        ListView<String> accountList = new ListView<>();
        accountList.getItems().addAll(
                "Savings Account - #001",
                "Investment Account - #002",
                "Cheque Account - #003"
        );

        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button backButton = new Button("Back");

        VBox layout = new VBox(10, title, accountList, depositButton, withdrawButton, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("Account Management");
        stage.setScene(scene);
        stage.show();
    }
}
