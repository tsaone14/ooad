package com.bankapp.boundary;

import com.bankapp.model.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class CustomerView {
    public void start(Stage stage) {
        Label title = new Label("Select Customer");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        ListView<String> customerList = new ListView<>();
        customerList.getItems().addAll(" Katlego Mods  (Individual)", "SparklesByCath Ltd (Company)");

        Button viewButton = new Button("View Account");
        Button backButton = new Button("Back");
        Label feedback = new Label();

        viewButton.setOnAction(e -> {
            String selected = customerList.getSelectionModel().getSelectedItem();
            if (selected == null) {
                feedback.setText("⚠ Please select a customer.");
                return;
            }

            Customer customer;
            Account account;

            if (selected.contains("Katlego Mods")) {
                customer = new Individual("C001", "katmods@gmail.com", new Date(), "Katlego", "Mods", "ID-1111");
                account = new SavingsAccount("A001", customer);
                account.setBalance(1000);
            } else {
                customer = new Company("C002", "info@sparklesbycath.com", new Date(), "SparklesByCath Ltd", "RC-12345");
                account = new ChequeAccount("A002", customer);
                account.setBalance(5000);
            }

            // Open account details for selected customer
            new AccountDetailsView(customer, account).start(stage);
        });

        backButton.setOnAction(e -> new DashboardView().start(stage));

        VBox layout = new VBox(10, title, customerList, viewButton, feedback, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 350);
        stage.setTitle("Customer Accounts");
        stage.setScene(scene);
        stage.show();
    }
}
