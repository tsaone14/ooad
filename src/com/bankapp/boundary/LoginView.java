package com.bankapp.boundary;

import com.bankapp.controller.LoginController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginView {
    public void start(Stage stage) {
        Label title = new Label("Banking System Login");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Button exitButton = new Button("Exit");

        Label feedback = new Label();

        // Layout setup
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(title, 0, 0, 2, 1);
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(loginButton, 0, 3);
        grid.add(exitButton, 1, 3);
        grid.add(feedback, 0, 4, 2, 1);

        // Controller connection
        LoginController controller = new LoginController();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean success = controller.validateLogin(username, password);
            if (success) {
                feedback.setText("Login successful!");
                DashboardView dashboard = new DashboardView();
                dashboard.start(stage); // switch to dashboard
            } else {
                feedback.setText("Invalid credentials. Try admin / 1404");
            }
        });

        exitButton.setOnAction(e -> stage.close());

        Scene scene = new Scene(grid, 400, 250);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}
