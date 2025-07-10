//package loginmodule;
//
//import model.User;
//import org.junit.jupiter.api.Test;
//import utils.DatabaseConnection;
//
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class RegisterTest {
//    User user = new User();
////    Register register = new Register();
//
//    @Test
//    public void registerTest() throws Exception {
//        user.setUserName("user1");
//        user.setPassword("pasSWWord1*");
//        user.register();
//    }
//
//    public void deleteData(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        String query = "DELETE FROM staff WHERE username = ?";
//        try {
//            Connection conn = DatabaseConnection.databaseOpenConnexion();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, user.getUserName());
//            ResultSet rs = ps.executeQuery();
//            ps.executeUpdate();
//            ps.close();
//            DatabaseConnection.databaseCloseConnexion();
//         } catch (SQLException e) {
//            System.out.println("User couldn't be deleted: " + e.getMessage());
//       }
//     }
//}

