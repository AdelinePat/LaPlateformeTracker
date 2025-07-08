package IHMController;

import Utils.DatabaseConnection;
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
    Scene registerPageScene;

    public SceneManager(Stage applicationStage) throws IOException {
        this.applicationStage = applicationStage;

        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource(DatabaseConnection.DASHBOARD_PATH));
        Parent mainPageParent = mainLoader.load();
        this.mainPageController = mainLoader.getController();
        mainPageController.setManager(this);
        mainPageScene = new Scene(mainPageParent, 800, 600);

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource(DatabaseConnection.LOGIN_PATH));
        Parent loginPageParent = loginLoader.load();
        LoginPageController loginPageController = loginLoader.getController();
        loginPageController.setManager(this);
        loginPageScene = new Scene(loginPageParent, 580, 420);

        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource(DatabaseConnection.REGISTER_PATH));
        Parent registerPageParent = registerLoader.load();
        RegisterPageController registerPageController = registerLoader.getController();
        registerPageController.setManager(this);
        registerPageScene = new Scene(registerPageParent, 580, 420);
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

    public void switchToRegisterPage() {
        applicationStage.setScene(registerPageScene);
        applicationStage.setTitle("Plateforme Tracker - Connexion");
    }
}
