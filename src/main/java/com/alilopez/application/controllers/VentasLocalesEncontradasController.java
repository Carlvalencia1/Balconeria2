package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Cafe;
import com.alilopez.application.models.Cliente;
import com.alilopez.application.models.Venta;
import com.alilopez.application.models.VentaLocal;
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

public class VentasLocalesEncontradasController {


    @FXML
    private TableView<VentaLocal> ventasLocalesTable;

    @FXML
    private TableColumn<VentaLocal, Integer> colCantidad;

    @FXML
    private TableColumn<VentaLocal, String> colIdVenta;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<VentaLocal, String> colIDVendedor;

    @FXML
    private TableColumn<VentaLocal, Integer> colMonto;

    @FXML
    private TableColumn<VentaLocal, Integer> colDescuento;

    @FXML
    private TableColumn<VentaLocal, LocalDate> colFecha;

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
        ObservableList<VentaLocal> ventas = FXCollections.observableArrayList(App.getTienda().getVLencontradas());
        ventasLocalesTable.setItems(ventas);
    }


}
