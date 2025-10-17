package com.bankapp.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DepositView {
    public void start(Stage stage) {
        Label title = new Label("Deposit Funds");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label accountLabel = new Label("Select Account:");
        ComboBox<String> accountBox = new ComboBox<>();
        accountBox.getItems().addAll("Savings", "Investment", "Cheque");

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Button confirmButton = new Button("Confirm");
        Button backButton = new Button("Back");

        VBox layout = new VBox(10, title, accountLabel, accountBox, amountLabel, amountField, confirmButton, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("Deposit Funds");
        stage.setScene(scene);
        stage.show();
    }
}
