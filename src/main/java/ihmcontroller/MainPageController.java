package ihmcontroller;

//import SearchFilter.FirstnameFilter;
import exceptions.FilterException;
import exceptions.StringInputException;
import javafx.scene.control.Label;
import searchfilter.NameFilter;
import searchfilter.SearchFilter;
import searchfilter.RangeFilter;
import utils.DataUtils;
import utils.StudentObject;
import utils.UserObject;
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
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import searchfilter.FilterCommand;

import static DAO.StudentDAO.*;
import static searchfilter.FilterType.*;

public class MainPageController implements Initializable {
    private SceneManager sceneManager;
    private UserObject user;

    public void setUser(UserObject user) {
        this.user = user;
    }
    private StudentObject selectedStudent = null;

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

        dataTableStudentID.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        dataTableStudentLastName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getLastname()));
        dataTableStudentFirstName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getFirstname()));
        dataTableStudentAge.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getAge()));
        dataTableStudentGrade.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getGrade()));
    }

    public void fillContent() {
        SearchFilter filter = new NameFilter();
        List<StudentObject> studentList = filter.getInitialStudentList();
        this.updateStudentList(studentList);
    }

    @FXML
    public void onLogoutButtonClicked(ActionEvent actionEvent) {
        sceneManager.switchToLoginPage();
    }

    @FXML
    public void onSearchLastNameButton(ActionEvent actionEvent) {
        System.out.println("Bouton recherche par nom de famille cliqué");
        SearchFilter filter = new NameFilter();
        FilterCommand command = new FilterCommand();
        List<StudentObject> studentList = null;
        command.setType(LASTNAME);
        try {
            if (DataUtils.isNameNotValid(searchFilterNameField.getText())) {
                throw new StringInputException("Le nom est invalide");
            }
            command.setSearchString(searchFilterNameField.getText());

            studentList = filter
                    .getFilteredStudentList(command);
            this.updateStudentList(studentList);
        } catch (StringInputException e) {
            mainPageErrorLabel.setText(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onSearchFirstNameButton(ActionEvent actionEvent) {
        System.out.println("Bouton recherche par prénom cliqué");
        SearchFilter filter = new NameFilter();
        FilterCommand command = new FilterCommand();
        List<StudentObject> studentList = null;
        command.setType(FIRSTNAME);
        try {
            if (DataUtils.isNameNotValid(searchFilterFirstNameField.getText())) {
                throw new StringInputException("Le prénom est invalide");
            }
            command.setSearchString(searchFilterFirstNameField.getText());
            studentList = filter
                    .getFilteredStudentList(command);
            this.updateStudentList(studentList);
        } catch (StringInputException e) {
            mainPageErrorLabel.setText(e.getMessage());
        } catch (Exception e) {
            System.out.println("oups filtre de prénom échoué");
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onSearchGradeButton(ActionEvent actionEvent) {
        System.out.println("Bouton recherche par notes cliqué");
        SearchFilter filter = new RangeFilter();
        FilterCommand command = new FilterCommand();
        command.setType(AVERAGE);
        try {
        command.setGradeValues(searchFilterMinGradeField.getText(),
                searchFilterMaxGradeField.getText());
            List<StudentObject> studentList = filter
                    .getFilteredStudentList(command);
            this.updateStudentList(studentList);
        }  catch (StringInputException | NumberFormatException | SQLException e) {
            mainPageErrorLabel.setText(e.getMessage());
            this.resetGradeFilterFields();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onSearchAgeButton(ActionEvent actionEvent) {
        System.out.println("Bouton recherche par notes cliqué");
        SearchFilter filter = new RangeFilter();
        FilterCommand command = new FilterCommand();
        command.setType(AGE);
        try {
            command.setAgeValues(searchFilterMinAgeField.getText(),
                    searchFilterMaxAgeField.getText());
            List<StudentObject> studentList = filter
                    .getFilteredStudentList(command);
            this.updateStudentList(studentList);
        } catch (StringInputException | NumberFormatException | SQLException e) {
            mainPageErrorLabel.setText(e.getMessage());
            this.resetAgeFilterFields();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
}
