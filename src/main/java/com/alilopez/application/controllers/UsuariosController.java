package com.alilopez.application.controllers;

import com.alilopez.application.App;
import com.alilopez.application.models.Cliente;
import com.alilopez.application.models.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class UsuariosController {

    @FXML
    private TableView<Usuario> usuariosTable;

    @FXML
    private TableColumn<Usuario, String> colId;

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<Usuario, String> colApellido;

    @FXML
    private Button buscarButton;

    @FXML
    private TableColumn<Usuario, Integer> colEdad;

    @FXML
    private TableColumn<Usuario, String> colCorreo;

    @FXML
    private Button editarButton;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<Usuario, String> colCargo;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private Button removeButton;
    @FXML
    void onClickAddButton(MouseEvent event) {
        App.newStage("newUsuario-view", "App - New Usuario");
    }

    @FXML
    void onClickBuscarButton(MouseEvent event) {
        App.newStage("buscarUsuario-view", "App - Buscar Usuario");
    }

    @FXML
    void onClickEditarButton(MouseEvent event) {
        App.newStage("updateUsuario-view", "App - Actualizar Usuario");
    }

    @FXML
    void onClickRemoveButton(MouseEvent event) {
        App.newStage("removeUsuario-view", "App - Remove Usuario");
    }

    @FXML
    void onMouseClickExitButton(MouseEvent event) throws IOException {
        App escena = new App();
            escena.changeScene("homeAdmin-view.fxml");
    }

    @FXML
    public void initialize() {

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList(App.getTienda().getUsuarios());
        usuariosTable.setItems(usuarios);
    }

}
