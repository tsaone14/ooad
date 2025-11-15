package com.bankapp.boundary;

import com.bankapp.File.CustomerFileDAO;
import com.bankapp.File.AccountFileDAO;
import com.bankapp.model.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class CustomerView {

    public void start(Stage stage) {

        Label title = new Label("Select Customer");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        ListView<String> customerList = new ListView<>();

        CustomerFileDAO cdao = new CustomerFileDAO();
        List<Customer> customers = cdao.loadCustomers();

        for (Customer c : customers) {
            customerList.getItems().add(c.getCustomerID() + " (" + c.getEmail() + ")");
        }

        Button viewButton = new Button("View Account");
        Button backButton = new Button("Back");
        Label feedback = new Label();

        viewButton.setOnAction(e -> {
            int index = customerList.getSelectionModel().getSelectedIndex();
            if (index < 0) {
                feedback.setText("⚠ Please select a customer.");
                return;
            }

            Customer selectedCustomer = customers.get(index);

            AccountFileDAO adao = new AccountFileDAO();
            List<Account> accounts = adao.loadAccounts(customers);

            Account selectedAccount = null;

            for (Account a : accounts) {
                if (a.getCustomer().getCustomerID().equals(selectedCustomer.getCustomerID())) {
                    selectedAccount = a;
                    break;
                }
            }

            if (selectedAccount == null) {
                feedback.setText("⚠ Customer has no account yet.");
                return;
            }

            new AccountDetailsView(selectedCustomer, selectedAccount).start(stage);
        });

        backButton.setOnAction(e -> new DashboardView().start(stage));

        VBox layout = new VBox(10, title, customerList, viewButton, feedback, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        stage.setScene(new Scene(layout, 400, 350));
        stage.show();
    }
}
