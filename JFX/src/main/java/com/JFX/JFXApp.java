package com.JFX;

import javafx.application.Application;
import javafx.stage.Stage;

public class JFXApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StageManager stageManager = new StageManager(stage);
        stageManager.getMainStage().show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
