package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RemoveVentaLocalController {

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
        if (!idTextfield.getText().isEmpty() && idTextfield.getText().length() == 3) {
            boolean status = false;
            int index = 0;
            while (!status && index < App.getTienda().getVentasLocales().size()) {
                if (App.getTienda().getVentasLocales().get(index).getIdVenta().indexOf(idTextfield.getText()) >= 0 ) {
                    status = true;
                    if (App.getTienda().deleteVentaLocal(App.getTienda().getVentasLocales().get(index).getIdVenta())){
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
                index++;
            }
            if (!status) {
                String contenido = "ID inexistente";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        } else {
            String contenido = "Ingrese los 3 dígitos";
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
