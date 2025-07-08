package ihmcontroller;

import loginmodule.Register;
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
        Register register = new Register();
        UserObject user = new UserObject();
        try {
            if (DataUtils.isNameNotValid(registerUserField.getText())) {
                throw new LoginException("Le nom d'utilisateur est invalide");
            }
            user.setUserName(registerUserField.getText());
            user.setPassword(registerPassWordField.getText());
            register.register(user);
            registerErrorLabel.setText("Création du compte réussie");
            this.resetAllFields();
            sceneManager.switchToLoginPage();
        } catch (LoginException | SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
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
