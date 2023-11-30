module JFX {
    exports com.JFX;
    exports com.JFX.Controlls to javafx.fxml;
    requires javafx.base;
    requires javafx.media;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
}