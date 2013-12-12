/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
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
    public static ArrayList<User> userList;
    public static ArrayList<Type> typeList;
    public static ArrayList<Statuss> statusList;

    public Controller(User user) throws ClassNotFoundException, SQLException, IOException {
        currentUser = user;
        dbHandler = new DBHandler();
        tHandler = new TableHandler();
        userList = dbHandler.SPgetUsers();
        typeList = dbHandler.SPgetTypes();
        statusList = dbHandler.SPgetStatus();

    }

    public static void checkInternet() throws IOException {

        Socket socket = null;

        socket = new Socket("173.194.70.94", 80);

        if (socket != null) {
            socket.close();
        }
    }

    public static void fillCombobox(JComboBox combobox, ArrayList arrayList) throws SQLException, IOException {

        for (int i = 0; i < arrayList.size(); i++) {
            combobox.addItem(arrayList.get(i).toString());
        }
        combobox.setSelectedIndex(0);
    }

    public static void fillList(JList list, ArrayList arrayList) throws SQLException, IOException {
        DefaultListModel model = new DefaultListModel();
        DefaultListModel modelOnTask = new DefaultListModel();
        //ListUsersOnTask.setModel(modelOnTask);
        
        list.setModel(model);
        model.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            model.addElement(arrayList.get(i));
        }
    }

    public void setUser(User user) {
        currentUser = user;
    }

    public User getUser() {
        return currentUser;
    }

    public DBHandler getDBHandler() {
        return dbHandler;
    }

    public TableHandler getTableHandler() {
        return tHandler;
    }
}
