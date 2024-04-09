package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Cafe;
import com.alilopez.application.models.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class InventarioController {

    @FXML
    private TableView<Cafe> productosTable;

    @FXML
    private Button addButton;

    @FXML
    private Button buscarButton;

    @FXML
    private TableColumn<Cafe, Integer> colCantidad;

    @FXML
    private TableColumn<Cafe, Integer> colCosto;

    @FXML
    private Button editarButton;

    @FXML
    private Button exitButton;


    @FXML
    private TableColumn<Cafe, String> colNombre;

    @FXML
    private TableColumn<Cafe, Integer> colPeso;

    @FXML
    private TableColumn<Cafe, Integer> colPrecio;

    @FXML
    private Button removeButton;

    @FXML
    private TableColumn<Cafe, String> colTipo;

    @FXML
    void onClickAddButton(MouseEvent event) {
        App.newStage("newProduct-view", "App - Producto Nuevo");
    }

    @FXML
    void onClickBuscarButton(MouseEvent event) {
        App.newStage("buscarProduct-view", "App - Buscar Producto");
    }

    @FXML
    void onClickEditarButton(MouseEvent event) {
        App.newStage("updateProduct-view", "App - Actualizar Producto");
    }

    @FXML
    void onClickRemoveButton(MouseEvent event) {
        App.newStage("removeProduct-view", "App - Eliminar Producto");
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
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));
        ObservableList<Cafe> productos = FXCollections.observableArrayList(App.getTienda().getProductos());
        productosTable.setItems(productos);
    }

}
