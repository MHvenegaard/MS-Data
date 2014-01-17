package model;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class User {

    private int userID;
    private String userName;
    private String password;
    private int accessLevel;

    /**
     * Creates an object of User
     *
     * @param userID
     * @param userName
     * @param password
     * @param accessLevel
     */
    public User(int userID, String userName, String password, int accessLevel) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    /**
     * @return - userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return - userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return - password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return -accessLevel
     */
    public int getAccessLevel() {
        return accessLevel;
    }

    /**
     * @param accessLevel
     */
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    /**
     * @return - userName
     */
    @Override
    public String toString() {
        return userName;
    }
}
