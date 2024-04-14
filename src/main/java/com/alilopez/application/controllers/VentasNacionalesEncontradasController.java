package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.TrabajosNaciones;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.time.LocalDate;

public class VentasNacionalesEncontradasController {


    @FXML
    private TableView<TrabajosNaciones> ventasTable;

    @FXML
    private TableColumn<TrabajosNaciones, Integer> colCantidad;

    @FXML
    private TableColumn<TrabajosNaciones, String> colIdVenta;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<TrabajosNaciones, String> colDireccion;

    @FXML
    private TableColumn<TrabajosNaciones, Integer> colMonto;

    @FXML
    private TableColumn<TrabajosNaciones, Integer> colCostoEnvio;


    @FXML
    private TableColumn<TrabajosNaciones, LocalDate> colFecha;

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
        ObservableList<TrabajosNaciones> ventas = FXCollections.observableArrayList(App.getTienda().getVNencontradas());
        ventasTable.setItems(ventas);

    }


}
