/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import com.toedter.calendar.JDateChooser;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.*;
import view.CreateTaskPanel;
import view.TaskHandlingPanel;

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

    public static void addUserToOnTaskList(JList listUsers, JList listUsersOnTask, JButton button) {
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

    public static void removeUserFromTaskList(JList listUsers, JList listUsersOnTask, JButton button) {
        int index = listUsersOnTask.getSelectedIndex();
        DefaultListModel model = (DefaultListModel) listUsers.getModel();
        DefaultListModel modelOnTask = (DefaultListModel) listUsersOnTask.getModel();

        if (index != -1) {
            for (int i = 0; i < model.size(); i++) {
                if (model.get(i).toString().equals(listUsersOnTask.getSelectedValue().toString())) {
                    System.out.println("Fjerner " + listUsersOnTask.getSelectedValue());
                    model.removeElement(listUsersOnTask.getSelectedValue());
                }
            }
            model.addElement(listUsersOnTask.getSelectedValue());
            modelOnTask.removeElement(listUsersOnTask.getSelectedValue());

        } else {
            JOptionPane.showMessageDialog(button, "Der ikke valgt nogen medarbejder", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void fillWithSelectedTask(JList userList, JList userOnTaskLlist, JTable tableAllTasks, JTextField textFieldTaskName, JComboBox comboBoxType, JComboBox comboBoxStatus,
            JComboBox comboBoxCustomer, JComboBox comboBoxProjectLeader, JDateChooser dateChooserExpectedStart, JDateChooser dateChooserExpectedEnd,
            JTextField textFieldTime, JComboBox comboBoxPriority, JTextArea textAreaDescription) throws ParseException, SQLException, IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DefaultListModel model = (DefaultListModel) userList.getModel();
        DefaultListModel modelOnTask = (DefaultListModel) userOnTaskLlist.getModel();
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTasks.getModel();
        int taskID = Integer.parseInt(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 0).toString());

        textFieldTaskName.setText(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 2).toString());
        comboBoxType.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 3).toString());
        comboBoxStatus.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 4).toString());
        comboBoxCustomer.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 5).toString());
        comboBoxProjectLeader.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 6).toString());
        Date startDate = sdf.parse(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 7).toString());
        dateChooserExpectedStart.setDate(startDate);
        Date endDate = sdf.parse(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 8).toString());
        dateChooserExpectedEnd.setDate(endDate);
        textFieldTime.setText(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 9).toString());
        comboBoxPriority.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 10).toString());
        textAreaDescription.setText(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 11).toString());

        modelOnTask.clear();
        model.clear();
        Controller.fillList(userList, Controller.userList);

        ArrayList<User> userOnTaskList = Controller.dbHandler.SPgetUserOnTask(taskID);

        model = (DefaultListModel) userList.getModel();
        modelOnTask = (DefaultListModel) userOnTaskLlist.getModel();

        for (int i = 0; i < userOnTaskList.size(); i++) {
            modelOnTask.addElement(Controller.userList.get(i));
            System.out.println(modelOnTask.get(i).toString() + " er lige med : " + Controller.userList.get(i).getUserName().toString());
            if (modelOnTask.get(i).toString().equals(Controller.userList.get(i).getUserName().toString())) {
                System.out.println("Fjerner : " + Controller.userList.get(i));
                model.removeElement(Controller.userList.get(i));
            }
        }
    }

    public static void createNewTask(JTable tableAllTask, JList listUsersOnTask, JButton button, JCheckBox checkBoxSub, JTextField textFieldTaskName, JComboBox comboBoxType, JComboBox comboBoxStatus,
            JComboBox comboBoxCustomer, JComboBox comboBoxTaskLeader, JDateChooser dateChooserExpectedStart, JDateChooser dateChooserExpectedEnd,
            JTextField textFieldEstimatedTime, JComboBox comboBoxPriority, JTextArea textAreaDescription) {
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTask.getModel();
        Type type = (Type) comboBoxType.getSelectedItem();
        Statuss status = (Statuss) (comboBoxStatus.getSelectedItem());
        Customer customer = (Customer) comboBoxCustomer.getSelectedItem();
        User user = (User) comboBoxTaskLeader.getSelectedItem();
        String taskName = textFieldTaskName.getText();
        String taskDescription = textAreaDescription.getText();
        int taskID;
        int estimatedTime = Integer.parseInt(textFieldEstimatedTime.getText());
        int priority = Integer.parseInt(comboBoxPriority.getSelectedItem().toString());
        //ArrayList<User> listUsersOnTask = Controller.userList;

        System.out.println("Row selected = " + tableAllTask.getSelectedRow());
        if (checkBoxSub.isSelected()) {
            if (tableAllTask.getSelectedRow() != -1) {
                taskID = Integer.parseInt(modelTable.getValueAt(tableAllTask.getSelectedRow(), 0).toString());
                try {
                    Task task = new Task(taskName,
                            taskID,
                            type,
                            status,
                            customer,
                            user,
                            dateChooserExpectedStart.getDate(),
                            dateChooserExpectedEnd.getDate(),
                            estimatedTime,
                            priority,
                            taskDescription);

                    Controller.dbHandler.createSubTask(task);
                    Controller.dbHandler.addUserToTask(listUsersOnTask);

                } catch (SQLException | IOException ex) {
                    Logger.getLogger(CreateTaskPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(button, "Der ikke valgt nogen opgave at lav delopgave til", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
            }
        } else if (!checkBoxSub.isSelected()) {
            try {
                Task task = new Task(taskName,
                        type,
                        status,
                        customer,
                        user,
                        dateChooserExpectedStart.getDate(),
                        dateChooserExpectedEnd.getDate(),
                        estimatedTime,
                        priority,
                        taskDescription);

                Controller.dbHandler.createTask(task);
                Controller.dbHandler.addUserToTask(listUsersOnTask);
                Controller.fillTableWithTask(tableAllTask);
            } catch (SQLException | IOException ex) {
                Logger.getLogger(CreateTaskPanel.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    public static void SaveChangesToTask(JTable tableAllTasks,JList listUsers, JList listUsersOnTask, JButton button, JTextField textFieldTaskName, JComboBox comboBoxType, JComboBox comboBoxStatus,
            JComboBox comboBoxCustomer, JComboBox comboBoxTaskLeader, JDateChooser dateChooserExpectedStart, JDateChooser dateChooserExpectedEnd,
            JTextField textFieldEstimatedTime, JComboBox comboBoxPriority, JTextArea textAreaDescription){
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTasks.getModel();
        Type type = new Type(comboBoxType.getSelectedItem().toString());
        Statuss status = new Statuss(comboBoxStatus.getSelectedItem().toString());
        Customer customer = new Customer(comboBoxCustomer.getSelectedItem().toString());
        User user = new User(comboBoxTaskLeader.getSelectedItem().toString());

        Task task = new Task(Integer.parseInt(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 0).toString()),
                textFieldTaskName.getText(),
                type,
                status,
                customer,
                user,
                dateChooserExpectedStart.getDate(),
                dateChooserExpectedEnd.getDate(),
                Integer.parseInt(textFieldEstimatedTime.getText()),
                Integer.parseInt(comboBoxPriority.getSelectedItem().toString()),
                textAreaDescription.getText());
        try {
            Controller.dbHandler.SPremoveAllUsersOnTask(task.getTaskID());
            Controller.dbHandler.updateTask(task);
            Controller.dbHandler.addUserToAlreadyMadeTask(listUsersOnTask, task.getTaskID());

            Controller.fillList(listUsers, Controller.userList);

            Controller.fillTableWithTask(tableAllTasks);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
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
