package searchfilter;

import DAO.FilterStudentDAO;
import exceptions.FilterException;
import model.Student;
import java.util.List;
import static exceptions.ExceptionMessage.INVALID_FILTER;

public class NameFilter implements ISearchFilter {

//    private List<Student> lastnameFilter(String lastname) {
//        List<Student> filteredList = new ArrayList<>();
//        String query = "SELECT * FROM student WHERE lastname ILIKE ?";
//
//        try {
//            Connection conn = DatabaseConnection.databaseOpenConnexion();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, lastname + "%"); // match firstnames starting with input
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Student student = new Student(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getDouble(5)
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
//        return filteredList;
//    }

//    private List<Student> firstnameFilter(String firstname) {
//        List<Student> filteredList = new ArrayList<>();
//        String query = "SELECT * FROM student WHERE firstname ILIKE ?";
//
//        try {
//            Connection conn = DatabaseConnection.databaseOpenConnexion();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, firstname + "%"); // match firstnames starting with input
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Student student = new Student(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getDouble(5)
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
//        return filteredList;
//    }

    @Override
    public List<Student> getFilteredStudentList(FilterCommand filterCommand) throws FilterException {
        switch (filterCommand.getType()) {
            case LASTNAME:
                return FilterStudentDAO.lastnameFilter(filterCommand.getSearchString());
            case FIRSTNAME:
                return FilterStudentDAO.firstnameFilter(filterCommand.getSearchString());
            default: throw new FilterException(INVALID_FILTER.getMessage());
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
