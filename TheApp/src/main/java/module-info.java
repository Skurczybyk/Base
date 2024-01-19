module TheApp {
    exports com.Base.App;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    opens com.Base.App.Controllers to javafx.fxml;
}