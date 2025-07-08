package loginmodule;

import utils.UserObject;

public class RegisterTest {
    UserObject user = new UserObject();
    Register register = new Register();

//    @Test
//    public void registerTest() throws Exception {
//        user.setUserName("user1");
//        user.setPassword("pasSWWord1*");
//        register.register(user);
//    }

//    public void deleteData(UserObject user) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        String query = "DELETE FROM staff WHERE username = ?";
//        try {
//            Connection conn = DatabaseConnection.databaseOpenConnexion();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, user.getUserName());
////            ResultSet rs = ps.executeQuery();
//            ps.executeUpdate();
//            ps.close();
//            DatabaseConnection.databaseCloseConnexion();
//        } catch (SQLException e) {
//            System.out.println("User couldn't be deleted: " + e.getMessage());
//        }
//    }
}

