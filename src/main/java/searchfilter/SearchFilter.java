package searchfilter;

import utils.DatabaseConnection;
import utils.StudentObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class SearchFilter {

    public List<StudentObject> getInitialStudentList() {
        List<StudentObject> myList = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                StudentObject student = new StudentObject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5));
                myList.add(student);
                System.out.println(student.toString());

            }
            rs.close();
            st.close();
            DatabaseConnection.databaseCloseConnexion();

        } catch (SQLException e) {
            System.out.println("ça n'a pas marché");
        }
        return myList;
    }
    public abstract List<StudentObject> getFilteredStudentList(FilterCommand filterCommand) throws Exception;
//    public abstract List<StudentObject> getFilteredStudentList(String columnName, String contentRequest);
}
