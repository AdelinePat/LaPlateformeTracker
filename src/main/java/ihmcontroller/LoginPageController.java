package ihmcontroller;

import utils.UserObject;
import exceptions.loginException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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
    public void onLoginButtonClicked(javafx.event.ActionEvent actionEvent) throws loginException, NoSuchAlgorithmException, InvalidKeySpecException, LoginException {
        UserObject user = new UserObject();
        user.setUserName(loginUserField.getText());
        user.setPassword((loginPassWordField.getText()));
        if (user.login()) {
            loginErrorLabel.setText("");
            sceneManager.switchToMainPage(user);

        } else {
            loginErrorLabel.setText("Username ou Password incorrect");
            throw new loginException("Erreur de connexion");
        }
    }

    @FXML
    public void onRegisterButtonClicked(javafx.event.ActionEvent actionEvent) {
        sceneManager.switchToRegisterPage();
    }

}
