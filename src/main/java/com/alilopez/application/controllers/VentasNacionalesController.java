package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VentasNacionalesController {


    @FXML
    private TableView<VentaNacional> ventasTable;

    @FXML
    private Button addButton;

    @FXML
    private Button buscarButton;

    @FXML
    private TableColumn<VentaNacional, Integer> colCantidad;

    @FXML
    private TableColumn<VentaNacional, String> colIdVenta;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<VentaNacional, String> colDireccion;

    @FXML
    private TableColumn<VentaNacional, Integer> colMonto;

    @FXML
    private TableColumn<VentaNacional, Integer> colCostoEnvio;

    @FXML
    private Button removeButton;

    @FXML
    private TableColumn<VentaNacional, LocalDate> colFecha;

    @FXML
    void onClickAddButton(MouseEvent event) {
        if (App.getCaja().isStatus() == true) {
            App.newStage("newVentaNacional-view", "App - Venta Nacional");
        } else {
            String contenido = "Abra Caja para Realizar una Venta";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        }
    }

    @FXML
    void onClickBuscarButton(MouseEvent event) {
        App.newStage("buscarVentaNacional-view", "App - Buscar Venta Nacional");
    }


    @FXML
    void onClickRemoveButton(MouseEvent event) {
        App.newStage("removeVentaNacional-view", "App - Eliminar Venta Nacional");
    }

    @FXML
    void onMouseClickExitButton(MouseEvent event) throws IOException {
        App escena = new App();
        short permisos = App.getUser().getAcess();
        if (permisos == 1) {
            escena.changeScene("homeAdmin-view.fxml");
        } else if (permisos == 2) {
            escena.changeScene("homeCapturista-view.fxml");
        } else if (permisos == 3) {
            escena.changeScene("homeEmpleado-view.fxml");
        }
    }


    @FXML
    public void initialize() {
        colIdVenta.setCellValueFactory(new PropertyValueFactory<>("idVenta"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colCostoEnvio.setCellValueFactory(new PropertyValueFactory<>("costoEnvio"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        ObservableList<VentaNacional> ventas = FXCollections.observableArrayList(App.getTienda().getVentaNacionales());
        ventasTable.setItems(ventas);

    }


}
