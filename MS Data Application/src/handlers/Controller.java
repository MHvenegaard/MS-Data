package handlers;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.*;
import view.CreateTaskPanel;
import view.CustomerLookUpFrame;
import view.Home;
import view.Mainframe;
import view.TaskHandlingPanel;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class Controller {

    public static User currentUser;
    public static DBHandler dbHandler;
    public static FileDBHandler fileDBHandler;
    public static ArrayList<User> userList;
    public static ArrayList<Type> typeList;
    public static ArrayList<Statuss> statusList;
    public static ArrayList<Task> tasks;
    public static ArrayList<Task> children;
    public static ArrayList<Customer> customerList;
    public static ArrayList<TimeSpentOnTask> tsotList;
    // Belongs to the CustomerLookUpFrame
    public static int customerID;
    public static JFrame frame;

    /**
     * The FileDBHandler class Constructor. The Constructor loads the JDBC
     * Driver
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public Controller() throws ClassNotFoundException, SQLException, IOException {
        currentUser = null;
        dbHandler = new DBHandler();
        fileDBHandler = new FileDBHandler();
        tsotList = new ArrayList();
        userList = new ArrayList();
        typeList = new ArrayList();
        statusList = new ArrayList();
        customerList = new ArrayList();
        tasks = new ArrayList();
        customerID = -1;

    }

    /**
     * Initiates the controllers variables with relevant data from the database.
     * WARNING: This method may only be used from the LoginFrame intialization
     * proces.
     *
     * @throws SQLException The queried data could not be retrieved from the
     * database
     * @throws IOException A connection to the server could not be established
     */
    public void initiateController() throws SQLException, IOException {
        Connection conn = (Connection) dbHandler.initiateSystemDBConn()[0];

        userList = dbHandler.initiateUserList(conn);
        typeList = dbHandler.initiateTypeList(conn);
        statusList = dbHandler.initiateStatusList(conn);
        customerList = dbHandler.initiateCustomerList(conn);
        tasks = dbHandler.initiateTaskList(conn);
        tsotList = dbHandler.initiateTimeSpentOnTaskList(conn);
        frame = new CustomerLookUpFrame(this);
        children = new ArrayList<>();
        setUsersOnTask();

    }

    /**
     * Updates the data in the controllers lists by retrieving all data from the
     * database.
     *
     * @throws SQLException The queried data could not be retrieved from the
     * database
     * @throws IOException A connection to the server could not be established
     */
    public void updateControllerData() throws SQLException, IOException {
        initiateController();
    }

    /**
     * Retrieves the user from the list containing all users, identified by
     * their username.
     *
     * @param userName The combobox from which the username is extracted and
     * used to locate the user object.
     * @return user - The User object containing the name parameter.
     */
    private User getUserByUserName(JComboBox userName) {
        User user = null;
        for (int i = 0; i < Controller.userList.size(); i++) {
            if (Controller.userList.get(i).getUserName().equals(userName.getSelectedItem().toString())) {
                user = Controller.userList.get(i);
            }
        }
        return user;
    }

    /**
     * Runs through all tasks in the controllers taskList and add's user to a
     * task through the TimeSpentOnTask reference. This proces is completed
     * using the controllers locally stored lists. Upon use of this method, make
     * sure all lists have been updated.
     *
     * @see #updateControllerData()
     *
     */
    public void setUsersOnTask() {
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

    /**
     * Sets the selected item on the combobox based on the user using the
     * system.
     *
     * @see #currentUser
     * @param comboboxUser
     */
    public void setComboboxCurrentUser(JComboBox comboboxUser) {

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserID() == currentUser.getUserID()) {
                currentUser = userList.get(i);
            }
        }
        comboboxUser.setSelectedItem(currentUser);
    }

    /**
     * Locks all the components from being edited, in the taskhandling panel.
     *
     * @param textFieldTaskName
     * @param textAreaDescription
     * @param textFieldCustomer
     * @param textFieldTime
     * @param comboBoxPriority
     * @param comboBoxProjectLeader
     * @param comboBoxStatus
     * @param comboBoxType
     * @param dateChooserStart
     * @param dateChooserEnd
     * @param buttonFindCustomer
     * @param buttonGetCustomerID
     * @param buttonAddUserToList
     * @param buttonRemoveUserFromList
     * @param buttonSaveChangesToTask
     */
    public void lockAllComponetsInTaskHandling(JTextField textFieldTaskName, JTextArea textAreaDescription, JTextField textFieldCustomer, JTextField textFieldTime, JComboBox comboBoxPriority, JComboBox comboBoxProjectLeader, JComboBox comboBoxStatus, JComboBox comboBoxType, JDateChooser dateChooserStart, JDateChooser dateChooserEnd, JButton buttonFindCustomer, JButton buttonGetCustomerID, JButton buttonAddUserToList, JButton buttonRemoveUserFromList, JButton buttonSaveChangesToTask) {
        textFieldTaskName.setEnabled(false);
        textAreaDescription.setEnabled(false);
        textFieldCustomer.setEnabled(false);
        textFieldTime.setEnabled(false);
        comboBoxPriority.setEnabled(false);
        comboBoxProjectLeader.setEnabled(false);
        comboBoxStatus.setEnabled(false);
        comboBoxType.setEnabled(false);
        dateChooserEnd.setEnabled(false);
        dateChooserStart.setEnabled(false);
        buttonAddUserToList.setEnabled(false);
        buttonFindCustomer.setEnabled(false);
        buttonGetCustomerID.setEnabled(false);
        buttonRemoveUserFromList.setEnabled(false);
        buttonSaveChangesToTask.setEnabled(false);

    }

    /**
     * Unlocks all the components in the taskhandling panel, renabling editing.
     *
     * @param textFieldTaskName
     * @param textAreaDescription
     * @param textFieldCustomer
     * @param textFieldTime
     * @param comboBoxPriority
     * @param comboBoxProjectLeader
     * @param comboBoxStatus
     * @param comboBoxType
     * @param dateChooserExpectedStart
     * @param dateChooserExpectedEnd
     * @param buttonFindCustomer
     * @param buttonGetCustomerID
     * @param buttonAddUser
     * @param buttonRemoveUser
     * @param buttonSaveChanges
     */
    public void unlockAllComponetsInTaskHandling(JTextField textFieldTaskName, JTextArea textAreaDescription, JTextField textFieldCustomer, JTextField textFieldTime, JComboBox comboBoxPriority, JComboBox comboBoxProjectLeader, JComboBox comboBoxStatus, JComboBox comboBoxType, JDateChooser dateChooserExpectedStart, JDateChooser dateChooserExpectedEnd, JButton buttonFindCustomer, JButton buttonGetCustomerID, JButton buttonAddUser, JButton buttonRemoveUser, JButton buttonSaveChanges) {
        textAreaDescription.setEnabled(true);
        textFieldCustomer.setEnabled(true);
        textFieldTaskName.setEnabled(true);
        textFieldTime.setEnabled(true);
        comboBoxPriority.setEnabled(true);
        comboBoxProjectLeader.setEnabled(true);
        comboBoxStatus.setEnabled(true);
        comboBoxType.setEnabled(true);
        dateChooserExpectedEnd.setEnabled(true);
        dateChooserExpectedStart.setEnabled(true);
        buttonAddUser.setEnabled(true);
        buttonFindCustomer.setEnabled(true);
        buttonGetCustomerID.setEnabled(true);
        buttonRemoveUser.setEnabled(true);
        buttonSaveChanges.setEnabled(true);
    }

    /**
     *
     * @param combobox The combobox to be filled with objects.
     * @param arrayList The arraylists containing the objects used to fill the
     * combobox.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void fillCombobox(JComboBox combobox, ArrayList arrayList) throws SQLException, IOException {
        for (int i = 0; i < arrayList.size(); i++) {
            combobox.addItem(arrayList.get(i));
        }
    }

    /**
     *
     * @param list The list to be filled with objects.
     * @param arrayList The arraylists containing the objects used to fill the
     * list
     * @throws SQLException The queried data could not be retrieved from the
     * database
     * @throws IOException A connection to the server could not be established
     */
    public void fillList(JList list, ArrayList arrayList) throws SQLException, IOException {
        DefaultListModel model = new DefaultListModel();
        list.setModel(model);
        model.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            model.addElement(arrayList.get(i));
        }
    }

    //Fills JList.UserOnTaskList and removes ppl from JList.UserList
    /**
     *
     * @param uList The complete list of users who are not associated with the
     * task.
     * @param userOnTaskLlist The list of users currently associated with the
     * task
     * @param userOnTask The list containing the users associated with the
     * selected task.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void fillAndRemoveFromUserLists(JList uList, JList userOnTaskLlist, ArrayList<User> userOnTask) throws SQLException, IOException {

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

    /**
     * Returns the current date formatted as DD/MM/YYYY.
     *
     * @return date - The Date object containing the formated date.
     */
    public Date getCurrentDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String str = sdf.format(date);
        date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
        return date;

    }

    /**
     * Formats the tables model and fills it with all tasks from the controllers
     * task list.
     *
     * @see #tasks
     * @param tableAllTask The Table to be formatted and filled with data
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void fillTableUsingTaskList(JTable tableAllTask) throws IOException, SQLException {
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
    }

    /**
     * Formats the tables model and fills it with all objects from the list send
     * along.
     *
     * @param tableAllTask The table to be formated
     * @param fillList The list containing the objects used to fill the table
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void fillTableWithList(JTable tableAllTask, ArrayList<Task> fillList) throws IOException, SQLException {

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

    /**
     * Formats the table using the controllers customer list.
     *
     * @param tableAllTask The table to be formated and filled with data.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void fillTableWithCustomer(JTable tableAllTask) throws IOException, SQLException {
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTask.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < customerList.size(); i++) {
            Object[] data = {customerList.get(i).getCustomerID(),
                customerList.get(i).getCompanyName(),
                customerList.get(i).getPhone(),
                customerList.get(i).getCVR()};
            modelTable.addRow(data);
        }
    }

    /**
     * Removes users from the first list, and adds them to the second list.
     *
     * @param listUsers The list from which users will be removed.
     * @param listUsersOnTask The list to which users will be added.
     */
    public void addUserToOnTaskList(JList listUsers, JList listUsersOnTask) {
        int index = listUsers.getSelectedIndex();

        DefaultListModel model = (DefaultListModel) listUsers.getModel();
        DefaultListModel modelOnTask = (DefaultListModel) listUsersOnTask.getModel();

        if (index != -1) {
            modelOnTask.addElement(listUsers.getSelectedValue());
            model.removeElement(listUsers.getSelectedValue());
        } else {
            JOptionPane.showMessageDialog(listUsers, "Der ikke valgt nogen medarbejder", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Removes the targeted user from the list with all users and add's the user
     * to the list with users on task
     *
     * @param listUsers The JList of users
     * @param listUsersOnTask The JList of users on task
     * @param button
     */
    public void removeUserFromTaskList(JList listUsers, JList listUsersOnTask) {
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
            JOptionPane.showMessageDialog(null, "Der ikke valgt nogen medarbejder", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Creates a new quick task
     *
     * @param taskID The task ID
     * @param userList The JList that contains a list of users
     * @param userOnTaskLlist The JList that contains the list of users on the
     * task
     * @param textFieldTaskName The JTextField that contains the task name
     * @param comboBoxType The JComboBox that contains the type
     * @param comboBoxStatus The JComboBox that contains the status
     * @param comboBoxCustomer The JComboBox that contains the customer
     * @param comboBoxTaskLeader The JComboBox that contains the task leader
     * @param textAreaDescription The JTextArea that contains the description
     * @param textFieldTime The JTextField that contains the time spent on the
     * task
     * @param comboBoxPriority The JComboBox that contains the priority
     * @param dateChooserExpectedStart The JDateChooser that contains the
     * expected start
     * @param dateChooserExpectedEnd The JDateChooser that contains the expected
     * end
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     *
     *
     */
    public void fillComponents(int taskID, JList userList, JList userOnTaskLlist, JTextField textFieldTaskName, JComboBox comboBoxType, JComboBox comboBoxStatus,
            JTextField comboBoxCustomer, JComboBox comboBoxTaskLeader, JDateChooser dateChooserExpectedStart, JDateChooser dateChooserExpectedEnd,
            JTextField textFieldTime, JComboBox comboBoxPriority, JTextArea textAreaDescription) throws SQLException, IOException {

        Task t = getSelectedTask(taskID);

        textFieldTaskName.setText(t.getTaskName());
        comboBoxType.setSelectedItem(t.getType());
        comboBoxStatus.setSelectedItem(t.getStatus());
        comboBoxCustomer.setText(t.getCustomer().getCustomerID() + "");
        comboBoxTaskLeader.setSelectedIndex((t.getUser().getUserID()) - 1);
        textFieldTime.setText(t.getEstimatedtime() + "");
        comboBoxPriority.setSelectedItem(t.getPriority());
        textAreaDescription.setText(t.getDescription());
        dateChooserExpectedStart.setDate(t.getStartDate());
        dateChooserExpectedEnd.setDate(t.getEndDate());

        fillAndRemoveFromUserLists(userList, userOnTaskLlist, t.getUserOnTask());
    }

    /**
     * Creates a new quick task
     *
     * @param comboBoxType The JComboBox that contains type
     * @param textFieldCustomer The JTextField that contains the customer
     * @param comboBoxTaskLeader The JComboBox that contains the task leader
     * @param textFieldtimeSpent The JTextField that contains the time spent on
     * the task
     * @param textAreaDescription The JTextArea that contains the description
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     * @throws ParseException Can not parse the String to Integer
     *
     *
     */
    public void createQuickTask(JTextField textFieldCustomer, JComboBox comboBoxType, JComboBox comboBoxTaskLeader, JTextField textFieldtimeSpent, JTextArea textAreaDescription) throws SQLException, IOException, ParseException {
        Customer customer = null;
        Type type = null;
        Statuss status = null;
        User user = null;

        if (textFieldCustomer.getText().isEmpty() || textFieldtimeSpent.getText().isEmpty() || textAreaDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Der skal angives en kunde, brugt tid samt en kommentar", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        } else {
            String comment = textAreaDescription.getText();
            int timeSpent = Integer.parseInt(textFieldtimeSpent.getText());

            for (int i = 0; i < Controller.customerList.size(); i++) {
                if (Controller.customerList.get(i).getCustomerID() == Integer.parseInt(textFieldCustomer.getText())) {
                    customer = Controller.customerList.get(i);
                }
            }

            for (int i = 0; i < Controller.typeList.size(); i++) {
                if (Controller.typeList.get(i).getTypeName().equals(comboBoxType.getSelectedItem().toString())) {
                    type = Controller.typeList.get(i);
                }
            }

            status = Controller.statusList.get(3);

            user = getUserByUserName(comboBoxTaskLeader);

            Task task = new Task(
                    type.getTypeName(),
                    type,
                    status,
                    customer,
                    user,
                    getCurrentDate(),
                    getCurrentDate(),
                    0,
                    1,
                    "");

            dbHandler.createQuickTask(task);
            createNewTimeSpentOnQuickTask(comboBoxTaskLeader, timeSpent, comment);
        }
    }

    /**
     * Creates a new task
     *
     * @param tableAllTask The table with tasks
     * @param checkBoxSub The JCheckBox that marks if it is task or part task
     * @param listUsersOnTask The JList that contains all users on the task
     * @param textFieldTaskName The JTextField that contains the task name
     * @param comboBoxType The JComboBox that contains type
     * @param comboBoxStatus The JComboBox that contains status
     * @param textFieldCustomer The JTextField that contains the customer
     * @param comboBoxTaskLeader The JComboBox that contains the task leader
     * @param dateChooserExpectedStart The JDateChooser that contains the start
     * date
     * @param dateChooserExpectedEnd The JDateChooser that contains the end date
     * @param textFieldEstimatedTime The JTextField that contains the estimated
     * time
     * @param comboBoxPriority The JComboBox that contains the priority
     * @param textAreaDescription The JTextArea that contains the description
     * @throws ParseException The data could not be parsed to wanted type
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     *
     *
     */
    public void createNewTask(JTable tableAllTask, JList listUsersOnTask, JCheckBox checkBoxSub, JTextField textFieldTaskName, JComboBox comboBoxType, JComboBox comboBoxStatus,
            JTextField textFieldCustomer, JComboBox comboBoxTaskLeader, JDateChooser dateChooserExpectedStart, JDateChooser dateChooserExpectedEnd,
            JTextField textFieldEstimatedTime, JComboBox comboBoxPriority, JTextArea textAreaDescription) throws ParseException, SQLException, IOException {

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

        if (taskName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Der er opstået en fejl ! Er alle felter med stjerne udfyldt? Og er den valgte slut dato efter start dato?", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        } else if (checkBoxSub.isSelected()) {
            Date ParentStartDate = sdf.parse(modelTable.getValueAt(tableAllTask.getSelectedRow(), 7).toString());
            Date ParentEndDate = sdf.parse(modelTable.getValueAt(tableAllTask.getSelectedRow(), 8).toString());
            Boolean taskChecker = subTaskDateChecker(taskStartDate, taskEndDate, ParentStartDate, ParentEndDate);

            if (tableAllTask.getSelectedRow() != -1 && taskChecker) {
                taskID = Integer.parseInt(modelTable.getValueAt(tableAllTask.getSelectedRow(), 0).toString());

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

                dbHandler.createSubTask(task);
                dbHandler.addUserToTask(listUsersOnTask);

            } else {
                JOptionPane.showMessageDialog(null, "Der ikke valgt nogen opgave at lav delopgave til eller den valgte dato ikke er inde for opgaven", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
            }
        } else if (!checkBoxSub.isSelected()) {

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
            Controller.dbHandler.createTask(task);
            createNewTimeSpentOnTaskWithUserOnTaskList(listUsersOnTask);
           // Controller.dbHandler.addUserToTask(listUsersOnTask);
        }

    }

    /**
     * Changes the textfields text to the current users username and ID.
     *
     * @param textFieldUser The textfield which text is to be edited.
     */
    public void setCurrentUserIDToTextField(JTextField textFieldUser) {
        textFieldUser.setText(currentUser.getUserName() + "");
    }

    /**
     * Checks wether the subtasks start- and end date is valid. The date is
     * rendered valid if the start and end date is within the parent task's
     * start and enddate.
     *
     * @param supTaskStartDate The startdate parameter of the subtask
     * @param supTaskEndDate The enddate parameter of the subtask
     * @param parentStartDate The startdate of the parent task
     * @param parentEndDate The enddate of the parent task
     * @return result - The result indicates wether the subtask dates are valid
     * or not. True means the dates are valid, false means they are invalid.
     */
    public Boolean subTaskDateChecker(Date supTaskStartDate, Date supTaskEndDate, Date parentStartDate, Date parentEndDate) {
        Boolean result = true;
        if (supTaskStartDate.before(parentStartDate)
                || supTaskStartDate.after(parentEndDate)
                || supTaskStartDate.after(supTaskEndDate)
                || supTaskEndDate.after(parentEndDate)) {
            result = false;
        }
        return result;
    }

    /**
     * Saves changes to the given ask
     *
     * @param tableAllTasks The table with tasks
     * @param listUsers The JList that refills
     * @param listUsersOnTask The JList that contains all users on the task
     * @param textFieldTaskName The JTextField that contains the task name
     * @param comboBoxType The JComboBox that contains type
     * @param comboBoxStatus The JComboBox that contains status
     * @param textFieldCustomer The JTextField that contains the customer
     * @param comboBoxTaskLeader The JComboBox that contains the task leader
     * @param dateChooserExpectedStart The JDateChooser that contains the start
     * date
     * @param dateChooserExpectedEnd The JDateChooser that contains the end date
     * @param textFieldEstimatedTime The JTextField that contains the estimated
     * time
     * @param comboBoxPriority The JComboBox that contains the priority
     * @param textAreaDescription The JTextArea that contains the description
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     *
     *
     */
    public void SaveChangesToTask(JTable tableAllTasks, JList listUsers, JList listUsersOnTask, JTextField textFieldTaskName,
            JComboBox comboBoxType, JComboBox comboBoxStatus, JTextField textFieldCustomer, JComboBox comboBoxTaskLeader, JDateChooser dateChooserExpectedStart,
            JDateChooser dateChooserExpectedEnd, JTextField textFieldEstimatedTime, JComboBox comboBoxPriority, JTextArea textAreaDescription) throws SQLException, IOException {
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTasks.getModel();
        DefaultListModel modelOnTask = (DefaultListModel) listUsersOnTask.getModel();
        Type type = null;
        Statuss status = null;
        Customer customer = null;
        User user = null;

        if (textFieldTaskName.getText() == "" || textFieldCustomer.getText() == "" || textFieldEstimatedTime.getText() == "") {
            JOptionPane.showMessageDialog(null, "Der skal angives et opgave navn, kunde og en estimering af tid der skal bruges", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        } else {
            ArrayList<User> userOnTask = new ArrayList<>();

            user = getUserByUserName(comboBoxTaskLeader);

            for (int i = 0; i < Controller.statusList.size(); i++) {
                if (Controller.statusList.get(i).getStatussName().equals(comboBoxStatus.getSelectedItem().toString())) {
                    status = Controller.statusList.get(i);
                }
            }

            for (int i = 0; i < Controller.customerList.size(); i++) {
                if (Controller.customerList.get(i).getCustomerID() == Integer.parseInt(textFieldCustomer.getText())) {
                    customer = Controller.customerList.get(i);
                }
            }

            for (int i = 0; i < Controller.typeList.size(); i++) {
                if (Controller.typeList.get(i).getTypeName().equals(comboBoxType.getSelectedItem().toString())) {
                    type = Controller.typeList.get(i);
                }
            }

            for (int i = 0; i < modelOnTask.getSize(); i++) {
                userOnTask.add((User) modelOnTask.getElementAt(i));
            }

            //Create new task object
            Task task = new Task(Integer.parseInt(modelTable.getValueAt(tableAllTasks.convertRowIndexToModel(tableAllTasks.getSelectedRow()), 0).toString()),
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

            Controller.dbHandler.updateTask(task);
            // Controller.dbHandler.addUserToAlreadyMadeTask(listUsersOnTask, task.getTaskID());
            fillList(listUsers, Controller.userList);
            fillTableUsingTaskList(tableAllTasks);
        }
    }

    /**
     * Fills the table with all users based on the Controller stored userList.
     *
     * @param table The table to be formated and filled with data.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     * @see #userList
     */
    public void fillTableWithUser(JTable table) throws IOException, SQLException {
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

    /**
     * Fills the table with all types based on the Controller stored typelist.
     *
     * @param table The table to be formated and filled with data.
     * @see #typeList
     */
    public void fillTableWithType(JTable table) {
        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < typeList.size(); i++) {
            Object[] data = {typeList.get(i).getTypeID(),
                typeList.get(i).getTypeName()};
            modelTable.addRow(data);
        }
    }

    /**
     * Fills the table with all Status possibilities based on the Controller
     * stored statuslist.
     *
     * @param table The table to be formated and filled with data.
     * @see #statusList
     */
    public void fillTableWithStatus(JTable table) {
        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < statusList.size(); i++) {
            Object[] data = {statusList.get(i).getStatusID(),
                statusList.get(i).getStatussName()};
            modelTable.addRow(data);

        }
    }

    /**
     * Fills the combobox with all users based on the controller stored
     * userlist.
     *
     * @param cb The Combobox to be filled with all users.
     * @see #userList
     */
    public void fillComboBoxModelWithAllUsers(JComboBox cb) {

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

    /**
     * Saves a file to the database.
     *
     * @param name The name of the file to be stored.
     * @param inputStream The inputStream containing the file.
     * @param taskID The ID of the task the file is attached to.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void saveFile(String name, InputStream inputStream, int taskID) throws IOException, SQLException {
        fileDBHandler.saveFile(name, inputStream, taskID);
    }

    /**
     * Removes the task headers from the table.
     *
     * @param table The table to have its headers removed.
     */
    public void removeTableHeadersTask(JTable table) {
        TableColumn column = table.getColumnModel().getColumn(0);
        table.removeColumn(column);

        column = table.getColumnModel().getColumn(0);
        table.removeColumn(column);
    }

    /**
     * Removes the customer headers from the table.
     *
     * @param table The table to have its headers removed.
     */
    public void removeTableHeadersCustomer(JTable table) {
        TableColumn column = table.getColumnModel().getColumn(0);
        table.removeColumn(column);
    }

    /**
     * Retrieves all tasks from the database and places them in the table.
     *
     * @param tableAllTask The table to be formated with the task data.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void updateTableWithNewTasks(JTable tableAllTask) throws IOException, SQLException {
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
    }

    /**
     * Clears all currently stored data in the components
     *
     * @param taskName
     * @param type
     * @param status
     * @param customer
     * @param taskManager
     * @param expStart
     * @param expEnd
     * @param expTimeUsed
     * @param priority
     * @param Listuser
     * @param ListUsersOnTask
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void clearAll(JTextField taskName, JComboBox type, JComboBox status, JTextField customer, JComboBox taskManager,
            JDateChooser expStart, JDateChooser expEnd, JTextField expTimeUsed, JComboBox priority, JList Listuser, JList ListUsersOnTask) throws SQLException, IOException, ParseException {

        DefaultListModel model = (DefaultListModel) Listuser.getModel();
        DefaultListModel modelOnTask = (DefaultListModel) ListUsersOnTask.getModel();

        taskName.setText("");
        type.setSelectedIndex(0);
        status.setSelectedIndex(0);
        customer.setText("");
        taskManager.setSelectedIndex(0);
        expStart.setDate(getCurrentDate());
        expEnd.setDate(getCurrentDate());
        expTimeUsed.setText("");
        priority.setSelectedIndex(0);

        model.clear();
        modelOnTask.clear();

        fillList(Listuser, userList);

    }

    /**
     * Sets the user based on the login credentials
     *
     * @param user The user to be stored as the current user.
     * @see #currentUser
     */
    public void setUser(User user) {
        currentUser = user;
    }

    /**
     * Returns the current user.
     *
     * @return currentUser The current user based on who logged in.
     * @see #currentUser
     */
    public User getUser() {
        return currentUser;
    }

    /**
     * Returns the DB Handler object stored by the Controller.
     *
     * @return The DBHandler object.
     * @see #dbHandler
     */
    public DBHandler getDBHandler() {
        return dbHandler;
    }

    /**
     * Iterates through each tasks subtasks using recursion. Each subtask to the
     * parent task is added to the children list. Each subtask og a parent
     * subtask is also added, and so forth.
     *
     * @param Id The ID of the parent task.
     * @return children - An ArrayList containing all tasks that are a child of
     * the parent or a child to a subtask of a parent.
     */
    public ArrayList<Task> getAllChildrenById(int Id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getParentID() == Id && tasks.get(i).getTaskID() != Id) {
                children.add(tasks.get(i));
                getAllChildrenById(tasks.get(i).getTaskID());
            }
        }
        return children;
    }

    /**
     * Get the ID of the task selected on the table.
     *
     * @param mainTaskTable The table from which the selected taskID is to be
     * retrieved from.
     * @return taskID - The ID of the selected task.
     */
    public int getSelectedTaskId(JTable mainTaskTable) {
        children.clear();
        DefaultTableModel modelTable = (DefaultTableModel) mainTaskTable.getModel();
        int taskID = Integer.parseInt(modelTable.getValueAt(mainTaskTable.convertRowIndexToModel(mainTaskTable.getSelectedRow()), 0).toString());
        return taskID;
    }

    /**
     * Retrieves the customerID selected using the CustomerLookUpFrame.
     *
     * @return CustomerID
     * @see #customerID
     * @see CustomerLookUpFrame
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Sets the customerID using the CustomerLookupFrame.
     *
     * @param table The table used for choosing the customerID
     * @see #customerID
     * @see CustomerLookUpFrame
     */
    public void setCustomerID(JTable table) {
        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();

        if (table.getSelectedRowCount() != 0) {
            customerID = Integer.parseInt(modelTable.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 0).toString());
            frame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(frame, "Der skal vælges en kunde", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Opens the CustomerLookUpFrame from which a customer can be selected. The
     * CustomerLookUpFrame allows the user to search through all customers using
     * several different search criteria.
     *
     * @see CustomerLookUpFrame
     */
    public void openCustomerLookUpFrame() {
        frame.setVisible(true);
    }

    /**
     * Returns the customerID stored in the Controller as a String
     *
     * @return customerID - The CustomerID converted to a String
     * @see #customerID
     */
    public String getCustomerIDToString() {
        return customerID + "";
    }

    /**
     * Returns the selected task based on taskID. The taskID is used to search
     * through the Controller stored tasks list.
     *
     * @param ID The ID from which the task is identified.
     * @return task - Returns a Task object if the task if found in the list. If
     * the taskID didnt result in a match, null is returned.
     * @see #tasks
     */
    public Task getSelectedTask(int ID) {
        Task task = null;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskID() == ID) {
                task = tasks.get(i);
            }
        }
        return task;
    }

    /**
     * Retrieves the TimeSpentOnTask object connecting the specified user to the
     * specified task.
     *
     * @param taskID The ID of the task object.
     * @param userID The ID of the user associated with the task.
     * @return tsot - TimeSpentOnTask object connecting the user to the task.
     */
    public TimeSpentOnTask getTimeSpentOnTaskFromList(int taskID, String userID) {
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

    /**
     * Fills the components on the homepage, based on the taskID and userID.
     *
     * @param taskID
     * @param userID
     * @param textAreaComment
     * @param comboboxStatus
     * @param textFieldTimeSpent
     */
    public void fillHomeComponents(int taskID, String userID, JTextArea textAreaComment, JComboBox comboboxStatus, JTextField textFieldTimeSpent) {
        TimeSpentOnTask tsot = getTimeSpentOnTaskFromList(taskID, userID);
        Task t = getSelectedTask(taskID);
        textAreaComment.setText(tsot.getComment());
        comboboxStatus.setSelectedItem(t.getStatus());
    }

    /**
     * Updates the TimeSpentOnTask object between a user and a task.
     *
     * @param table The table from which a task has been chosen.
     * @param userName The userName of the user.
     * @param comboboxStatus The combobox from which a status has been chosen.
     * @param textfieldTimeSpent The textfield into which the user has entered
     * total time spent.
     * @param textAreaComment The textarea where the user can attach a comment
     * to the TimeSpentOnTask object.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void updateTimeSpentOnTask(JTable table, JComboBox userName, JComboBox comboboxStatus, JTextField textfieldTimeSpent, JTextArea textAreaComment) throws SQLException, IOException {
        DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
        User user = null;
        TimeSpentOnTask tsot = null;

        if (textfieldTimeSpent.getText().isEmpty() || textAreaComment.getText().isEmpty() || table.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Der skal angives hvilken opgave der skal indrapportes samt tid brugt og en kommentar", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        } else {
            int taskID = Integer.parseInt(tablemodel.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 0).toString());
            Task task = getSelectedTask(taskID);

            user = getUserByUserName(userName);
            task.setStatusByID(comboboxStatus.getSelectedIndex() + 1);

            for (int i = 0; i < tsotList.size(); i++) {
                if (tsotList.get(i).getTaskID() == taskID && user.getUserName().equals(userName.getSelectedItem().toString())) {
                    tsot = tsotList.get(i);
                    int totalTimeSpent = tsot.getTimeSpent();
                    System.out.println("Før tid sammenlægning: " + totalTimeSpent);
                    totalTimeSpent = totalTimeSpent + Integer.parseInt(textfieldTimeSpent.getText());
                    System.out.println("EFTER : " + totalTimeSpent);
                    tsot.setTimeSpent(totalTimeSpent);
                    tsot.setComment(textAreaComment.getText());
                }
            }
            if (tsot == null) {
                tsot = new TimeSpentOnTask(taskID, user.getUserID(), Integer.parseInt(textfieldTimeSpent.getText()), textAreaComment.getText());
            }
            dbHandler.updateTimeSpentOnTask(tsot, task);
        }
    }

    /**
     * Creates a new TimeSpentOnTask object, based on the user
     *
     * @param userName
     * @throws SQLException
     * @throws IOException
     */
    public void createNewTimeSpentOnTask(JComboBox userName) throws SQLException, IOException {
        User user = null;
        TimeSpentOnTask tsot = null;

        user = getUserByUserName(userName);

        tsot = new TimeSpentOnTask(user.getUserID());
        dbHandler.createTimeSpentOnTask(tsot);
    }

    /**
     * Creates a new TimeSpentOnTask object, based on the user
     *
     * @param userOnTaskList
     * @throws SQLException
     * @throws IOException
     */
    public void createNewTimeSpentOnTaskWithUserOnTaskList(JList userOnTaskList) throws SQLException, IOException {
        DefaultListModel model = (DefaultListModel) userOnTaskList.getModel();
        User user = null;
        
        TimeSpentOnTask tsot = null;
        System.out.println("modelSize"+ model.size());
        for (int i = 0; i < model.size(); i++) {
            
            user = (User) model.get(i);
            tsot = new TimeSpentOnTask(user.getUserID());
            dbHandler.createTimeSpentOnTask(tsot);
            System.out.println("opret timeSpentOnTask");
        }

       // user = getUserByUserName(userName);

        
    }
    
    /**
     * Creates a new TimeSpentOnTask object based on a quick task. A quick task
     * is a task created with status finished as soon as it is created.
     *
     * @param userName
     * @param timeSpent
     * @param comment
     * @throws SQLException
     * @throws IOException
     */
    public void createNewTimeSpentOnQuickTask(JComboBox userName, int timeSpent, String comment) throws SQLException, IOException {
        User user = null;
        TimeSpentOnTask tsot = null;

        user = getUserByUserName(userName);
        tsot = new TimeSpentOnTask(user.getUserID(), timeSpent, comment);
        dbHandler.createTimeSpentOnTask(tsot);
    }

    /**
     * Clears the components
     *
     * @param textFieldTimeSpent
     * @param textAreaComment
     * @param textFieldQuickTaskCustomer
     * @param textFieldQuickTaskTimeSpent
     * @param textAreaQuickTaskComment
     */
    public void clearHomeComponents(JTextField textFieldTimeSpent, JTextArea textAreaComment, JTextField textFieldQuickTaskCustomer, JTextField textFieldQuickTaskTimeSpent, JTextArea textAreaQuickTaskComment) {

        textAreaComment.setText("");
        textAreaQuickTaskComment.setText("");
        textFieldQuickTaskCustomer.setText("");
        textFieldQuickTaskTimeSpent.setText("");
        textFieldTimeSpent.setText("");

    }

     /**
     * NÅR DER SKAL GØRES BRUG AF APPLYROWFILTER: table sættes til den ønsket
     * tablet der skal filteres. field sættes til textFieldet hvor teksten der
     * skal filteres efter skrives. VIGTIGT - Det er vigtigt at itemsne i
     * comboboxen står i samme rækkefølge som i tabellen dvs. Hvis tabellen
     * indeholder ID, Navn, Efternavn skal comboxens items have samme
     * rækkefølge!
     * **************************************************************************
     * applyRowFilter henter tabel data ud Opretter derefter en sorter med
     * tabelmodellen Sættes på den kaldte table og laver et RowFilter som bruges
     * til at sorter udfra hvad der står i textField og hvilket index der er
     * valgt i combox
     */
    /**
     * Filters the table to show only task with inserted field and filters tasks with
     * status "Afsluttet" away
     * @param table The targeted jTable
     * @param field The jTextField where the text that is going to filtered by
     * @param combobox It is important that the items in the combobox is in the
     * same order as      in the table. If the table contains ID, Name, Surname,
     * then the comboboxs items must      be in the same order!
     */
    public void applyRowFilter(JTable table, JTextField field, int selectedIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();

        andFilters.add(RowFilter.regexFilter(field.getText(), selectedIndex));
        andFilters.add(RowFilter.notFilter(RowFilter.regexFilter("Afsluttet", 4)));

        sorter.setRowFilter(RowFilter.andFilter(andFilters));
    }

    /**
     * Filters the table to show only task with inserted String str and filters tasks with
     * status "Afsluttet" away
     * @param table The targeted jTable
     * @param str The String str is the text that is going to filtered by
     * @param int It is important that the items in the combobox is in the
     * same order as in the table. If the table contains ID, Name, Surname,
     * then the comboboxs items must be in the same order!
     */
    public void applyRowFilter(JTable table, String str, int selectedIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();

        andFilters.add(RowFilter.regexFilter(str, selectedIndex));
        andFilters.add(RowFilter.notFilter(RowFilter.regexFilter("Afsluttet", 4)));


        sorter.setRowFilter(RowFilter.andFilter(andFilters));
    }

    /**
     * Filters all tasks that have the status "Afsluttet" away
     * @param table The targeted jTable
     */
    public void removeFinshedTaskFilter(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();

        andFilters.add(RowFilter.notFilter(RowFilter.regexFilter("Afsluttet", 4)));

        sorter.setRowFilter(RowFilter.andFilter(andFilters));
     }

    
    
    /**
     * This method updates the TimeSpentOnTask list and Task list in the
     * Controller. The method retrieves all data from the database, handles the
     * data and saves the new data lists in the controller overwriting the old
     * ones. WARNING: This method is only ment to be used with the Automatic
     * Update Thread method in the mainframe!
     *
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     * @see Mainframe#
     */
    public void updateAllContents() throws SQLException, IOException {
        Connection conn = (Connection) dbHandler.initiateSystemDBConn()[0];

        ArrayList<Task> tasklisttemp = dbHandler.initiateTaskList(conn);
        ArrayList<TimeSpentOnTask> tsotListtemp = dbHandler.initiateTimeSpentOnTaskList(conn);

        for (int i = 0; i < tasklisttemp.size(); i++) {
            for (int j = 0; j < tsotListtemp.size(); j++) {
                if (tasks.get(i).getTaskID() == tsotListtemp.get(j).getTaskID()) {
                    // Run through userList to find the userObject
                    for (int k = 0; k < userList.size(); k++) {
                        if (userList.get(k).getUserID() == tsotListtemp.get(j).getUserID()) {
                            // Add user to the userlist on task
                            tasklisttemp.get(i).addToUserOnTask(userList.get(k));
                        }
                    }
                }
            }
        }

        // Overwrite current lists with new data.
        tsotList = tsotListtemp;
        tasks = tasklisttemp;
    }

    public void createGUIBasedOnAccessLevel(int accessLevel, JTabbedPane tabbedPane, Controller control) throws SQLException, IOException, ClassNotFoundException {

        // Admin
        if (accessLevel == 0) {
            tabbedPane.add("Hovedside", new Home(control));
            tabbedPane.add("Opgaveoprettelse", new CreateTaskPanel(control));
            tabbedPane.add("Opgavehåndtering", new TaskHandlingPanel(control));
        } // User
        else {
            tabbedPane.add("Hovedside", new Home(control));
            tabbedPane.add("Opgaveoprettelse", new CreateTaskPanel(control));
            tabbedPane.add("Opgavehåndtering", new TaskHandlingPanel(control));
        }

    }

    public void setTitle(JFrame frame) {

        String userName = currentUser.getUserName();
        String accessLevel;
        if (currentUser.getAccessLevel() == 0) {
            accessLevel = "Administrator";
        } else {
            accessLevel = "Bruger";
        }
        frame.setTitle(userName + " - " + accessLevel);

    }
    /*
     * The following methods have not yet been fully developed.
     * They are work in progress, and will be finished during the next iteration.
     * This choice has been made by the customer, to make room for other functionalities
     * to be finished first
     */
    /*
     public void initiateAutoUpdates(Mainframe mf) {

     final Thread t = new Thread(new Runnable() {
     @Override
     public void run() {
     while (true) {
     try {
     updateAllContents();
     updateTableWithNewTasks(tableAllTask); // 
     Thread.sleep(60000); // Sleep one minute
                        
                        
     } catch (SQLException ex) {
     System.out.println(ex);
     } catch (IOException ex) {
     System.out.println(ex);
     } catch (InterruptedException ex) {
     System.out.println(ex);
     }
     }
     }
     });
     t.setDaemon(true); // Setting daemon will make it close along with the JVM
     t.start();
     }
    
    
     public void createWarningMessage(Component c, String msg){
        
     JOptionPane.showMessageDialog(n, "Der er opstået en fejl!", msg, customerID, c);
     }
     */
}
