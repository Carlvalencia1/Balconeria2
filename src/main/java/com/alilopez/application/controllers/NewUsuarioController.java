package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Cliente;
import com.alilopez.application.models.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.UUID;

public class NewUsuarioController {

    @FXML
    private Button closeButton;

    @FXML
    private Label alertLabel;

    @FXML
    private ComboBox<String> cargoComboBox;

    @FXML
    private TextField correoTextField;

    @FXML
    private Button saveButton;
    @FXML
    private TextField lastnameTextfield;

    @FXML
    private TextField nombreTextfield;

    @FXML
    private TextField edadTextfield;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }
    @FXML
    void onClickSaveButton(MouseEvent event) {
        if (!(nombreTextfield.getText().isEmpty() || lastnameTextfield.getText().isEmpty() || correoTextField.getText().isEmpty() || edadTextfield.getText().isEmpty() || idTextField.getText().isEmpty() || passwordTextField.getText().isEmpty())){
            try{
                String nombre = nombreTextfield.getText();
                String apellido = lastnameTextfield.getText();
                String correo = correoTextField.getText();
                String cargo = cargoComboBox.getValue();
                String id = idTextField.getText();
                String password = passwordTextField.getText();
                int edad = Integer.parseInt(edadTextfield.getText());
                if (edad >= 14 && edad <= 100) {
                    if (!(cargoComboBox.getValue() == null)){
                        Usuario user = new Usuario(nombre, apellido, correo, cargo, edad, id, password);
                        if (!App.getTienda().addUsuario(user)){
                            String contenido = "Registro Exitoso";
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText(contenido);
                            alert.showAndWait();
                        } else {
                            String contenido = "Este ID ya fue registrado";
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText(contenido);
                            alert.showAndWait();
                        }
                    } else {
                        String contenido = "Seleccione un cargo";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    }
                } else {
                    String contenido = "Ingrese una edad valida";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }

            } catch (NumberFormatException e){
                String contenido = "Ingrese números en la edad";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        } else {
            String contenido = "Rellene todos los campos";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        }



    }

    @FXML
    void selectComboBox(ActionEvent event) {

    }
    @FXML
    void initialize() {
        ObservableList <String> list = FXCollections.observableArrayList("Empleado", "Capturista");
        cargoComboBox.setItems(list);
    }

}
