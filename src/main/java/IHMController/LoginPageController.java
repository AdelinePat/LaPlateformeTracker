package IHMController;

import LoginModule.Login;
import Utils.UserObject;
import customExceptions.loginException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginPageController {
    private SceneManager sceneManager;

    @FXML
    private TextField loginUserField;
    @FXML
    private PasswordField loginPassWordField;
    public Label loginErrorLabel;




    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    public void onLoginButtonClicked(javafx.event.ActionEvent actionEvent) throws loginException {
        UserObject user = new UserObject();
        user.setUserName(loginUserField.getText());
        user.setHashPassword((loginPassWordField.getText()));
        if (user.login()) {
            sceneManager.switchToMainPage();
        } else {
            throw new loginException("Erreur de connexion");
        }
    }

    @FXML
    public void onRegisterButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

}
