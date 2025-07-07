package Utils;

import DAO.UserDAO;

import java.util.List;

public class UserObject {
    private String userName;
    private String hashPassword;
    public List<Integer> ageRange;
    public List<Integer> gradeRange;
    public String FirstnameFilter;
    public String LastnameFilter;

    public boolean login() {
        return UserDAO.doesUserExist(this.userName) && UserDAO.doesPasswordMatch(this.userName, this.hashPassword);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public String getUserName() {
        return userName;
    }
}
