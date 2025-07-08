package IHMController;

import LoginModule.Register;
import Utils.UserObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class RegisterPageController {
    private SceneManager sceneManager;

    public TextField registerUserField;
    public PasswordField registerPassWordField;
    public Label registerErrorLabel;

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


    @FXML
    public void onRegisterButtonClicked(javafx.event.ActionEvent actionEvent) throws LoginException, NoSuchAlgorithmException, InvalidKeySpecException {
        Register register = new Register();
        UserObject user = new UserObject();
        user.setUserName(registerUserField.getText());
        user.setPassword(registerPassWordField.getText());
        register.register(user);
    }

    @FXML
    public void onReturnButtonClicked(javafx.event.ActionEvent actionEvent) {
        sceneManager.switchToLoginPage();
    }
}
