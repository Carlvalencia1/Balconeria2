package com.alilopez.application;

import com.alilopez.application.models.Caja;
import com.alilopez.application.models.Login;
import com.alilopez.application.models.Tienda;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;


import java.io.IOException;

public class App extends javafx.application.Application {
    private static Stage stageView;
    private static Stage stageRoot;
    private static Tienda tienda = new Tienda();
    private static Login user = new Login();
    private static Caja caja = new Caja();
    @Override
    public void start(Stage stage) throws IOException {
        stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("NameApplication - Home");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stageRoot.getScene().setRoot(pane);
    }

    public static void newStage(String fxml, String title) {
        stageView = new Stage();
        Scene scene = null;
        try {
            scene = new Scene(loadFXML(fxml));
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stageView.setTitle(title);
            stageView.setScene(scene);
            stageView.centerOnScreen();
            stageView.initOwner(stageRoot);
            stageView.initModality(Modality.APPLICATION_MODAL);
            stageView.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stage getStageView(){
        return stageView;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        System.exit(1);
    }
    public static Tienda getTienda() {
        return tienda;
    }

    public static Login getUser() {
        return user;
    }

    public static Caja getCaja() {
        return caja;
    }
}