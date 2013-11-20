/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import model.*;

/**
 *
 * @author Marc
 */
public class Controller {

    public static User currentUser;
    public static DBHandler dbHandler;

    public Controller() throws ClassNotFoundException {
        currentUser = null;
        dbHandler = new DBHandler();
    }

    public void checkInternet() throws IOException {

        Socket socket = null;
        boolean reachable = false;

        socket = new Socket("http://www.google.dk/", 80);

        if (socket != null) {
            socket.close();
        }
    }

    public void setUser(User user) {
        currentUser = user;
    }

    public DBHandler getDBHandler() {
        return dbHandler;
    }
}
