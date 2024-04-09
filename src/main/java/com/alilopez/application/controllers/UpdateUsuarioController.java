package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UpdateUsuarioController {

    @FXML
    private Label alertLabel;


    @FXML
    private Button closeButton;


    @FXML
    private TextField edadTextField;

    @FXML
    private TextField passTxt;

    @FXML
    private TextField idTextField;


    @FXML
    private Button saveButton;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickSaveButton(MouseEvent event) {
        String pass = passTxt.getText();
        String id = idTextField.getText();

        if (!id.isEmpty()) {
            if (edadTextField.getText().isEmpty()) {
                if (pass.isEmpty()) {
                    String contenido = "Rellene el campo de contraseña";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                } else {
                    if (App.getTienda().updateUsuario(id, pass)) {
                        String contenido = "Contraseña cambiada";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    } else {
                        String contenido = "No se pudo cambiar la contraseña";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    }
                }
            } else {
                try {
                    int edad = Integer.parseInt(edadTextField.getText());
                    if (edad >= 14 && edad <= 100) {
                        if (App.getTienda().updateUsuario(id, edad, pass)) {
                            String contenido = "Cambios Realizados!";
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText(contenido);
                            alert.showAndWait();
                        } else {
                            String contenido = "No se pudieron realizar lo cambios";
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText(contenido);
                            alert.showAndWait();
                        }
                    } else {
                        String contenido = "Ingrese una edad válida";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    }
                } catch (NumberFormatException e){
                    String contenido = "Número inválido";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }
            }
        } else {
            String contenido = "Ingrese el ID";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
    }

}
