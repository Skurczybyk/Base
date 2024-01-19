package com.Base.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JFXStarter extends Application {
    Stage mainStage;
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/MainScene.fxml"));
        mainStage.setScene(new Scene(root));
        mainStage.show();
    }
}
