/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guiexample1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    public static String currentlyLoggedIn = "";

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    void loginButtonPressed(ActionEvent event) throws IOException {
        if (!usernameField.getText().isEmpty()) {
            LoginController.currentlyLoggedIn = usernameField.getText();
            System.out.println("Logged in as: " + "<" + usernameField.getText() +">");
        } else {
            LoginController.currentlyLoggedIn = "";
        }
        App.setRoot("Search");
    }

    public void initialize() {

    }
}
