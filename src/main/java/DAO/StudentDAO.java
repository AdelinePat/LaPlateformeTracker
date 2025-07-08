package DAO;

import utils.DatabaseConnection;
import utils.StudentObject;

import java.sql.*;

public class StudentDAO extends UserDAO {
    public static void addStudent(StudentObject student) {
    }

    public static void updateStudent(StudentObject student) {
        // considering that the studentobject is updated through the GUI
        // just need to overwrite the past student using ID and change everything
        // into the value of the current Student Object
    }

    public static void deleteStudent(StudentObject student) {
        String query = "DELETE FROM student WHERE id_student = ?";

        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, student.getId());
            ps.executeQuery();
            ps.close();
            DatabaseConnection.databaseCloseConnexion();
        } catch (SQLException e) {
            System.out.println("ça n'a pas marché");
        }
    }
}
