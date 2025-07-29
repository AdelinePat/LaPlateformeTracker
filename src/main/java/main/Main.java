package main;

import ihmcontroller.SceneManager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage applicationStage) throws Exception {
        InputStream iconStream = getClass().getResourceAsStream("/icons/app_icon.ico");
//        Image icon = new Image(getClass().getResourceAsStream("/icons/app_icon.PNG");
        if (iconStream == null) {
            System.out.println("❌ Icon stream is null!");
        } else {
            System.out.println("✅ Icon stream loaded!");
            applicationStage.getIcons().add(new Image(iconStream));
        }
//        applicationStage.getIcons().add(new Image(getClass().getResourceAsStream("/home/adeline/Documents/Java_projects/LaPlateformeTracker/src/main/resources/icons/app_icon.PNG")));
        SceneManager sceneManager = new SceneManager(applicationStage);
        sceneManager.switchToLoginPage();
        applicationStage.show();

        applicationStage.show();
        applicationStage.getIcons().add(new Image(iconStream));
    }
}