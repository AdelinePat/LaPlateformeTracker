package DAO;

import exceptions.FilterException;
import model.Student;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static exceptions.ExceptionMessage.*;

public class FilterStudentDAO {
    public static List<Student> firstnameFilter(String firstname) throws FilterException {
        List<Student> filteredList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE firstname ILIKE ?";

        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, firstname + "%"); // match firstnames starting with input

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)
                );
                filteredList.add(student);
//                System.out.println(student.toString());
            }

            rs.close();
            ps.close();
            DatabaseConnection.databaseCloseConnexion();
            if (filteredList.isEmpty()) {
                throw new FilterException(NO_RESULT.getMessage());
            }

        } catch (SQLException e) {
            throw new FilterException(SQL_ERROR.getMessage());
//            System.out.println("SQL Error during name filtering: " + e.getMessage());
        }
        return filteredList;
    }

    public static List<Student> lastnameFilter(String lastname) {
        List<Student> filteredList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE lastname ILIKE ?";

        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, lastname + "%"); // match firstnames starting with input

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)
                );
                filteredList.add(student);
//                System.out.println(student.toString());
            }

            rs.close();
            ps.close();
            DatabaseConnection.databaseCloseConnexion();
            if (filteredList.isEmpty()) {
                throw new FilterException(NO_RESULT.getMessage());
            }

        } catch (SQLException e) {
            throw new FilterException(SQL_ERROR.getMessage());
        }
        return filteredList;
    }

    public static List<Student> getInitialStudentList() {
        List<Student> filteredList = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student ORDER BY id_student ASC");
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5));
                filteredList.add(student);
//                System.out.println(student.toString());

            }
            rs.close();
            st.close();
            DatabaseConnection.databaseCloseConnexion();

            if (filteredList.isEmpty()) {
                throw new FilterException(NO_RESULT.getMessage());
            }

        } catch (SQLException e) {
            throw new FilterException(SQL_ERROR.getMessage());
        }
        return filteredList;
    }


    public static List<Student> ageFilter(int min, int max) throws FilterException {
        List<Student> filteredList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE age BETWEEN ? AND ?";


        Connection conn = null;
        try {
            conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)
                );
                filteredList.add(student);
//                System.out.println(student.toString());
            }
            rs.close();
            ps.close();
            DatabaseConnection.databaseCloseConnexion();

            if (filteredList.isEmpty()) {
                throw new FilterException(NO_RESULT.getMessage());
            }

        } catch (SQLException e) {
            throw new FilterException(SQL_ERROR.getMessage());
        } catch (NumberFormatException e) {
            throw new FilterException(SQL_FORMAT_ERROR.getMessage());
        }

        return filteredList;
    }

    public static List<Student> gradeFilter(float min, float max) throws FilterException {
        List<Student> filteredList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE average BETWEEN ? AND ?";

        Connection conn = null;
        try {
            conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println("ps : " + ps);
            ps.setFloat(1, min);
            ps.setFloat(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)
                );
                filteredList.add(student);
//                System.out.println(student.toString());
            }
            rs.close();
            ps.close();
            DatabaseConnection.databaseCloseConnexion();
        } catch (SQLException e) {
            throw new FilterException(SQL_ERROR.getMessage());
        } catch (NumberFormatException e) {
            throw new FilterException(SQL_FORMAT_ERROR.getMessage());
        }

        return filteredList;
    }
}
