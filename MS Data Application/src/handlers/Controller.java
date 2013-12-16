/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    public static ArrayList<Customer> customerList;
    public static ArrayList<Task> tasks;

    public Controller(User user) throws ClassNotFoundException, SQLException, IOException {
        currentUser = user;
        dbHandler = new DBHandler();
        tHandler = new TableHandler();
        userList = dbHandler.SPgetUsers();
        typeList = dbHandler.SPgetTypes();
        statusList = dbHandler.SPgetStatus();
        customerList = dbHandler.SPgetCustomers();
        tasks = Controller.dbHandler.SPgetTasks();
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
            //combobox.addItem(arrayList.get(i).toString());
            combobox.addItem(arrayList.get(i));
        }
        combobox.setSelectedIndex(0);
    }

    public static void fillList(JList list, ArrayList arrayList) throws SQLException, IOException {
        DefaultListModel model = new DefaultListModel();
       //DefaultListModel modelOnTask = new DefaultListModel();
        //ListUsersOnTask.setModel(modelOnTask);

        list.setModel(model);
        model.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            model.addElement(arrayList.get(i));
        }
    }

    public static Date getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = sdf.format(date);
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(date);
        return date;

    }

    public static ArrayList<Task> fillTableWithTask(JTable tableAllTask) throws IOException, SQLException {
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTask.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < tasks.size(); i++) {
            Object[] data = {tasks.get(i).getTaskID(),
                tasks.get(i).getParentID(),
                tasks.get(i).getTaskName(),
                tasks.get(i).getType(),
                tasks.get(i).getStatus(),
                tasks.get(i).getCustomer(),
                tasks.get(i).getUser(),
                tasks.get(i).getStartDate(),
                tasks.get(i).getEndDate(),
                tasks.get(i).getEstimatedtime(),
                tasks.get(i).getPriority(),
                tasks.get(i).getDescription()};
            modelTable.addRow(data);
        }
        return tasks;
    }

    public static void addUserToOnTaskList(JList listUsers, JList listUsersOnTask, JButton button){
         int index = listUsers.getSelectedIndex();

       DefaultListModel model = (DefaultListModel) listUsers.getModel();
       DefaultListModel modelOnTask = (DefaultListModel) listUsersOnTask.getModel();

        if (index != -1) {
            modelOnTask.addElement(listUsers.getSelectedValue());
            model.removeElement(listUsers.getSelectedValue());
        } else {
            JOptionPane.showMessageDialog(button, "Der ikke valgt nogen medarbejder", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
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
