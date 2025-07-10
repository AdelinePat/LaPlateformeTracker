package DAO;

import exceptions.DataException;
import utils.DatabaseConnection;
import model.Student;

import java.sql.*;

import static exceptions.ExceptionMessage.SQL_ERROR;

public class StudentDAO extends UserDAO {

    public static void addStudent(Student student) throws DataException {
        String query = "INSERT INTO student (lastname, firstname, age, average) " +
                "VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getLastname());
            preparedStatement.setString(2, student.getFirstname());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setDouble(4, student.getGrade());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            DatabaseConnection.databaseCloseConnexion();

        } catch (SQLException e) {
            throw new DataException(SQL_ERROR.getMessage());
        }
    }

    public static void updateStudent(Student modifiedStudent) throws DataException {
        String query = "UPDATE student SET lastname = ?, firstname = ?, age = ?, average = ? " +
                "WHERE id_student = ?";

        try {
            Connection connection = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, modifiedStudent.getLastname());
            preparedStatement.setString(2, modifiedStudent.getFirstname());
            preparedStatement.setInt(3, modifiedStudent.getAge());
            preparedStatement.setDouble(4, modifiedStudent.getGrade());
            preparedStatement.setInt(5, modifiedStudent.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            DatabaseConnection.databaseCloseConnexion();

        } catch (SQLException e) {
            throw new DataException(SQL_ERROR.getMessage());
        }
    }

    public static void deleteStudent(Student student) throws DataException {
        String query = "DELETE FROM student WHERE id_student = ?";

        try {
            Connection connection = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            DatabaseConnection.databaseCloseConnexion();
        } catch (SQLException e) {
            throw new DataException(SQL_ERROR.getMessage());
        }
    }
}
