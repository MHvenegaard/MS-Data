package model;

/**
 *
 * @author Marc
 */
public class User {

    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private int accessLevel;
    
    public User(String userName) {
        
        this.userName = userName;
        
    }

    @Override
    public String toString() {
        return userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
