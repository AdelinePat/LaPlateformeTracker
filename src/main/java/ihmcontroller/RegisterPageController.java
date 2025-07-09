package ihmcontroller;

import utils.DataUtils;
import model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import static exceptions.ExceptionMessage.INVALID_USERNAME;

public class RegisterPageController {
    private SceneManager sceneManager;

    public TextField registerUserField;
    public PasswordField registerPassWordField;
    public Label registerErrorLabel;

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


    @FXML
    public void onRegisterButtonClicked(javafx.event.ActionEvent actionEvent)  {
        User user = new User();
        try {
            if (!DataUtils.isNameValid(registerUserField.getText())
                    || DataUtils.isInputEmpty(registerUserField.getText())) {
                throw new LoginException(INVALID_USERNAME.getMessage());
            }
            user.setUserName(registerUserField.getText());
            user.setPassword(registerPassWordField.getText());
            user.register();
            registerErrorLabel.setText("Création du compte réussie");
            this.resetAllFields();
            sceneManager.switchToLoginPage();
        } catch (LoginException e) {
            registerErrorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void onReturnButtonClicked(javafx.event.ActionEvent actionEvent) {
        sceneManager.switchToLoginPage();
    }

    private void resetAllFields() {
        registerErrorLabel.setText("");
        registerUserField.setText("");
        registerPassWordField.setText("");
    }
}
