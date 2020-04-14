/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp7.semproject.Presentation;

import java.io.IOException;

import grp7.semproject.Domain.DTO.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class CreditsController {

    public ListView castLV;
    public ListView audioLV;
    public ListView visualLV;
    public Button addCreditBtn;
    public Button removeCreditBtn;
    public Button editProductionIDBtn;
    public Button saveBtn;
    public TextField nameField;
    public TextField roleField;
    public TextField emailField;
    public TextField addressField;
    public TextField phoneField;
    public ToggleGroup rGroup1;
    public RadioButton castRadio;
    public RadioButton audioRadio;
    public RadioButton visualRadio;
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

    public void btnHandler(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addCreditBtn) {
            System.out.println("hej hans");
            String name = nameField.getText();
            String role = roleField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            Person person = new Person(name, role, address, phone, email);
            if (rGroup1.getSelectedToggle() == castRadio) {
                castList.add(person);
            } else if (rGroup1.getSelectedToggle() == audioRadio) {
                audioList.add(person);
            } else if (rGroup1.getSelectedToggle() == visualRadio) {
                visualList.add(person);
        }}

            if (actionEvent.getSource() == removeCreditBtn) {
                System.out.println("daa");

                Person selectedPerson = (Person) audioLV.getSelectionModel().getSelectedItem();
                if (selectedPerson != null){
                    audioList.remove(selectedPerson);
                }
                else {
                    selectedPerson = (Person) castLV.getSelectionModel().getSelectedItem();
                }

                if (selectedPerson != null){
                    castList.remove(selectedPerson);
                }
                else {
                    selectedPerson = (Person) visualLV.getSelectionModel().getSelectedItem();
                }

                if (selectedPerson != null){
                    visualList.remove(selectedPerson);
                }
                else {
                    System.out.println("wut?");
                }
            }
        if (actionEvent.getSource() == editProductionIDBtn) {
            System.out.println("edit");
        }
        if (actionEvent.getSource() == saveBtn) {
            System.out.println("save");
        }

    }
}
