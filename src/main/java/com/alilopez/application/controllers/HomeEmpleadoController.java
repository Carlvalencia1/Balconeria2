package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Caja;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class HomeEmpleadoController {

    private static LocalDateTime entrada;
    private static LocalDateTime salida;

    @FXML
    private Button openCajaButton;

    @FXML
    private Button closeCajaButton;

    @FXML
    private Button exitButton;



    @FXML
    private Button clienteButton;


    @FXML
    private Button ventaLocalButton;

    @FXML
    private Button ventaNacionalButton;

    @FXML
    void onClickOpenCajaButton(MouseEvent event) {
        if (App.getCaja().isStatus() == false) {
            entrada = LocalDateTime.now();
            openCajaButton.setVisible(false);
            closeCajaButton.setVisible(true);
            App.getCaja().setStatus(true);
            String contenido = "Caja abierta por " + App.getUser().getId();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        } else {
            String contenido = "No se pudo realizar la acción";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        }
    }

    @FXML
    void onClickCloseCajaButton(MouseEvent event) {
        if (App.getCaja().isStatus() == true){
            salida = LocalDateTime.now();
            if (App.getTienda().closeCaja(entrada, salida)) {
                App.getCaja().setStatus(false);
                closeCajaButton.setVisible(false);
                openCajaButton.setVisible(true);
                String contenido = "Caja Cerrada por: " + App.getUser().getId();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            } else {
                String contenido = "No se pudo realizar la acción";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(contenido);
                alert.showAndWait();
            }
        } else {
            String contenido = "Ya has abierto caja";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        }

    }

    @FXML
    void onClickClienteButton(MouseEvent event) throws IOException {
        App escena = new App();
        escena.changeScene("clientes-view.fxml");
    }

    @FXML
    void onClickVentaLocalButton(MouseEvent event) throws IOException {
        App escena = new App();
        escena.changeScene("ventasLocales-view.fxml");
    }

    @FXML
    void onClickVentaNacionalButton(MouseEvent event) throws IOException {
        App escena = new App();
        escena.changeScene("ventasNacionales-view.fxml");
    }

    @FXML
    void onMouseClickExitButton(MouseEvent event) throws IOException, IOException {
        if (App.getCaja().isStatus() == false) {
            App escena = new App();
            escena.changeScene("login-view.fxml");
        } else {
            String contenido = "Cierre la caja antes de irse";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        if (App.getCaja().isStatus() == false) {
            closeCajaButton.setVisible(false);
            openCajaButton.setVisible(true);
        } else {
            closeCajaButton.setVisible(true);
            openCajaButton.setVisible(false);
        }
    }
}
