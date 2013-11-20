/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marc
 */
public class User {

    private String userName;
    
    public User(String userName) {
        
        this.userName = userName;
        
    }

    @Override
    public String toString() {
        return userName;
    }
    
    
}
