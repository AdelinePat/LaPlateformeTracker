package IHMController;

import Utils.UserObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    Stage applicationStage;

    Scene mainPageScene;
    Scene loginPageScene;
    private final MainPageController mainPageController;

    public SceneManager(Stage applicationStage) throws IOException {
        this.applicationStage = applicationStage;

        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/Main_page.fxml"));
        Parent mainPageParent = mainLoader.load();
        this.mainPageController = mainLoader.getController();
        mainPageController.setManager(this);
        mainPageScene = new Scene(mainPageParent, 800, 520);

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
        Parent loginPageParent = loginLoader.load();
        LoginPageController loginPageController = loginLoader.getController();
        loginPageController.setManager(this);
        loginPageScene = new Scene(loginPageParent, 580, 420);
    }

    public void switchToLoginPage() {
        applicationStage.setScene(loginPageScene);
        applicationStage.setTitle("Plateforme Tracker - Connexion");
    }

    public void switchToMainPage(UserObject user) {
        applicationStage.setScene(mainPageScene);
        applicationStage.setTitle("Plateforme Tracker - Dashboard");
        this.mainPageController.fillContent();
        this.mainPageController.setUser(user);
    }
}
