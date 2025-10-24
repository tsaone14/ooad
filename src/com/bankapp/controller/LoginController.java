
package com.bankapp.controller;

public class LoginController {

    public boolean validateLogin(String username, String password) {
        // Simple mock authentication (later can connect to DB)
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        // For testing purposes — accept a single hardcoded user
        return username.equalsIgnoreCase("admin") && password.equals("1404");
    }
}
