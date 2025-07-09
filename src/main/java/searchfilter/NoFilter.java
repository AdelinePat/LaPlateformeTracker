package searchfilter;

import DAO.FilterStudentDAO;
import model.Student;
import java.util.List;
import static exceptions.ExceptionMessage.INVALID_FILTER;

public class NoFilter implements ISearchFilter {
    public List<Student> getFilteredStudentList(FilterCommand filterCommand) throws Exception {
        if(FilterType.NOFILTER.equals(filterCommand.getType())){
                return FilterStudentDAO.getInitialStudentList();
        } else {
            throw new Exception(INVALID_FILTER.getMessage());
        }
    }

//    public List<Student> getInitialStudentList() {
//        List<Student> myList = new ArrayList<>();
//        try {
//            Connection conn = DatabaseConnection.databaseOpenConnexion();
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM student");
//            while (rs.next()) {
//                Student student = new Student(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getDouble(5));
//                myList.add(student);
//                System.out.println(student.toString());
//
//            }
//            rs.close();
//            st.close();
//            DatabaseConnection.databaseCloseConnexion();
//
//        } catch (SQLException e) {
//            System.out.println("ça n'a pas marché");
//        }
//        return myList;
//    }
}
