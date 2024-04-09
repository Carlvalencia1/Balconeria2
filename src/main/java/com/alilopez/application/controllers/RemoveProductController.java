package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class RemoveProductController {

    @FXML
    private Label alertLabel;

    @FXML
    private Button closeButton;

    @FXML
    private TextField idTextfield;

    @FXML
    private Button removeButton;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.getStageView().close();
    }

    @FXML
    void onActionTipoComboBox(ActionEvent event) {}

    @FXML
    void onClickRemoveButton(MouseEvent event) {
        String id = tipoComboBox.getValue();
        if (!(tipoComboBox.getValue() == null)) {
            if (App.getTienda().deleteProducto(id)){
                String contenido = "Se eliminó exitosamente";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            } else {
                String contenido = "Producto Inexistente";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        } else {
            String contenido = "Seleccione un producto porfavor";
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
