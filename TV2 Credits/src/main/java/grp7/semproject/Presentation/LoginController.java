/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp7.semproject.Presentation;

import java.io.IOException;

import grp7.semproject.Domain.Facades.LoginFacade;
import grp7.semproject.Domain.UserTypes.User;
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
            switch (usernameField.getText().toLowerCase().trim()) {
                case "creditedperson":
                    currentlyLoggedIn = LoginFacade.loginAsCreditedPerson(usernameField.getText(), passwordField.getText());
                    break;
                case "producer":
                    currentlyLoggedIn = LoginFacade.LoginAsProducer(usernameField.getText(), passwordField.getText());
                    break;
                case "regdanmark":
                    currentlyLoggedIn = LoginFacade.LoginAsRegDanmark(usernameField.getText(), passwordField.getText());
                    break;
                case "systemadmin":
                    currentlyLoggedIn = LoginFacade.loginAsSystemAdmin(usernameField.getText(), passwordField.getText());
                    break;
                default:
                    System.out.println("Something wrong with that login...");
            }
            System.out.println("Logged in as: " + "<" + currentlyLoggedIn.getName() + ">");
        } else {
            LoginController.currentlyLoggedIn = null;
        }
        App.setRoot("Search");
    }

    public void initialize() {
        loginButton.isDefaultButton();
    }
}
