/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp7.semproject.Presentation;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 *
 * @author micha
 */
public class UserRightsController {
    
    @FXML
    private Button BackButton;

    @FXML
    void BackButtonPressed(ActionEvent event) throws IOException {
        App.setRoot("Search");
    }

}
