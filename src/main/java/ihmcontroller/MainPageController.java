package ihmcontroller;
import DAO.FilterStudentDAO;
import exceptions.DataException;
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

import static DAO.StudentDAO.*;
import static exceptions.ExceptionMessage.*;
import static searchfilter.FilterType.*;
import static utils.DataUtils.*;

public class MainPageController implements Initializable {
    private SceneManager sceneManager;
    private User user;

    @FXML
    private Label titleOfPage;

    @FXML
    public Label titleUserName;

    public void initialize() {
        System.out.println(titleUserName.getStyleClass());
        titleUserName.setText(user.getUserName());
    }

    public void setUser(User user) {
        this.user = user;
    }
    private Student selectedStudent = null;

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void setLabelUserName(String username) {
        titleUserName.setText(username);
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
                    && isNameValid(searchFilterNameField.getText())) {
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
        } catch (StringInputException | FilterException e) {
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
                    && isNameValid(searchFilterFirstNameField.getText())) {
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
        } catch (StringInputException | FilterException e) {
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
        clearStudentEntries();
    }

    private void clearStudentEntries() {
        selectedStudent = null;
        enterStudentLastName.setText("");
        enterStudentFirstName.setText("");
        enterStudentAge.setText("");
        enterStudentGrade.setText("");
    }

    @FXML
    public void addStudentSelection(ActionEvent actionEvent) {
        Student newStudent = new Student();
        try {
            if (isNameValid(enterStudentLastName.getText()) &&
                    isNameValid(enterStudentFirstName.getText()) &&
                    isInputIntegerValid(enterStudentAge.getText()) &&
                    isInputFloatValid(enterStudentGrade.getText())
            ) {
                newStudent.setLastname(enterStudentLastName.getText());
                newStudent.setFirstname(enterStudentFirstName.getText());
                newStudent.setAge(Integer.parseInt(enterStudentAge.getText()));
                newStudent.setGrade(Double.parseDouble(enterStudentGrade.getText()));
            } else {
                throw new DataException(INVALID_INPUTS.getMessage());
            }
            addStudent(newStudent);
            fillContent();
        } catch (DataException e) {
            mainPageErrorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void deleteStudentSelection(ActionEvent actionEvent) {
        try {
            if (selectedStudent != null) {
                deleteStudent(selectedStudent);
                fillContent();
            } else {
                throw new DataException(STUDENT_NOT_SELECTED.getMessage());
            }
        } catch (DataException e) {
            mainPageErrorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void updateStudentSelection(ActionEvent actionEvent) {
        try {
            if (selectedStudent != null) {
                Student modifiedStudent = new Student();
                modifiedStudent.setId(selectedStudent.getId());
                modifiedStudent.setLastname(enterStudentLastName.getText());
                modifiedStudent.setFirstname(enterStudentFirstName.getText());
                modifiedStudent.setAge(Integer.parseInt(enterStudentAge.getText()));
                modifiedStudent.setGrade(Double.parseDouble(enterStudentGrade.getText()));

                updateStudent(modifiedStudent);
                fillContent();
                clearStudentEntries();
            } else {
                throw new DataException(STUDENT_NOT_SELECTED.getMessage());
            }
        } catch (DataException e) {
            mainPageErrorLabel.setText(e.getMessage());
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