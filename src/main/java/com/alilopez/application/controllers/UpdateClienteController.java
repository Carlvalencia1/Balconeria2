package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UpdateClienteController {

    @FXML
    private Label alertLabel;

    @FXML
    private Button closeButton;

    @FXML
    private TextField compradoTextField;

    @FXML
    private TextField gastadoTextField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField idTextField;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickSaveButton(MouseEvent event) {
        if (idTextField.getText().isEmpty() || compradoTextField.getText().isEmpty() || gastadoTextField.getText().isEmpty()){
            String contenido = "Ingrese todos los campos";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        } else{
            try{
                float comprado = Integer.parseInt(compradoTextField.getText());
                float gastado = Integer.parseInt(gastadoTextField.getText());
                if (App.getTienda().updateClient(idTextField.getText(), comprado, gastado)){
                    String contenido = "Cambios guardados!";
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
            } catch (NumberFormatException e){
                String contenido = "Ingrese número válidos";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        }

    }

    @FXML
    void initialize() {
    }

}
