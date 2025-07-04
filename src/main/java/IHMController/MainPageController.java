package IHMController;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainPageController {

    @FXML
    private Scene mainPage;

    public void setScene(Scene mainPage) {
        this.mainPage = mainPage;
    }

//    @FXML
//    private Button logoutbutton;
//
//    private Button namefilterbutton;
//    private Button firstnamefilterbutton;
//    private Button agefilterbutton;
//    private Button gradefilterbutton;
//
//    public void initialize(Scene main_page){
//        logoutbutton = (Button) main_page.lookup("#logOutButton");
//
//        namefilterbutton = (Button) main_page.lookup("#nameFilterButton");
//        firstnamefilterbutton = (Button) main_page.lookup("#firstNameFilterButton");
//        agefilterbutton = (Button) main_page.lookup("#ageFilterButton");
//        gradefilterbutton = (Button) main_page.lookup("#gradeFilterButton");
//    }

//    public MainPageController(Scene mainPage) {
//        this.mainPage = mainPage;
//    }

    @FXML
    public void onLogoutButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void onNameFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
        TextField filterTextField = (TextField) mainPage.lookup("#searchFilterNameField");
    }

    @FXML
    public void onFirstNameFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
        TextField filterTextField = (TextField) mainPage.lookup("#searchFilterFirstNameField");
    }

    @FXML
    public void onAgeFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
        TextField filterTextField = (TextField) mainPage.lookup("#searchFilterAgeField");
    }

    @FXML
    public void onGradeFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
        TextField filterTextField = (TextField) mainPage.lookup("#searchFilterGradeField");
    }
}
