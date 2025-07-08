package Utils;

import DAO.UserDAO;

import java.util.List;

public class UserObject {
    private String userName;
    private String password;
    public List<Integer> ageRange;
    public List<Integer> gradeRange;
    public String FirstnameFilter;
    public String LastnameFilter;

    public boolean login() {
        return UserDAO.doesUserExist(this.userName) && UserDAO.doesPasswordMatch(this.userName, this.password);
    }

    public static String hashPassword() {
//        PBEKeySpec spec = new PBEKeySpec(this.password.toCharArray())
        return new String();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
