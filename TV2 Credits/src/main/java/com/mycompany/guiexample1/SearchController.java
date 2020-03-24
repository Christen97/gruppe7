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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author micha
 */
public class SearchController {
    
    @FXML
    private ChoiceBox<String> dropdownMenu;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button redigerBrugereButton;

    @FXML
    private Button loginButton;

    @FXML
    void loginButtonPressed(ActionEvent event) throws IOException {
        if(LoginController.currentlyLoggedIn == ""){
            App.setRoot("Login");
        } else if (LoginController.currentlyLoggedIn != ""){
            LoginController.currentlyLoggedIn = "";
            System.out.println("logged out, so current login is: " + LoginController.currentlyLoggedIn);
            loginButton.setText("Login");
        }
    }

    @FXML
    void redigerBrugerPressed(ActionEvent event) throws IOException {
        App.setRoot("UserRights");
    }

    @FXML
    void searchButtonPressed(ActionEvent event) throws IOException {
        System.out.println("søger i: " + dropdownMenu.getValue());
        App.setRoot("Credits");
    }

    public void initialize (){
        System.out.println("Initializing...");
        
        //Adding menu items
        dropdownMenu.getItems().addAll("Programmer","Serier","Film","Personer");     
                
        //Setting default value of dropdown menu
        dropdownMenu.setValue("Programmer");
        
        if (LoginController.currentlyLoggedIn!=""){
            loginButton.setText("logout");
        } 
    }
    
}
