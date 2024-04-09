package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class ClientesController {

    @FXML
    private TableView<Cliente> clienteTable;

    @FXML
    private TableColumn<Cliente, String> colId;

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<Cliente, String> colApellido;

    @FXML
    private Button buscarButton;

    @FXML
    private TableColumn<Cliente, Integer> colComprado;

    @FXML
    private TableColumn<Cliente, String> colCorreo;

    @FXML
    private Button editarButton;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<Cliente, Integer> colTelefono;

    @FXML
    private TableColumn<Cliente, Integer> colGastado;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private Button removeButton;
    @FXML
    void onClickAddButton(MouseEvent event) {
        App.newStage("newCliente-view", "App - New Cliente");
    }

    @FXML
    void onClickBuscarButton(MouseEvent event) {
        App.newStage("buscarCliente-view", "App - Buscar Cliente");
    }

    @FXML
    void onClickEditarButton(MouseEvent event) {
        App.newStage("updateCliente-view", "App - Actualizar Cliente");
    }

    @FXML
    void onClickRemoveButton(MouseEvent event) {
        App.newStage("removeCliente-view", "App - Remove Cliente");
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
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colGastado.setCellValueFactory(new PropertyValueFactory<>("gastado"));
        colComprado.setCellValueFactory(new PropertyValueFactory<>("comprado"));

        ObservableList<Cliente> clientes = FXCollections.observableArrayList(App.getTienda().getClientes());
        clienteTable.setItems(clientes);
//        exitButton.setStyle("-fx-font-size: 16px; -fx-font-weight: 900; -fx-alignment: center; -fx-background-color:  #cd812b;");

    }

}
