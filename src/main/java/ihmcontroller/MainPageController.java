package ihmcontroller;
import DAO.FilterStudentDAO;
import exceptions.FilterException;
import exceptions.StringInputException;
import javafx.scene.control.Label;
import searchfilter.*;
import utils.DataUtils;
import model.Student;
import model.User;
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

import javax.security.auth.login.LoginException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static DAO.StudentDAO.deleteStudent;
import static exceptions.ExceptionMessage.INVALID_INPUT;
import static searchfilter.FilterType.*;

public class MainPageController implements Initializable {
    private SceneManager sceneManager;
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
    private Student selectedStudent = null;

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private Label mainPageErrorLabel;

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
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, Integer> dataTableStudentID;

    @FXML
    private TableColumn<Student, String> dataTableStudentLastName;

    @FXML
    private TableColumn<Student, String> dataTableStudentFirstName;

    @FXML
    private TableColumn<Student, Integer> dataTableStudentAge;

    @FXML
    private TableColumn<Student, Double> dataTableStudentGrade;

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

        dataTableStudentID.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        dataTableStudentLastName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getLastname()));
        dataTableStudentFirstName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getFirstname()));
        dataTableStudentAge.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getAge()));
        dataTableStudentGrade.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getGrade()));
    }

    public void fillContent() {
//        NoFilter filter = new NoFilter();
        List<Student> studentList = FilterStudentDAO.getInitialStudentList();
        this.updateStudentList(studentList);
    }

    @FXML
    public void onLogoutButtonClicked(ActionEvent actionEvent) {
        sceneManager.switchToLoginPage();
    }

    @FXML
    public void onSearchLastNameButton(ActionEvent actionEvent) {
        this.resetErrorLabel();
        FilterCommand command = new FilterCommand();
        List<Student> studentList = null;

        try {
            if (!DataUtils.isInputEmpty(searchFilterNameField.getText())
                    && DataUtils.isNameValid(searchFilterNameField.getText())) {
                command.setSearchString(searchFilterNameField.getText());
                command.setType(LASTNAME);
                ISearchFilter filter = FilterFactory.createFilter(LASTNAME);
                studentList = filter
                        .getFilteredStudentList(command);
            } else if (DataUtils.isInputEmpty(searchFilterNameField.getText())) {
                ISearchFilter filter = FilterFactory.createFilter(NOFILTER);
                command.setType(NOFILTER);
                studentList = filter.getFilteredStudentList(command);
            } else {
                throw new StringInputException(INVALID_INPUT.getMessage());
            }
            command.setSearchString(searchFilterNameField.getText());
            this.updateStudentList(studentList);
        } catch (StringInputException | LoginException | FilterException e) {
            mainPageErrorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void onSearchFirstNameButton(ActionEvent actionEvent) {
        this.resetErrorLabel();
        FilterCommand command = new FilterCommand();
        List<Student> studentList = null;

        try {
            if (!DataUtils.isInputEmpty(searchFilterFirstNameField.getText())
                    && DataUtils.isNameValid(searchFilterFirstNameField.getText())) {
                command.setSearchString(searchFilterFirstNameField.getText());
                command.setType(FIRSTNAME);
                ISearchFilter filter = FilterFactory.createFilter(command.getType());
                studentList = filter
                        .getFilteredStudentList(command);
            } else if (DataUtils.isInputEmpty(searchFilterFirstNameField.getText())) {
                command.setType(NOFILTER);
                ISearchFilter filter = FilterFactory.createFilter(command.getType());
                studentList = filter.getFilteredStudentList(command);
            } else {
                throw new StringInputException(INVALID_INPUT.getMessage());
            }
            this.updateStudentList(studentList);
            this.resetErrorLabel();
        } catch (StringInputException | LoginException | FilterException e) {
            mainPageErrorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void onSearchGradeButton(ActionEvent actionEvent) {
        this.resetErrorLabel();
        FilterCommand command = new FilterCommand();

        try {
            command.setGradeValues(searchFilterMinGradeField.getText(),
                    searchFilterMaxGradeField.getText());
            command.setType(AVERAGE);
            ISearchFilter filter = FilterFactory.createFilter(command.getType());
            List<Student> studentList = filter
                    .getFilteredStudentList(command);
            this.updateStudentList(studentList);
        }  catch (StringInputException | FilterException e) {
            mainPageErrorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void onSearchAgeButton(ActionEvent actionEvent) {
        this.resetErrorLabel();
        FilterCommand command = new FilterCommand();

        try {
            command.setAgeValues(searchFilterMinAgeField.getText(),
                    searchFilterMaxAgeField.getText());
            command.setType(AGE);
            ISearchFilter filter = FilterFactory.createFilter(command.getType());
            List<Student> studentList = filter
                    .getFilteredStudentList(command);
            this.updateStudentList(studentList);
        } catch (StringInputException | FilterException e) {
            mainPageErrorLabel.setText(e.getMessage());
        }
    }


    private void updateStudentList(List<Student> studentList) {
        ObservableList<Student> studentData = FXCollections.observableArrayList();
        studentData.addAll(studentList);
        studentsTable.setItems(studentData);
    }

    @FXML
    public void onTableClicked(MouseEvent actionEvent) {
        if (studentsTable.getSelectionModel().getSelectedIndex() != -1) {
            selectedStudent = new Student(
                    studentsTable.getSelectionModel().getSelectedItem().getId(),
                    studentsTable.getSelectionModel().getSelectedItem().getLastname(),
                    studentsTable.getSelectionModel().getSelectedItem().getFirstname(),
                    studentsTable.getSelectionModel().getSelectedItem().getAge(),
                    studentsTable.getSelectionModel().getSelectedItem().getGrade()
            );
            enterStudentLastName.setText(selectedStudent.getLastname());
            enterStudentFirstName.setText(selectedStudent.getFirstname());
            enterStudentAge.setText(String.valueOf(selectedStudent.getAge()));
            enterStudentGrade.setText(String.valueOf(selectedStudent.getGrade()));
        }
    }

    @FXML
    public void clearStudentSelection(ActionEvent actionEvent) {
        selectedStudent = null;
        enterStudentLastName.setText("");
        enterStudentFirstName.setText("");
        enterStudentAge.setText("");
        enterStudentGrade.setText("");
    }

    @FXML void deleteStudentSelection(ActionEvent actionEvent) {
        if  (selectedStudent != null) {
            deleteStudent(selectedStudent);
        }
    }

    public void resetAgeFilterFields() {
        searchFilterMinAgeField.setText("");
        searchFilterMaxAgeField.setText("");
    }

    public void resetGradeFilterFields() {
        searchFilterMinGradeField.setText("");
        searchFilterMaxGradeField.setText("");
    }

    public void resetErrorLabel() {
        mainPageErrorLabel.setText("");
    }
}
