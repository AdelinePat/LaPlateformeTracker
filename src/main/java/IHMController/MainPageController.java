package IHMController;

//import SearchFilter.FirstnameFilter;
import SearchFilter.NameFilter;
import SearchFilter.SearchFilter;
import SearchFilter.RangeFilter;
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
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    private SceneManager sceneManager;

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private TextField searchFilterNameField;

    @FXML
    private TextField searchFilterFirstNameField;

    @FXML
    private TextField searchFilterMinGradeField;

    @FXML
    private TextField searchFilterMaxGradeField;


    @FXML
    private TextField searchFilterMinAgeField;

    @FXML
    private TextField searchFilterMaxAgeField;

    @FXML
    private TableView<StudentObject> studentsTable;

    @FXML
    private TableColumn<StudentObject, Integer> dataTableStudentID;

    @FXML
    private TableColumn<StudentObject, String> dataTableStudentLastName;

    @FXML
    private TableColumn<StudentObject, String> dataTableStudentFirstName;

    @FXML
    private TableColumn<StudentObject, Integer> dataTableStudentAge;

    @FXML
    private TableColumn<StudentObject, Double> dataTableStudentGrade;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SearchFilter filter = new NameFilter();
        List<StudentObject> aList = filter.getInitialStudentList();

        ObservableList<StudentObject> studentData = FXCollections.observableArrayList();
        studentData.addAll(aList);

        studentsTable.setItems(studentData);

        dataTableStudentID.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        dataTableStudentLastName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getLastname()));
        dataTableStudentFirstName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getFirstname()));
        dataTableStudentAge.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getAge()));
        dataTableStudentGrade.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getGrade()));
    }

    @FXML
    public void onLogoutButtonClicked(javafx.event.ActionEvent actionEvent) {
        sceneManager.switchToLoginPage();
    }

    @FXML
    public void onSearchLastNameButton(javafx.event.ActionEvent actionEvent) {
        System.out.println("Bouton recherche par nom de famille cliqué");
        SearchFilter filter = new NameFilter();
        List<StudentObject> studentList = filter
                .getFilteredStudentList(
                        "lastname",
                        searchFilterNameField.getText());

        ObservableList<StudentObject> studentData = FXCollections.observableArrayList();
        studentData.addAll(studentList);

        studentsTable.setItems(studentData);
    }

    @FXML
    public void onSearchFirstNameButton(javafx.event.ActionEvent actionEvent) {
        System.out.println("Bouton recherche par prénom cliqué");
        SearchFilter filter = new NameFilter();
        List<StudentObject> studentList = filter
                .getFilteredStudentList(
                        "firstname",
                        searchFilterFirstNameField.getText());
        ObservableList<StudentObject> studentData = FXCollections.observableArrayList();
        studentData.addAll(studentList);
        studentsTable.setItems(studentData);
    }

    @FXML
    public void onSearchGradeButton(javafx.event.ActionEvent actionEvent) {
        System.out.println("Bouton recherche par notes cliqué");
        SearchFilter filter = new RangeFilter();
        String userInput = searchFilterMinGradeField.getText() + "-" + searchFilterMaxGradeField.getText();

        List<StudentObject> studentList = filter
                .getFilteredStudentList(
                        "average",
                        userInput
                        );

        ObservableList<StudentObject> studentData = FXCollections.observableArrayList();
        studentData.addAll(studentList);
        studentsTable.setItems(studentData);
    }

    @FXML
    public void onSearchAgeButton(javafx.event.ActionEvent actionEvent) {
        System.out.println("Bouton recherche par notes cliqué");
        SearchFilter filter = new RangeFilter();
        String userInput = searchFilterMinAgeField.getText() + "-" + searchFilterMaxAgeField.getText();

        List<StudentObject> studentList = filter
                .getFilteredStudentList(
                        "age",
                        userInput
                );

        ObservableList<StudentObject> studentData = FXCollections.observableArrayList();
        studentData.addAll(studentList);
        studentsTable.setItems(studentData);
    }
}
