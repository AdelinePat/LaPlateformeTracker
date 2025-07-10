package ihmcontroller;

import utils.DataUtils;
import model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.security.auth.login.LoginException;

import static exceptions.ExceptionMessage.INVALID_USERNAME;

public class LoginPageController {
    private SceneManager sceneManager;

    @FXML
    private TextField loginUserField;

    @FXML
    private PasswordField loginPassWordField;
    public Label loginErrorLabel;
    @FXML
    private Label titleOfPage;

    public void initialize() {
        System.out.println(titleOfPage.getStyleClass());
        System.out.println("Style classes on label: " + titleOfPage.getStyleClass());
    }

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    public void onLoginButtonClicked(javafx.event.ActionEvent actionEvent)  {
        User user = new User();
        try {
            if (!DataUtils.isNameValid(loginUserField.getText())
                    || DataUtils.isInputEmpty(loginUserField.getText())) {
                throw new LoginException(INVALID_USERNAME.getMessage());
            }
            user.setUserName(loginUserField.getText());
            user.setPassword((loginPassWordField.getText()));
            if (user.login()) {
                this.resetAllFields();
                System.out.println("Dans loginpagecontroller : " + user.getUserName());
                sceneManager.switchToMainPage(user);
            }
        } catch (LoginException e) {
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
