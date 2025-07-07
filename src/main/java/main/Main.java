package main;

import IHMController.LoginPageController;
import IHMController.MainPageController;
import IHMController.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage applicationStage) throws Exception {
        SceneManager sceneManager = new SceneManager(applicationStage);
        sceneManager.switchToLoginPage();
        applicationStage.show();
    }
}