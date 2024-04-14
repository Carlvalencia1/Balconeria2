package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.TrabajosLocales;
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

public class VentasLocalesEncontradasController {


    @FXML
    private TableView<TrabajosLocales> ventasLocalesTable;

    @FXML
    private TableColumn<TrabajosLocales, Integer> colCantidad;

    @FXML
    private TableColumn<TrabajosLocales, String> colIdVenta;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<TrabajosLocales, String> colIDVendedor;

    @FXML
    private TableColumn<TrabajosLocales, Integer> colMonto;

    @FXML
    private TableColumn<TrabajosLocales, Integer> colDescuento;

    @FXML
    private TableColumn<TrabajosLocales, LocalDate> colFecha;

    @FXML
    void onMouseClickExitButton(MouseEvent event) throws IOException {
        App escena = new App();
        escena.changeScene("ventasLocales-view.fxml");
    }


    @FXML
    public void initialize() {
        colIdVenta.setCellValueFactory(new PropertyValueFactory<>("idVenta"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colDescuento.setCellValueFactory(new PropertyValueFactory<>("descuentoLocal"));
        colIDVendedor.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
        ObservableList<TrabajosLocales> ventas = FXCollections.observableArrayList(App.getTienda().getVLencontradas());
        ventasLocalesTable.setItems(ventas);
    }


}
