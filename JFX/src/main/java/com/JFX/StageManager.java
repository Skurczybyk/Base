package com.JFX;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageManager {
    Stage mainStage;
    public StageManager(Stage mainStage)
    {
        setMainStage(mainStage);
        setScene(getMainScene());

    }
    public StageManager(Stage mainStage, String sceneFxmlName)
    {
        setMainStage(mainStage);
        setScene(createScene(sceneFxmlName));
    }
    public void setMainStage(Stage stage)
    {
        mainStage = stage;
    }
    public Stage getMainStage()
    {
        return mainStage;
    }
    public void setScene(Scene scene)
    {
        mainStage.setScene(scene);
    }
    public void setScene(String fxmlName)
    {
        mainStage.setScene(createScene(fxmlName));
    }
    public Scene getScene()
    {
        Scene scene = mainStage.getScene();
        return scene;
    }
    private Scene createScene(String fxmlName)
    {
        try {
            Parent root = loadFXMLLoader(fxmlName);
            return new Scene(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Scene getMainScene()
    {
        try {
            Parent root = loadFXMLLoader("Main");
            return new Scene(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private <T> T loadFXMLLoader(String fxmlName) throws IOException {
     return FXMLLoader.load(getClass().getResource(pathToFXML(fxmlName)));
    }
    private String pathToFXML(String name)
    {
        return "/FXML/" + name + ".fxml";
    }


}
