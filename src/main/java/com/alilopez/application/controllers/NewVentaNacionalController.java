package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class NewVentaNacionalController {

    @FXML
    private Label alertLabel;

    @FXML
    private TextField cantidadTxt;

    @FXML
    private Button closeButton;

    @FXML
    private TextField costoEnvioTxt;

    @FXML
    private Button saveButton;

    @FXML
    private TextField direccionTxt;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    void onActionTipoComboBox(ActionEvent event) {

    }

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickSaveButton(MouseEvent event) {
        float costoEnvio;
        float cantidad;
        if (costoEnvioTxt.getText().isEmpty() || cantidadTxt.getText().isEmpty() || direccionTxt.getText().isEmpty() || tipoComboBox.getValue() == null) {
            String contenido = "Rellene todos los campos";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        } else {
            try {
                costoEnvio = Float.parseFloat(costoEnvioTxt.getText());
                cantidad = Float.parseFloat(cantidadTxt.getText());
                String direccion = direccionTxt.getText();
                String tipo = tipoComboBox.getValue();
                if (App.getTienda().addVentaNacional(cantidad, tipo, costoEnvio, direccion)) {
                    String contenido = "Venta Registrada";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                } else {
                    String contenido = "No se pudo completar la operación";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                String contenido = "Ingrese un número válido";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        }
    }
    @FXML
    void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList(App.getTienda().getTiposProductos());
        tipoComboBox.setItems(list);
    }

}
