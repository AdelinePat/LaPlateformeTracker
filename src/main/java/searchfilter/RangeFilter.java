package searchfilter;

import utils.DatabaseConnection;
import utils.StudentObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RangeFilter extends SearchFilter {

    private List<StudentObject> ageFilter(int min, int max) {
        List<StudentObject> filteredList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE age BETWEEN ? AND ?";

        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, min);
            ps.setInt(2, max);
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
        } catch (NumberFormatException e) {
            System.out.println("Error parsing range numbers: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error during range filtering: " + e.getMessage());
        }
        return filteredList;
    }

    private List<StudentObject> gradeFilter(float min, float max) {
        List<StudentObject> filteredList = new ArrayList<>();
        String query = "SELECT * FROM student WHERE average BETWEEN ? AND ?";

        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setFloat(1, min);
            ps.setFloat(2, max);
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
        } catch (NumberFormatException e) {
            System.out.println("Error parsing range numbers: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error during range filtering: " + e.getMessage());
        }
        return filteredList;
    }

    @Override
    public List<StudentObject> getFilteredStudentList(FilterCommand filterCommand) throws Exception {
        switch (filterCommand.getType()) {
            case AGE:
                return ageFilter(filterCommand.getMinAgeValue(), filterCommand.getMaxAgeValue());
            case AVERAGE:
                return gradeFilter(filterCommand.getMinGradeValue(), filterCommand.getMaxGradeValue());
            default: throw new Exception("blabla");
        }
    }

//    @Override
//    public List<StudentObject> getFilteredStudentList(String columnName, String contentRequest) {
//        List<StudentObject> filteredList = new ArrayList<>();
//
//        String[] parts = contentRequest.split("-");
//        if (parts.length != 2) {
//            System.out.println("Invalid range format. Use 'min-max'.");
//            return filteredList;
//        }
//
//        String query = "SELECT * FROM student WHERE " + columnName + " BETWEEN ? AND ?";
//
//        try {
//            int minValue = Integer.parseInt(parts[0].trim());
//            int maxValue = Integer.parseInt(parts[1].trim());
//
//            Connection conn = DatabaseConnection.databaseOpenConnexion();
//            PreparedStatement ps = conn.prepareStatement(query);
//
//            if (columnName.equals("average")) {
//                double min = Double.parseDouble(parts[0].trim());
//                double max = Double.parseDouble(parts[1].trim());
//
//                ps.setDouble(1, min);
//                ps.setDouble(2, max);
//            } else if (columnName.equals("age")) {
//                int min = Integer.parseInt(parts[0].trim());
//                int max = Integer.parseInt(parts[1].trim());
//
//                ps.setInt(1, min);
//                ps.setInt(2, max);
//            } else {
//                System.out.println("Unsupported column for range filtering: " + columnName);
//                return filteredList;
//            }
//
//            ps.setInt(1, minValue);
//            ps.setInt(2, maxValue);
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
//        } catch (NumberFormatException e) {
//            System.out.println("Error parsing range numbers: " + e.getMessage());
//        } catch (SQLException e) {
//            System.out.println("SQL Error during range filtering: " + e.getMessage());
//        }
//
//        return filteredList;
//    }
}
