package DAO;

import utils.DatabaseConnection;
import utils.StudentObject;

import java.sql.*;

public class StudentDAO extends UserDAO {

    public static void addStudent(StudentObject student) {
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
            System.out.println("Creation couldn't complete");
        }
    }

    public static void updateStudent(StudentObject modifiedStudent) {
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
            System.out.println("Update couldn't complete");
        }
    }

    public static void deleteStudent(StudentObject student) {
        String query = "DELETE FROM student WHERE id_student = ?";

        try {
            Connection connection = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            DatabaseConnection.databaseCloseConnexion();
        } catch (SQLException e) {
            System.out.println("ça n'a pas marché");
        }
    }
}
