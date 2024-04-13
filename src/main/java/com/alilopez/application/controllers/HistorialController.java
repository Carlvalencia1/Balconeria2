package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Caja;
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

public class HistorialController {

    @FXML
    private TableColumn<Caja, LocalDate> colFecha;

    @FXML
    private TableColumn<Caja, LocalDate> colSalida;

    @FXML
    private TableColumn<Caja, LocalDate> colEntrada;

    @FXML
    private TableColumn<Caja, String> colIDVendedor;

    @FXML
    private TableColumn<Caja, Integer> colMonto;

    @FXML
    private Button exitButton;

    @FXML
    private TableView<Caja> historialTable;

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
    void onClickBuscarButton(MouseEvent event) {
        App.newStage("buscarHistorial-view", "App - Buscar Reportes");
    }

    @FXML
    public void initialize() {
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        colSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        colIDVendedor.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        ObservableList<Caja> historial = FXCollections.observableArrayList(App.getTienda().getHistorial());
        historialTable.setItems(historial);
    }
}
