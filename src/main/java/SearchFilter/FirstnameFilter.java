package SearchFilter;

import Utils.DatabaseConnection;
import Utils.StudentObject;
import javafx.scene.control.TableColumn;

import javax.xml.crypto.Data;
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
                StudentObject student = new StudentObject(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
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
}
