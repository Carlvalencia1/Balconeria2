package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RemoveClienteController {

    @FXML
    private Label alertLabel;

    @FXML
    private Button closeButton;

    @FXML
    private TextField idTextfield;

    @FXML
    private Button removeButton;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickRemoveButton(MouseEvent event) {
        String id = idTextfield.getText();
        if (App.getTienda().deleteCliente(id)){
            String contenido = "Se eliminó correctamente";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        } else {
            String contenido = "No se pudo eliminar";
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
