package main;

import ihmcontroller.SceneManager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage applicationStage) throws Exception {
        applicationStage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/app_icon.PNG")));
        SceneManager sceneManager = new SceneManager(applicationStage);
        sceneManager.switchToLoginPage();
        applicationStage.show();

        applicationStage.show();
    }
}