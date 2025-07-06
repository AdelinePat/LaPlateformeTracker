package IHMController;

import SearchFilter.FirstnameFilter;
import SearchFilter.ISearchFilter;
import Utils.DatabaseConnection;
import Utils.StudentObject;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private TableView<StudentObject> studentsTable;

    @FXML
    private TableColumn<StudentObject, Integer> dataTableStudentID;

    @FXML
    private TableColumn<StudentObject, String> dataTableStudentName;

    @FXML
    private TableColumn<StudentObject, String> dataTableStudentFirstName;

    @FXML
    private TableColumn<StudentObject, Integer> dataTableStudentAge;

    @FXML
    private TableColumn<StudentObject, Double> dataTableStudentGrade;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataTableStudentID.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        dataTableStudentName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getLastname()));
        dataTableStudentFirstName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getFirstname()));
        dataTableStudentAge.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getAge()));
        dataTableStudentGrade.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getGrade()));
    }

//    @FXML
//    private Scene mainPage;
//
//    public void setScene(Scene mainPage) {
//        this.mainPage = mainPage;
//    }

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
        System.out.println("Bouton déconnexion cliqué");
        ISearchFilter filter = new FirstnameFilter();
        List< StudentObject> aList = filter.filterRequest();

        ObservableList<StudentObject> studentData = FXCollections.observableArrayList();
        studentData.addAll(aList);

        studentsTable.setItems(studentData);

//        TableColumn<StudentObject, String> column = new TableColumn<>("Student string");
    }



//    @FXML
//    public void onNameFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
//        TextField filterTextField = (TextField) mainPage.lookup("#searchFilterNameField");
//    }
//
//    @FXML
//    public void onFirstNameFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
//        TextField filterTextField = (TextField) mainPage.lookup("#searchFilterFirstNameField");
//    }
//
//    @FXML
//    public void onAgeFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
//        TextField filterTextField = (TextField) mainPage.lookup("#searchFilterAgeField");
//    }
//
//    @FXML
//    public void onGradeFilterSearchButtonClicked(javafx.event.ActionEvent actionEvent) {
//        TextField filterTextField = (TextField) mainPage.lookup("#searchFilterGradeField");
//    }
}
