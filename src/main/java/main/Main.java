package main;

import IHMController.MainPageController;
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
    public void start(Stage mainPage) throws Exception {
        Parent main_page = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Main_page.fxml")));
        mainPage.setTitle("Plateforme Monitors");
        mainPage.setScene(new Scene(main_page, 800, 640));

        MainPageController mainPageController = new MainPageController();
        mainPageController.setScene(mainPage.getScene());

        mainPage.show();
    }
}