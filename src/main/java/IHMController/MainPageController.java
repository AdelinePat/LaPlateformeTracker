package IHMController;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainPageController {
    private SceneManager sceneManager;

    public TextField searchFilterNameField;
    public TextField searchFilterFirstNameField;

    public TextField searchFilterMinAgeField;
    public TextField searchFilterMaxAgeField;

    public TextField searchFilterMinGradeField;
    public TextField searchFilterMaxGradeField;

    public TableColumn dataTableStudentID;
    public TableColumn dataTableStudentName;
    public TableColumn dataTableStudentFirstName;
    public TableColumn dataTableStudentAge;
    public TableColumn dataTableStudentGrade;

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


    public void onLogoutButtonClicked(javafx.event.ActionEvent actionEvent) {
        sceneManager.switchToLoginPage();
    }

    @FXML
    public void onNameFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void onFirstNameFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void onAgeFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void onGradeFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
    }
}
