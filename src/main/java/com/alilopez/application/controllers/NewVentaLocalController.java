package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class NewVentaLocalController {

    @FXML
    private Label alertLabel;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    private TextField cantidadTxt;

    @FXML
    private Button closeButton;

    @FXML
    private TextField descuentoTxt;

    @FXML
    private Button saveButton;


    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onClickSaveButton(MouseEvent event) {
        if (cantidadTxt.getText().isEmpty() || tipoComboBox.getValue() == null) {
            String contenido = "Rellene los campos mínimos";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        } else {
            try {
                float descuento;
                double cantidad = Integer.parseInt(cantidadTxt.getText());
                if (descuentoTxt.getText().isEmpty()) {
                    descuento = 0;
                } else {
                    descuento = Integer.parseInt(descuentoTxt.getText());
                }
                String tipo = tipoComboBox.getValue();
                if (App.getTienda().addVentaLocal(cantidad, tipo, descuento)) {
                    String contenido = "Venta Registrada";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                } else {
                    String contenido = "No se pudo realizar la venta";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }
            } catch (NumberFormatException e){
                String contenido = "Ingrese dígitos válidos";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onActionTipoComboBox(ActionEvent event) {

    }
    @FXML
    void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList(App.getTienda().getTiposProductos());
        tipoComboBox.setItems(list);
    }

}
