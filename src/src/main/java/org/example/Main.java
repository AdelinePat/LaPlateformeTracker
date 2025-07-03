package org.example;

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
    public void start(Stage stage) throws Exception {
        Parent main_page = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/Main_page.fxml")));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(main_page, 800, 640));
        stage.show();
    }
}