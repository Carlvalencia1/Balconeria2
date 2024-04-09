package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BuscarClienteController {

    @FXML
    private Label alertLabel;

    @FXML
    private Button closeButton;

    @FXML
    private TextField idTextfield;

    @FXML
    private Button buscarButton;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickBuscarButton(MouseEvent event) {
        String contenido = null;
        if (App.getTienda().searchCliente(idTextfield.getText()) == null){
            contenido = "No se encontro un cliente con ese ID";
        } else{
            contenido = "Cliente:\n" + App.getTienda().searchCliente(idTextfield.getText());
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    @FXML
    void initialize() {
    }

}
