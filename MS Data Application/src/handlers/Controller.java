package handlers;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.table.TableColumn;
import model.*;
import view.CreateTaskPanel;

/**
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
    public static ArrayList<Task> tasks;
    public static ArrayList<Task> children;
    public static ArrayList<Customer> customerList;
    public static ArrayList<TimeSpentOnTask> tsotList;
    public static int customerID;
    //public static JFrame frame;

    public Controller() throws ClassNotFoundException, SQLException, IOException {
        currentUser = null;
        dbHandler = new DBHandler();
        tHandler = new TableHandler();
        tsotList = new ArrayList();
        userList = new ArrayList();
        typeList = new ArrayList();
        statusList = new ArrayList();
        customerList = new ArrayList();
        tasks = new ArrayList();
    }

    public void initiateController() throws SQLException, IOException {
        Connection conn = (Connection) dbHandler.initiateSystemDBConn()[0];

        userList = dbHandler.initiateUserList(conn);
        typeList = dbHandler.initiateTypeList(conn);
        statusList = dbHandler.initiateStatusList(conn);
        customerList = dbHandler.initiateCustomerList(conn);
        tasks = dbHandler.initiateTaskList(conn);
        tsotList = dbHandler.initiateTimeSpentOnTaskList(conn);
        // frame = new CustomerLookUpFrame();
        children = new ArrayList<>();
        setUsersOnTask();
    }

    public void setUsersOnTask() throws SQLException, IOException {
        for (int i = 0; i < tasks.size(); i++) {
            for (int j = 0; j < tsotList.size(); j++) {
                if (tasks.get(i).getTaskID() == tsotList.get(j).getTaskID()) {
                    // Run through userList to find the userObject
                    for (int k = 0; k < userList.size(); k++) {
                        if (userList.get(k).getUserID() == tsotList.get(j).getUserID()) {
                            // Add user to the userlist on task
                            tasks.get(i).addToUserOnTask(userList.get(k));
                        }
                    }
                }
            }
        }
    }

    //Universalmetoder
    public static void fillCombobox(JComboBox combobox, ArrayList arrayList) throws SQLException, IOException {
        for (int i = 0; i < arrayList.size(); i++) {
            combobox.addItem(arrayList.get(i));
        }
    }

    public static void fillList(JList list, ArrayList arrayList) throws SQLException, IOException {
        DefaultListModel model = new DefaultListModel();
        list.setModel(model);
        model.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            model.addElement(arrayList.get(i));
        }
    }

    //Fills JList.UserOnTaskList and removes ppl from JList.UserList
    public static void fillAndRemove(JList uList, JList userOnTaskLlist, ArrayList<User> userOnTask) throws SQLException, IOException {

        DefaultListModel model = (DefaultListModel) uList.getModel();
        DefaultListModel modelOnTask = (DefaultListModel) userOnTaskLlist.getModel();

        model.clear();
        for (int i = 0; i < userList.size(); i++) {
            model.addElement(userList.get(i));

        }
        modelOnTask.clear();

        for (int i = 0; i < userOnTask.size(); i++) {
            modelOnTask.addElement(userOnTask.get(i));
            for (int j = 0; j < userList.size(); j++) {
                if (modelOnTask.get(i).toString().equals(userList.get(j).getUserName().toString())) {
                    model.removeElement(userList.get(j));
                }
            }
        }
    }

    //Returns the current date
    public static Date getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = sdf.format(date);
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public static void fillTableWithList(JTable tableAllTask, ArrayList<Task> fillList) throws IOException, SQLException {

        DefaultTableModel modelTable = (DefaultTableModel) tableAllTask.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < fillList.size(); i++) {
            Object[] data = {fillList.get(i).getTaskID(),
                fillList.get(i).getParentID(),
                fillList.get(i).getTaskName(),
                fillList.get(i).getType(),
                fillList.get(i).getStatus(),
                fillList.get(i).getCustomer(),
                fillList.get(i).getUser(),
                fillList.get(i).getStartDate(),
                fillList.get(i).getEndDate(),
                fillList.get(i).getEstimatedtime(),
                fillList.get(i).getPriority(),
                fillList.get(i).getDescription()};
            modelTable.addRow(data);

        }
    }

    public static void fillTableWithCustomer(JTable tableAllTask) throws IOException, SQLException {
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTask.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < customerList.size(); i++) {
            Object[] data = {customerList.get(i).getCustomerID(),
                customerList.get(i).getCompanyName(),
                customerList.get(i).getPhone(),
                customerList.get(i).getPhone()};
            modelTable.addRow(data);
        }
    }

    //add and remove users in the userlists
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
                    model.removeElement(listUsersOnTask.getSelectedValue());
                }
            }
            model.addElement(listUsersOnTask.getSelectedValue());
            modelOnTask.removeElement(listUsersOnTask.getSelectedValue());

        } else {
            JOptionPane.showMessageDialog(button, "Der ikke valgt nogen medarbejder", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void fillComponents(int taskID, JList userList, JList userOnTaskLlist, JTable tableAllTasks, JTextField textFieldTaskName, JComboBox comboBoxType, JComboBox comboBoxStatus,
            JTextField comboBoxCustomer, JComboBox comboBoxProjectLeader, JDateChooser dateChooserExpectedStart, JDateChooser dateChooserExpectedEnd,
            JTextField textFieldTime, JComboBox comboBoxPriority, JTextArea textAreaDescription) throws SQLException, IOException {

        Task t = getSelectedTask(taskID);

        textFieldTaskName.setText(t.getTaskName());
        comboBoxType.setSelectedItem(t.getType());
        comboBoxStatus.setSelectedItem(t.getStatus());
        comboBoxCustomer.setText(t.getCustomer().getCompanyName());
        comboBoxProjectLeader.setSelectedIndex((t.getUser().getUserID()) - 1);
        textFieldTime.setText(t.getEstimatedtime() + "");
        comboBoxPriority.setSelectedItem(t.getPriority());
        textAreaDescription.setText(t.getDescription());
        dateChooserExpectedStart.setDate(t.getStartDate());
        dateChooserExpectedEnd.setDate(t.getEndDate());

        Controller.fillAndRemove(userList, userOnTaskLlist, t.getUserOnTask());

    }

    public static void createNewTask(JTable tableAllTask, JList listUsersOnTask, JButton button, JCheckBox checkBoxSub, JTextField textFieldTaskName, JComboBox comboBoxType, JComboBox comboBoxStatus,
            JTextField textFieldCustomer, JComboBox comboBoxTaskLeader, JDateChooser dateChooserExpectedStart, JDateChooser dateChooserExpectedEnd,
            JTextField textFieldEstimatedTime, JComboBox comboBoxPriority, JTextArea textAreaDescription) throws ParseException {

        DefaultTableModel modelTable = (DefaultTableModel) tableAllTask.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Type type = (Type) comboBoxType.getSelectedItem();
        Statuss status = (Statuss) (comboBoxStatus.getSelectedItem());
        Customer customer = null;
        User user = (User) comboBoxTaskLeader.getSelectedItem();
        String taskName = textFieldTaskName.getText();
        String taskDescription = textAreaDescription.getText();
        int taskID;
        int estimatedTime = Integer.parseInt(textFieldEstimatedTime.getText());
        int priority = Integer.parseInt(comboBoxPriority.getSelectedItem().toString());
        Date taskStartDate = dateChooserExpectedStart.getDate();
        Date taskEndDate = dateChooserExpectedEnd.getDate();

        for (int i = 0; i < Controller.customerList.size(); i++) {
            if (Controller.customerList.get(i).getCustomerID() == Integer.parseInt(textFieldCustomer.getText())) {
                customer = Controller.customerList.get(i);
            }
        }

        try {
            if (taskName.equals("") == true) {
                System.out.println("Der er opstået en fejl ! Er alle felter med stjerne udfyldt? Og er den valgte slut dato efter start dato?");
            } else if (checkBoxSub.isSelected()) {
                Date ParentStartDate = sdf.parse(modelTable.getValueAt(tableAllTask.getSelectedRow(), 7).toString());
                Date ParentEndDate = sdf.parse(modelTable.getValueAt(tableAllTask.getSelectedRow(), 8).toString());
                Boolean taskChecker = Controller.subTaskDateChecker(taskStartDate, taskEndDate, ParentStartDate, ParentEndDate);
                System.out.println("taskChecker : " + taskChecker);

                if (tableAllTask.getSelectedRow() != -1 && taskChecker) {
                    taskID = Integer.parseInt(modelTable.getValueAt(tableAllTask.getSelectedRow(), 0).toString());

                    try {
                        Task task = new Task(taskName,
                                taskID,
                                type,
                                status,
                                customer,
                                user,
                                taskStartDate,
                                taskEndDate,
                                estimatedTime,
                                priority,
                                taskDescription);

                        Controller.dbHandler.createSubTask(task);
                        Controller.dbHandler.addUserToTask(listUsersOnTask);

                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(CreateTaskPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(button, "Der ikke valgt nogen opgave at lav delopgave til eller den valgte dato ikke er inde for opgaven", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
                }
            } else if (!checkBoxSub.isSelected()) {
                try {
                    Task task = new Task(taskName,
                            type,
                            status,
                            customer,
                            user,
                            taskStartDate,
                            taskEndDate,
                            estimatedTime,
                            priority,
                            taskDescription);
                    System.out.println("Customer i con : " + customer);
                    Controller.dbHandler.createTask(task);
                    Controller.dbHandler.addUserToTask(listUsersOnTask);
                    // Controller.fillTableWithTask(tableAllTask);
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(CreateTaskPanel.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        } catch (NumberFormatException ne) {
            System.out.println("Forventet tidsforbrug skal være et tal");
        }
    }

    public static void setCurrentUserIDToTextField(JTextField textFieldUser) {
        textFieldUser.setText(currentUser.getUserName() + "");
    }

    public static Boolean subTaskDateChecker(Date supTaskStartDate, Date supTaskEndDate, Date parentStartDate, Date parentEndDate) {
        Boolean result = true;
        if (supTaskStartDate.before(parentStartDate)
                || supTaskStartDate.after(parentEndDate)
                || supTaskStartDate.after(supTaskEndDate)
                || supTaskEndDate.after(parentEndDate)) {
            result = false;
        }

        return result;
    }

    public static void SaveChangesToTask(JTable tableAllTasks, JList listUsers, JList listUsersOnTask, JButton button, JTextField textFieldTaskName,
            JComboBox comboBoxType, JComboBox comboBoxStatus, JTextField textFieldCustomer, JComboBox comboBoxTaskLeader, JDateChooser dateChooserExpectedStart,
            JDateChooser dateChooserExpectedEnd, JTextField textFieldEstimatedTime, JComboBox comboBoxPriority, JTextArea textAreaDescription) {

        System.out.println("Start saveChangesToTask");
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTasks.getModel();
        DefaultListModel modelOnTask = (DefaultListModel) listUsersOnTask.getModel();
        Type type = null;
        Statuss status = null;
        Customer customer = null;
        //  FEJL I USER
        User user = null;
        System.out.println((comboBoxType.getSelectedItem().toString()));
        for (int i = 0; i < Controller.statusList.size(); i++) {
            if (Controller.statusList.get(i).getStatussName().equals(comboBoxStatus.getSelectedItem().toString())) {
                status = Controller.statusList.get(i);
            }
        }

        for (int i = 0; i < Controller.customerList.size(); i++) {
            if (Controller.customerList.get(i).getCompanyName().equals(textFieldCustomer.getText())) {
                customer = Controller.customerList.get(i);
            }
        }

        for (int i = 0; i < Controller.userList.size(); i++) {
            if (Controller.userList.get(i).getUserName().equals(comboBoxTaskLeader.getSelectedItem().toString())) {
                user = Controller.userList.get(i);
            }
        }

        for (int i = 0; i < Controller.typeList.size(); i++) {
            if (Controller.typeList.get(i).getTypeName().equals(comboBoxType.getSelectedItem().toString())) {
                type = Controller.typeList.get(i);
            }
        }

        ArrayList<User> userOnTask = new ArrayList<>();

        for (int i = 0; i < modelOnTask.getSize(); i++) {
            userOnTask.add((User) modelOnTask.getElementAt(i));
        }

        Task task = new Task(Integer.parseInt(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 0).toString()),
                Integer.parseInt(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 1).toString()),
                textFieldTaskName.getText(),
                type,
                status,
                customer,
                user,
                dateChooserExpectedStart.getDate(),
                dateChooserExpectedEnd.getDate(),
                Integer.parseInt(textFieldEstimatedTime.getText()),
                Integer.parseInt(comboBoxPriority.getSelectedItem().toString()),
                textAreaDescription.getText(),
                userOnTask);
        try {
            //  Controller.dbHandler.SPremoveAllUsersOnTask(task.getTaskID());
            Controller.dbHandler.updateTask(task);
            // Controller.dbHandler.addUserToAlreadyMadeTask(listUsersOnTask, task.getTaskID());
            Controller.fillList(listUsers, Controller.userList);
            Controller.fillTableWithTask(tableAllTasks);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void fillTableWithUser(JTable table) throws IOException, SQLException {
        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < userList.size(); i++) {
            Object[] data = {userList.get(i).getUserID(),
                userList.get(i).getUserName(),
                userList.get(i).getAccessLevel(),
                userList.get(i).getPassword()};
            modelTable.addRow(data);

        }
    }

    public static void fillTableWithType(JTable table) {
        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < typeList.size(); i++) {
            Object[] data = {typeList.get(i).getTypeID(),
                typeList.get(i).getTypeName()};
            modelTable.addRow(data);
        }
    }

    public static void fillTableWithStatus(JTable table) {
        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < statusList.size(); i++) {
            Object[] data = {statusList.get(i).getStatusID(),
                statusList.get(i).getStatussName()};
            modelTable.addRow(data);

        }
    }

    public static void fillComboBoxModelWithAllUsers(JComboBox cb) {

        int currentUserIndex = 0;

        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (int i = 0; i < userList.size(); i++) {
            dcbm.addElement(userList.get(i).getUserName());
            if (userList.get(i).getUserID() == currentUser.getUserID()) {
                currentUserIndex = i;
            }
        }
        cb.setModel(dcbm);
        cb.setSelectedIndex(currentUserIndex);
    }

    public void saveFile(String name, InputStream inputStream, int taskID) throws IOException, SQLException {
        dbHandler.saveFile(name, inputStream, taskID);
    }

    public static void removeTableHeadersTask(JTable table) {
        TableColumn column = table.getColumnModel().getColumn(0);
        table.removeColumn(column);

        column = table.getColumnModel().getColumn(0);
        table.removeColumn(column);
    }

    public static void removeTableHeadersCustomer(JTable table) {
        TableColumn column = table.getColumnModel().getColumn(0);
        table.removeColumn(column);
    }

    public static ArrayList<Task> updateTableWithNewTasks(JTable tableAllTask) throws IOException, SQLException {
        Connection conn = (Connection) dbHandler.initiateSystemDBConn()[0];
        tasks = dbHandler.initiateTaskList(conn);

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

    public static void clearAll(JTextField taskName, JComboBox type, JComboBox status, JTextField customer, JComboBox taskManager,
            JDateChooser expStart, JDateChooser expEnd, JTextField expTimeUsed, JComboBox priority, JList Listuser, JList ListUsersOnTask) {

        DefaultListModel model = (DefaultListModel) Listuser.getModel();
        DefaultListModel modelOnTask = (DefaultListModel) ListUsersOnTask.getModel();

        taskName.setText("");
        type.setSelectedIndex(0);
        status.setSelectedIndex(0);
        customer.setText("");
        taskManager.setSelectedIndex(0);
        expStart.setDate(Controller.getCurrentDate());
        expEnd.setDate(Controller.getCurrentDate());
        expTimeUsed.setText("");
        priority.setSelectedIndex(0);

        model.clear();
        modelOnTask.clear();
        try {
            Controller.fillList(Listuser, Controller.userList);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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

    public static ArrayList<Task> getAllChildrenById(int Id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getParentID() == Id && tasks.get(i).getTaskID() != Id) {
                children.add(tasks.get(i));
                getAllChildrenById(tasks.get(i).getTaskID());
            }
        }
        return children;
    }

    public static int getSelectedTaskId(JTable mainTaskTable) {
        children.clear();
        DefaultTableModel modelTable = (DefaultTableModel) mainTaskTable.getModel();
        int taskID = Integer.parseInt(modelTable.getValueAt(mainTaskTable.convertRowIndexToModel(mainTaskTable.getSelectedRow()), 0).toString());
        return taskID;
    }

    public static int getCustomerID() {
        return customerID;
    }

    public static void setCustomerID(int customerID) {
        Controller.customerID = customerID;
    }

    public static String getCustomerIDToString() {
        return customerID + "";
    }

//    public static void openCustomerLookUpFrame() {
//        frame.setVisible(true);
//    }
    public static Task getSelectedTask(int ID) {
        Task task = null;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskID() == ID) {
                task = tasks.get(i);
            }
        }
        return task;
    }

    public static TimeSpentOnTask getTimeSpentOnTaskFromList(int taskID, String userID) {
        TimeSpentOnTask tsot = null;
        User user = null;
        for (int i = 0; i < Controller.userList.size(); i++) {
            if (Controller.userList.get(i).getUserName().equals(userID)) {
                user = Controller.userList.get(i);
            }
        }
        for (int i = 0; i < tsotList.size(); i++) {
            if (tsotList.get(i).getTaskID() == taskID && user.getUserName().equals(userID)) {
                tsot = tsotList.get(i);
            }
        }
        return tsot;
    }

    public static void fillHomeComponets(int taskID, String userID, JTextArea textAreaComment, JComboBox comboboxStatus, JTextField textFieldTimeSpent) {

        TimeSpentOnTask tsot = getTimeSpentOnTaskFromList(taskID, userID);
        Task t = getSelectedTask(taskID);
        textAreaComment.setText(tsot.getComment());
        comboboxStatus.setSelectedItem(t.getStatus());
        textFieldTimeSpent.setText("");
    }

    public static void updateTimeSpentOnTask(int taskID, String userName, JComboBox comboboxStatus, JTextField textfieldTimeSpent, JTextArea textAreaComment) throws SQLException, IOException {
        User user = null;
        TimeSpentOnTask tsot = null;
        Task task = getSelectedTask(taskID);

        for (int i = 0; i < Controller.userList.size(); i++) {
            if (Controller.userList.get(i).getUserName().equals(userName)) {
                user = Controller.userList.get(i);
            }
        }
        System.out.println("PRE: " + task.getStatus().getStatusID());
        task.setStatusByID(comboboxStatus.getSelectedIndex() + 1);
        System.out.println("IkkePRE: " + task.getStatus().getStatusID());
        for (int i = 0; i < tsotList.size(); i++) {
            if (tsotList.get(i).getTaskID() == taskID && user.getUserName().equals(userName)) {
                tsot = tsotList.get(i);
                int totalTimeSpent = tsot.getTimeSpent() + Integer.parseInt(textfieldTimeSpent.getText());
                tsot.setTimeSpent(totalTimeSpent);
                tsot.setComment(textAreaComment.getText());
            }
        }
        if (tsot == null) {
            tsot = new TimeSpentOnTask(taskID, user.getUserID(), Integer.parseInt(textfieldTimeSpent.getText()), textAreaComment.getText());
        }
                System.out.println("EFTER ALT: "+ task.getStatus());
        Controller.dbHandler.updateTimeSpentOnTask(tsot, task);
    }
    
    public static void createNewTimeSpentOnTask(String userName) throws SQLException, IOException{
        User user = null;
        TimeSpentOnTask tsot = null;
        
        for (int i = 0; i < Controller.userList.size(); i++) {
            if (Controller.userList.get(i).getUserName().equals(userName)) {
                user = Controller.userList.get(i);
            }
        }
        
        tsot = new TimeSpentOnTask(user.getUserID());
        Controller.dbHandler.createTimeSpentOnTask(tsot);
        
    }
}
