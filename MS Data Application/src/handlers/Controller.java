/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import model.*;

/**
 *
 * @author Marc
 */
public class Controller {

public static User currentUser;
public static DBHandler dbHandler;

    public Controller(User currentUser) {
        this.currentUser = currentUser;
        dbHandler = new DBHandler();
    }
    

    
    
    
    
}
