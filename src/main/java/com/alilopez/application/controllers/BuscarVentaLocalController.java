package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.VentaLocal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class BuscarVentaLocalController {

    @FXML
    private Label alertLabel;

    @FXML
    private Button buscarButton;

    @FXML
    private Button closeButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private DatePicker datePicker2;

    @FXML
    void onActionDatePicker(ActionEvent event) {

    }

    @FXML
    void onClickBuscarButton(MouseEvent event) throws IOException {
        if (!(datePicker.getValue() == null)) {
            if (datePicker2.getValue() == null) {
                if (App.getTienda().searchVentasLocales(datePicker.getValue())){
                    App.getStageView().close();
                    App escena = new App();
                    escena.changeScene("ventasLocalesEncontradas-view.fxml");
                } else {
                    String contenido = "No existen ventas registradas en este día";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }
            } else {
                if (App.getTienda().searchVentasLocales(datePicker.getValue(), datePicker2.getValue())){
                    App.getStageView().close();
                    App escena = new App();
                    escena.changeScene("ventasLocalesEncontradas-view.fxml");
                } else {
                    String contenido = "No existen ventas registradas en estos días";
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(contenido);
                    alert.showAndWait();
                }
            }
        } else {
            String contenido = "Ingrese una fecha";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        }
    }

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void initialize() {
    }

}
