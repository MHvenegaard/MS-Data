/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.io.IOException;
import java.net.Socket;
import model.*;

/**
 *
 * @author Marc
 */
public class Controller {

    public final static int VERSION_NUMBER = 1;
    public static User currentUser;
    public static DBHandler dbHandler;
    public static TableHandler tHandler;
 
    public Controller(User user) throws ClassNotFoundException {
        currentUser = user;
        dbHandler = new DBHandler();
        tHandler = new TableHandler();
        
    }

    public static void checkInternet() throws IOException {

        Socket socket = null;

        socket = new Socket("173.194.70.94", 80);

        if (socket != null) {
            socket.close();
        }
    }

    public void setUser(User user) {
        currentUser = user;
    }
    
    public User getUser(){
        return currentUser;
    }

    public DBHandler getDBHandler() {
        return dbHandler;
    }
    
    public TableHandler getTableHandler(){
        return tHandler;
    }
    
}
