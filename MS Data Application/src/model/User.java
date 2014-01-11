package model;

/**
 *
 * @author Marc
 */
public class User {

    private int userID;
    private String userName;
    private String password;
    private int accessLevel;


    public User(int userID, String userName, String password, int accessLevel) {
        this.userID = userID;
        this.userName = userName;

        this.password = password;
        this.accessLevel = accessLevel;
    }

    

    @Override
    public String toString() {
        return userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
