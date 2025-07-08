package main;

import ihmcontroller.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage applicationStage) throws Exception {
        SceneManager sceneManager = new SceneManager(applicationStage);
        sceneManager.switchToLoginPage();
        applicationStage.show();

        applicationStage.show();
    }
}