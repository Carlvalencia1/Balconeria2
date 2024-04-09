module com.alilopez.vererinaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.display;
    requires org.controlsfx.controls;


    opens com.alilopez.application to javafx.fxml;
    opens com.alilopez.application.models to javafx.base;
    exports com.alilopez.application;
    exports com.alilopez.application.controllers;
    opens com.alilopez.application.controllers to javafx.fxml;
}