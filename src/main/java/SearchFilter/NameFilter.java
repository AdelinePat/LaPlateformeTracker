package SearchFilter;

import Utils.DatabaseConnection;
import Utils.StudentObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NameFilter extends SearchFilter {

    private List<StudentObject> lastnameFilter(String lastname) {
        List<StudentObject> filteredList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE lastname ILIKE ?";

        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, lastname + "%"); // match firstnames starting with input

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentObject student = new StudentObject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)
                );
                filteredList.add(student);
                System.out.println(student.toString());
            }

            rs.close();
            ps.close();
            DatabaseConnection.databaseCloseConnexion();

        } catch (SQLException e) {
            System.out.println("SQL Error during name filtering: " + e.getMessage());
        }
        return filteredList;
    }

    private List<StudentObject> firstnameFilter(String firstname) {
        List<StudentObject> filteredList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE firstname ILIKE ?";

        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, firstname + "%"); // match firstnames starting with input

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentObject student = new StudentObject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)
                );
                filteredList.add(student);
                System.out.println(student.toString());
            }

            rs.close();
            ps.close();
            DatabaseConnection.databaseCloseConnexion();

        } catch (SQLException e) {
            System.out.println("SQL Error during name filtering: " + e.getMessage());
        }
        return filteredList;
    }

    @Override
    public List<StudentObject> getFilteredStudentList(FilterCommand filterCommand) throws Exception {
        switch (filterCommand.getType()) {
            case LASTNAME:
                return lastnameFilter(filterCommand.getSearchString());
            case FIRSTNAME:
                return firstnameFilter(filterCommand.getSearchString());
            default: throw new Exception("blabla");
        }
    }


//    @Override
//    public List<StudentObject> getFilteredStudentList(String columnName, String contentRequest) {
//        List<StudentObject> filteredList = new ArrayList<>();
//        String query = "SELECT * FROM student WHERE " + columnName + " ILIKE ?";
//
//        try {
//            Connection conn = DatabaseConnection.databaseOpenConnexion();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, contentRequest + "%"); // match firstnames starting with input
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                StudentObject student = new StudentObject(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getInt(5)
//                );
//                filteredList.add(student);
//                System.out.println(student.toString());
//            }
//
//            rs.close();
//            ps.close();
//            DatabaseConnection.databaseCloseConnexion();
//
//        } catch (SQLException e) {
//            System.out.println("SQL Error during name filtering: " + e.getMessage());
//        }
//
//        return filteredList;
//    }
}
