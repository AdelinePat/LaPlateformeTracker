package searchfilter;

import DAO.FilterStudentDAO;
import exceptions.FilterException;
import model.Student;
import java.sql.SQLException;
import java.util.List;
import static exceptions.ExceptionMessage.INVALID_FILTER;

public class RangeFilter implements ISearchFilter {

//    private List<Student> ageFilter(int min, int max) throws SQLException, NumberFormatException{
//        System.out.println("Inside RangeFilter : ageFilter");
//
//        List<Student> filteredList = new ArrayList<>();
//        String query = "SELECT * FROM student WHERE age BETWEEN ? AND ?";
//
//        System.out.println("Inside ageFilter : " + query);
//
//        Connection conn = DatabaseConnection.databaseOpenConnexion();
//        PreparedStatement ps = conn.prepareStatement(query);
//        ps.setInt(1, min);
//        ps.setInt(2, max);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Student student = new Student(
//                    rs.getInt(1),
//                    rs.getString(2),
//                    rs.getString(3),
//                    rs.getInt(4),
//                    rs.getDouble(5)
//            );
//            filteredList.add(student);
//            System.out.println(student.toString());
//        }
//        rs.close();
//        ps.close();
//        DatabaseConnection.databaseCloseConnexion();
//
//        return filteredList;
//    }

//    private List<Student> gradeFilter(float min, float max) throws SQLException, NumberFormatException {
//        List<Student> filteredList = new ArrayList<>();
//        String query = "SELECT * FROM student WHERE average BETWEEN ? AND ?";
//        Connection conn = DatabaseConnection.databaseOpenConnexion();
//        PreparedStatement ps = conn.prepareStatement(query);
//        System.out.println("ps : " + ps);
//        ps.setFloat(1, min);
//        ps.setFloat(2, max);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Student student = new Student(
//                    rs.getInt(1),
//                    rs.getString(2),
//                    rs.getString(3),
//                    rs.getInt(4),
//                    rs.getDouble(5)
//            );
//            filteredList.add(student);
//            System.out.println(student.toString());
//        }
//        rs.close();
//        ps.close();
//        DatabaseConnection.databaseCloseConnexion();
//
//        return filteredList;
//    }

    @Override
    public List<Student> getFilteredStudentList(FilterCommand filterCommand) throws FilterException, NumberFormatException, SQLException {
        switch (filterCommand.getType()) {
            case AGE:
                return FilterStudentDAO.ageFilter(filterCommand.getMinAgeValue(), filterCommand.getMaxAgeValue());
            case AVERAGE:
                return FilterStudentDAO.gradeFilter(filterCommand.getMinGradeValue(), filterCommand.getMaxGradeValue());
            default: throw new FilterException(INVALID_FILTER.getMessage());
        }
    }
}
