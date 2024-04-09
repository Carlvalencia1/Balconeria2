package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class UpdateProductoController {

    @FXML
    private Label alertLabel;

    @FXML
    private Button closeButton;

    @FXML
    private TextField cantidadTextField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField precioTextField;

    @FXML
    private TextField costoTextField;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onActionTipoComboBox(ActionEvent event) {}

    @FXML
    void onClickSaveButton(MouseEvent event) {
        float precio = 0;
        float costo = 0;
        String tipo = tipoComboBox.getValue();
        if (!(tipoComboBox.getValue() == null)){
            if (precioTextField.getText().isEmpty() && costoTextField.getText().isEmpty()) {
                try {
                    double cantidad = Integer.parseInt(cantidadTextField.getText());
                    if(App.getTienda().updateProduct(tipo, cantidad)){
                        String contenido = "Cantidad cambiada!";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    } else {
                        String contenido = "No se pudo realizar el cambio";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    }
                } catch (NumberFormatException e){
                    String contenido = "numero invalido";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }

            } else {
                try {
                    double cantidad = Integer.parseInt(cantidadTextField.getText());
                    precio = Integer.parseInt(precioTextField.getText());
                    costo = Integer.parseInt(costoTextField.getText());
                    if(App.getTienda().updateProduct(tipo, cantidad, precio, costo)){
                        String contenido = "Cambios guardados!";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    } else {
                        String contenido = "No se pudo realizar los cambios";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    }
                } catch (NumberFormatException e){
                    String contenido = "Número invalido ó Campo sin llenar";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }
            }


        } else {
            String contenido = "Seleccione un tipo de producto";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        }


    }

    @FXML
    void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList(App.getTienda().getTiposProductos());
        tipoComboBox.setItems(list);
    }

}
