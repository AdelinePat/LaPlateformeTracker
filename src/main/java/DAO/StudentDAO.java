package DAO;

import utils.DatabaseConnection;
import utils.StudentObject;

import java.sql.*;

public class StudentDAO extends UserDAO {

    public static void addStudent(StudentObject student) {

    }

    public static void updateStudent(StudentObject student, String lastName, String firstName, int age, double grade) {
        String query = "UPDATE student SET lastname = ?, firstname = ?, age = ?, average = ? " +
                "WHERE id_student = ?";

        System.out.println("Trying to update student: " +
                student.getId() + " | " +
                student.getLastname() + ", " +
                student.getFirstname() + " | " +
                student.getAge() + " ans | moyenne: " + student.getGrade()
        );

        try {
            Connection connection = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, firstName);
            preparedStatement.setInt(3, age);
            preparedStatement.setDouble(4, grade);
            preparedStatement.setInt(5, student.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
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
