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
        user.setUserName(loginUserField.getText());
        user.setPassword((loginPassWordField.getText()));
        try {
            if (user.login()) {
                this.resetAllFields();
                sceneManager.switchToMainPage(user);
            }
        } catch (LoginException e) {
            loginErrorLabel.setText("Erreur utilisateur : " + e.getMessage());
        } catch (SQLException e) {
            loginErrorLabel.setText("Erreur de requête : " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            loginErrorLabel.setText("Erreur d'algorithme de chiffrement : " + e.getMessage());
        } catch (InvalidKeySpecException e) {
            loginErrorLabel.setText("Erreur de clé invalide : " + e.getMessage());
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
