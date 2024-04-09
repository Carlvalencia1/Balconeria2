package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Caja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.time.LocalDate;

public class HistorialEncontradoController {

    @FXML
    private TableColumn<Caja, LocalDate> colFecha;

    @FXML
    private TableColumn<Caja, String> colIDVendedor;

    @FXML
    private TableColumn<Caja, Integer> colMonto;

    @FXML
    private Label monto;

    @FXML
    private Button exitButton;

    @FXML
    private TableView<Caja> historialTable;

    @FXML
    void onMouseClickExitButton(MouseEvent event) throws IOException {
        App escena = new App();
        escena.changeScene("historial-view.fxml");
    }

    @FXML
    public void initialize() {
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colIDVendedor.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        ObservableList<Caja> historial = FXCollections.observableArrayList(App.getTienda().getHistorialEncontrado());
        historialTable.setItems(historial);
        double total = 0;
        for (int i = 0; i < historial.size(); i++) {
            total += historial.get(i).getMonto();
        }
        monto.setText("" + total);
    }
}
