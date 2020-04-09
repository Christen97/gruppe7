/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp7.semproject.Presentation;

import java.io.IOException;

import grp7.semproject.Domain.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


public class CreditsController {

    public ListView castLV;
    public ListView audioLV;
    public ListView visualLV;
    @FXML
    private Button backButton;

    @FXML
    void backButtonPressed(ActionEvent event) throws IOException {
        App.setRoot("Search");
    }

    ObservableList<Person> castList, audioList, visualList;

    public void initialize() {
        castList = FXCollections.observableArrayList();
        castLV.setItems(castList);
        audioList = FXCollections.observableArrayList();
        audioLV.setItems(audioList);
        visualList = FXCollections.observableArrayList();
        visualLV.setItems(visualList);
    }
}
