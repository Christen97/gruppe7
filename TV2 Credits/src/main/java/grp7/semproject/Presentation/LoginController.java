/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp7.semproject.Presentation;

import java.io.IOException;

import grp7.semproject.Domain.UserTypes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    public static User currentlyLoggedIn = null;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    void loginButtonPressed(ActionEvent event) throws IOException {
        if (!usernameField.getText().isEmpty()) {
            switch(usernameField.getText().toLowerCase().trim()) {
                case "creditedperson":
                    currentlyLoggedIn = new CreditedPerson(1, usernameField.getText(), passwordField.getText(), "CreditedPerson-Test");
                    break;
                case "producer":
                    currentlyLoggedIn = new Producer(1, usernameField.getText(), passwordField.getText(), "Producer-Test");
                    break;
                case "regdanmark":
                    currentlyLoggedIn = new RegDanmark(1, usernameField.getText(), passwordField.getText(), "RegDanmark-Test");
                    break;
                case "systemadmin":
                    currentlyLoggedIn = new SystemAdmin(1, usernameField.getText(), passwordField.getText(), "SystemAdmin-Test");
                    break;
                default:
                    System.out.println("Something wrong with that login...");
            }
            System.out.println("Logged in as: " + "<" + currentlyLoggedIn.getName() +">");
        } else {
            LoginController.currentlyLoggedIn = null;
        }
        App.setRoot("Search");
    }

    public void initialize() {

    }
}
