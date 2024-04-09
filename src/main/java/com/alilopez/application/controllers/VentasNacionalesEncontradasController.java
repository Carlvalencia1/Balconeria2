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

public class VentasNacionalesEncontradasController {


    @FXML
    private TableView<VentaNacional> ventasTable;

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
    private TableColumn<VentaNacional, LocalDate> colFecha;

    @FXML
    void onMouseClickExitButton(MouseEvent event) throws IOException {
        App escena = new App();
        escena.changeScene("ventasNacionales-view.fxml");
    }


    @FXML
    public void initialize() {
        colIdVenta.setCellValueFactory(new PropertyValueFactory<>("idVenta"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colCostoEnvio.setCellValueFactory(new PropertyValueFactory<>("costoEnvio"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        ObservableList<VentaNacional> ventas = FXCollections.observableArrayList(App.getTienda().getVNencontradas());
        ventasTable.setItems(ventas);

    }


}
