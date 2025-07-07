package IHMController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterPageController {
    private SceneManager sceneManager;

    public TextField registerUserField;
    public PasswordField registerPassWordField;
    public Label registerErrorLabel;

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


    @FXML
    public void onRegisterButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void onReturnButtonClicked(javafx.event.ActionEvent actionEvent) {
        sceneManager.switchToLoginPage();
    }
}
