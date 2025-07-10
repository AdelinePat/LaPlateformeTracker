package ihmcontroller;

import javafx.scene.image.Image;
import utils.DatabaseConnection;
import model.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    Stage applicationStage;
    Stage graphStage = null;

    Scene mainPageScene;
    private final MainPageController mainPageController;
    Scene loginPageScene;
    Scene registerPageScene;
    Scene gradeGraphPageScene;
    private final GraphPageController gradeGraphController;

    public SceneManager(Stage applicationStage) throws IOException {
        this.applicationStage = applicationStage;
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource(DatabaseConnection.DASHBOARD_PATH));
        Parent mainPageParent = mainLoader.load();
        this.mainPageController = mainLoader.getController();
        mainPageController.setManager(this);
        mainPageScene = new Scene(mainPageParent, 800, 600);

        mainPageScene.getStylesheets().add(getClass().getResource("/style/general.css").toExternalForm());
        mainPageScene.getStylesheets().add(getClass().getResource("/style/mainPage.css").toExternalForm());

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource(DatabaseConnection.LOGIN_PATH));
        Parent loginPageParent = loginLoader.load();
        LoginPageController loginPageController = loginLoader.getController();
        loginPageController.setManager(this);
        loginPageScene = new Scene(loginPageParent, 580, 420);
//        URL cssUrl = getClass().getResource("/style/loginRegister.css");
//        if (cssUrl != null) {
        loginPageScene.getStylesheets().add(getClass().getResource("/style/general.css").toExternalForm());
            loginPageScene.getStylesheets().add(getClass().getResource("/style/loginRegister.css").toExternalForm());
//        } else {
//            System.err.println("⚠️ Could not load CSS: /style/loginRegister.css");
//        }
//        loginPageScene.getStylesheets().add(getClass().getResource("/style/loginRegister.css").toExternalForm());

        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource(DatabaseConnection.REGISTER_PATH));
        Parent registerPageParent = registerLoader.load();
        RegisterPageController registerPageController = registerLoader.getController();
        registerPageController.setManager(this);
        registerPageScene = new Scene(registerPageParent, 580, 420);

        FXMLLoader gradeGraphLoader = new FXMLLoader(getClass().getResource((DatabaseConnection.GRADEGRAPH_PATH)));
        Parent gradeGraphPageParent = gradeGraphLoader.load();
        this.gradeGraphController = gradeGraphLoader.getController();
        gradeGraphController.setManager(this);
        gradeGraphPageScene = new Scene(gradeGraphPageParent, 420, 420);
        gradeGraphPageScene.getStylesheets().add(getClass().getResource("/style/general.css").toExternalForm());
        gradeGraphPageScene.getStylesheets().add(getClass().getResource("/style/graphPage.css").toExternalForm());

    }

    public void switchToLoginPage() {
        applicationStage.setScene(loginPageScene);
        applicationStage.setTitle("Plateforme Tracker - Connexion");
    }

    public void switchToMainPage(User user) {
        applicationStage.setScene(mainPageScene);
        applicationStage.setTitle("Plateforme Tracker - Dashboard");
        this.mainPageController.fillContent();
        this.mainPageController.setUser(user);
//        this.mainPageController.titleUserName.setText(user.getUserName());
        this.mainPageController.setLabelUserName(user.getUserName().toUpperCase());
    }

    public void switchToRegisterPage() {
        applicationStage.setScene(registerPageScene);
        applicationStage.setTitle("Plateforme Tracker - Connexion");
    }

    public void initGraphPage() {
        if (graphStage != null) {
            graphStage.close();
        }
        this.graphStage = new Stage();
        graphStage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/app_icon.ico")));
        graphStage.setTitle("Plateforme Tracker - Graphiques");
        graphStage.setScene(gradeGraphPageScene);
        gradeGraphController.graphUpdate();
        graphStage.show();
    }

    public void switchToGradeGraphPage() {
        graphStage.setScene(gradeGraphPageScene);
        gradeGraphController.graphUpdate();
        graphStage.show();
    }

    public void switchToAgeGraphPage() {

    }
}
