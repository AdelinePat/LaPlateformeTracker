package ihmcontroller;

import utils.DataUtils;
import utils.UserObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

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
    public void onLoginButtonClicked(javafx.event.ActionEvent actionEvent)  {
        UserObject user = new UserObject();
        try {
            if (DataUtils.isNameNotValid(loginUserField.getText())) {
                throw new LoginException("Le nom d'utilisateur est invalide");
            }
            user.setUserName(loginUserField.getText());
            user.setPassword((loginPassWordField.getText()));
            if (user.login()) {
                this.resetAllFields();
                sceneManager.switchToMainPage(user);
            }
        } catch (LoginException | SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            loginErrorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void onRegisterButtonClicked(javafx.event.ActionEvent actionEvent) {
        sceneManager.switchToRegisterPage();
    }

    private void resetAllFields() {
        loginErrorLabel.setText("");
        loginUserField.setText("");
        loginPassWordField.setText("");
    }

}
