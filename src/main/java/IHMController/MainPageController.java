package IHMController;

//import SearchFilter.FirstnameFilter;
import SearchFilter.NameFilter;
import SearchFilter.SearchFilter;
import SearchFilter.RangeFilter;
import Utils.StudentObject;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    private SceneManager sceneManager;
    private StudentObject selectedStudent = null;

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

    @FXML
    private TextField enterStudentLastName;

    @FXML
    private TextField enterStudentFirstName;

    @FXML
    private TextField enterStudentAge;

    @FXML
    private TextField enterStudentGrade;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SearchFilter filter = new NameFilter();
        List<StudentObject> studentList = filter.getInitialStudentList();
        this.updateStudentList(studentList);

        dataTableStudentID.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        dataTableStudentLastName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getLastname()));
        dataTableStudentFirstName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getFirstname()));
        dataTableStudentAge.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getAge()));
        dataTableStudentGrade.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getGrade()));
    }

    @FXML
    public void onLogoutButtonClicked(ActionEvent actionEvent) {
        sceneManager.switchToLoginPage();
    }

    @FXML
    public void onSearchLastNameButton(ActionEvent actionEvent) {
        System.out.println("Bouton recherche par nom de famille cliqué");
        SearchFilter filter = new NameFilter();
        List<StudentObject> studentList = filter
                .getFilteredStudentList(
                        "lastname",
                        searchFilterNameField.getText());

        this.updateStudentList(studentList);
    }

    @FXML
    public void onSearchFirstNameButton(ActionEvent actionEvent) {
        System.out.println("Bouton recherche par prénom cliqué");
        SearchFilter filter = new NameFilter();
        List<StudentObject> studentList = filter
                .getFilteredStudentList(
                        "firstname",
                        searchFilterFirstNameField.getText());

        this.updateStudentList(studentList);
    }

    @FXML
    public void onSearchGradeButton(ActionEvent actionEvent) {
        System.out.println("Bouton recherche par notes cliqué");
        SearchFilter filter = new RangeFilter();
        String userInput = searchFilterMinGradeField.getText() + "-" + searchFilterMaxGradeField.getText();

        List<StudentObject> studentList = filter
                .getFilteredStudentList(
                        "average",
                        userInput
                        );

        this.updateStudentList(studentList);
    }

    @FXML
    public void onSearchAgeButton(ActionEvent actionEvent) {
        System.out.println("Bouton recherche par notes cliqué");
        SearchFilter filter = new RangeFilter();
        String userInput = searchFilterMinAgeField.getText() + "-" + searchFilterMaxAgeField.getText();

        List<StudentObject> studentList = filter
                .getFilteredStudentList(
                        "age",
                        userInput
                );
        this.updateStudentList(studentList);
    }


    private void updateStudentList(List<StudentObject> studentList) {
        ObservableList<StudentObject> studentData = FXCollections.observableArrayList();
        studentData.addAll(studentList);
        studentsTable.setItems(studentData);
    }

    @FXML
    public void onTableClicked(MouseEvent actionEvent) {
        if (studentsTable.getSelectionModel().getSelectedIndex() != -1) {
            selectedStudent = new StudentObject(
                    studentsTable.getSelectionModel().getSelectedItem().getId(),
                    studentsTable.getSelectionModel().getSelectedItem().getLastname(),
                    studentsTable.getSelectionModel().getSelectedItem().getFirstname(),
                    studentsTable.getSelectionModel().getSelectedItem().getAge(),
                    studentsTable.getSelectionModel().getSelectedItem().getGrade()
            );
        }
        enterStudentLastName.setText(selectedStudent.getLastname());
        enterStudentFirstName.setText(selectedStudent.getFirstname());
        enterStudentAge.setText(String.valueOf(selectedStudent.getAge()));
        enterStudentGrade.setText(String.valueOf(selectedStudent.getGrade()));
    }

    @FXML
    public void clearStudentSelection(ActionEvent actionEvent) {
        selectedStudent = null;
        enterStudentLastName.setText("");
        enterStudentFirstName.setText("");
        enterStudentAge.setText("");
        enterStudentGrade.setText("");
    }
}
