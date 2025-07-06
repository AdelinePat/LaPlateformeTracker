package SearchFilter;

import Utils.DatabaseConnection;
import Utils.StudentObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FirstnameFilter implements ISearchFilter {
    public List<StudentObject> filterRequest() {
        List<StudentObject> myList = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            System.out.println("connexion à la db ok");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            System.out.println("J'essaye de récupérer la liste des étudiants");
            while (rs.next()) {
                int id = rs.getInt(1);
                String lastname = rs.getString(2);
                String firstname = rs.getString(3);
                int age = rs.getInt(4);
                int average = rs.getInt(5);
                StudentObject student = new StudentObject(id, lastname, firstname, age, average);
                System.out.println(student.toString());
                myList.add(student);
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("ça n'a pas marché");
        }
        return myList;
    }
}
