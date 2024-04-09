package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Cafe;
import com.alilopez.application.models.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.UUID;

public class NewProductController {

    @FXML
    private Button closeButton;

    @FXML
    private Label alertLabel;

    @FXML
    private TextField precioTextField;

    @FXML
    private Button saveButton;
    @FXML
    private TextField costoTextField;

    @FXML
    private TextField nombreTextfield;
    @FXML
    private TextField pesoTextField;
    @FXML
    private TextField cantidadTextField;
    @FXML
    private TextField tipoTextField;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }
    @FXML
    void onClickSaveButton(MouseEvent event) {
        if (!(precioTextField.getText().isEmpty() || tipoTextField.getText().isEmpty() || costoTextField.getText().isEmpty() || precioTextField.getText().isEmpty() || pesoTextField.getText().isEmpty() || cantidadTextField.getText().isEmpty())){
            try{
                String nombre = nombreTextfield.getText();
                String tipo = tipoTextField.getText();
                float costo = Integer.parseInt(costoTextField.getText());
                float precio = Integer.parseInt(precioTextField.getText());
                float peso = Integer.parseInt(pesoTextField.getText());
                float cantidad = Integer.parseInt(cantidadTextField.getText());
                Cafe cafe = new Cafe(precio, peso, nombre, cantidad, tipo, costo);
                if (cantidad > 0 && costo > 0 && precio > 0 && peso > 0) {
                    if (App.getTienda().addProducto(cafe)) {
                        String contenido = "Se agregó exitósamente";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    } else {
                        String contenido = "Tipo de producto ya existente";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText(contenido);
                        alert.showAndWait();
                    }
                } else {
                    String contenido = "Ingrese números válidos";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }
            } catch (NumberFormatException e){
                String contenido = "Ingrese números válidos";
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
    void initialize() {
    }
}
