package handlers;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import model.Customer;
import model.Statuss;
import model.Task;
import model.TimeSpentOnTask;
import model.Type;
import model.User;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class DBHandler {

    /*
     * The DBHandler class Constructor. 
     * The Constructor loads the JDBC Driver
     */
    public DBHandler() throws ClassNotFoundException {

        //Driveren loades - kræver at MySQL JDBC Driver er tilføjet under Libraries
        Class.forName("com.mysql.jdbc.Driver");

    }

    /**
     * Initiates a connection to the customer database.
     *
     * @return Object[] returns an object array containing a created Connection-
     * and Statement object for the Customer database. Object[0] is the
     * Connection object, Object[1] is the Statement object.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public Object[] initiateCustomerDBConn() throws IOException, SQLException {
        Properties prop = new Properties();

        //load a properties file
        prop.load(DBHandler.class.getResourceAsStream("/ressources/config.properties"));

        //get the property value and print it out
        String database = prop.getProperty("customer_db_databasename");
        String dbuser = prop.getProperty("customer_db_username");
        String dbpassword = prop.getProperty("customer_db_password");
        String ip = prop.getProperty("customer_db_ip");
        String port = prop.getProperty("customer_db_port");
        String connectString = "jdbc:mysql://" + ip + ":" + port + "/" + database;

        Connection conn = DriverManager.getConnection(connectString, dbuser, dbpassword);
        Statement stmt = conn.createStatement();

        Object[] returnObjects = new Object[2];
        returnObjects[0] = conn;
        returnObjects[1] = stmt;

        return returnObjects;
    }

    /**
     * Initiates a connection to the employee database.
     *
     * @return Object[] returns an object array containing a created Connection-
     * and Statement object for the Customer database. Object[0] is the
     * Connection object, Object[1] is the Statement object.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public Object[] initiateEmployeeDBConn() throws SQLException, IOException {
        Properties prop = new Properties();

        //load a properties file
        prop.load(DBHandler.class.getResourceAsStream("/ressources/config.properties"));

        //get the property value and print it out
        String database = prop.getProperty("employee_db_databasename");
        String dbuser = prop.getProperty("employee_db_username");
        String dbpassword = prop.getProperty("employee_db_password");
        String ip = prop.getProperty("employee_db_ip");
        String port = prop.getProperty("employee_db_port");
        String connectString = "jdbc:mysql://" + ip + ":" + port + "/" + database;

        Connection conn = DriverManager.getConnection(connectString, dbuser, dbpassword);
        Statement stmt = conn.createStatement();

        Object[] returnObjects = new Object[2];
        returnObjects[0] = conn;
        returnObjects[1] = stmt;

        return returnObjects;
    }

    /**
     * Initiates a connection to the system database.
     *
     * @return Object[] returns an object array containing a created Connection-
     * and Statement object for the Customer database. Object[0] is the
     * Connection object, Object[1] is the Statement object.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public Object[] initiateSystemDBConn() throws SQLException, IOException {
        Properties prop = new Properties();

        //load a properties file
        prop.load(DBHandler.class.getResourceAsStream("/ressources/config.properties"));

        //get the property value and print it out
        String database = prop.getProperty("system_db_databasename");
        String dbuser = prop.getProperty("system_db_username");
        String dbpassword = prop.getProperty("system_db_password");
        String ip = prop.getProperty("system_db_ip");
        String port = prop.getProperty("system_db_port");
        String connectString = "jdbc:mysql://" + ip + ":" + port + "/" + database;

        Connection conn = DriverManager.getConnection(connectString, dbuser, dbpassword);
        Statement stmt = conn.createStatement();

        Object[] objects = new Object[2];
        objects[0] = conn;
        objects[1] = stmt;

        return objects;
    }

    /**
     * Retrieves all TimeSpentOnTask objects from the database
     *
     * @param conn The connection object used to send statements
     * @return tsotList - An ArrayList containing all TimeSpentOnTask objects
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public ArrayList<TimeSpentOnTask> initiateTimeSpentOnTaskList(Connection conn) throws SQLException, IOException {
        ArrayList<TimeSpentOnTask> tsotList = new ArrayList();
        int taskID;
        int userID;
        int timeSpent;
        String comment;

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getAllTimeSpentOnTask}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            taskID = rs.getInt("taskID");
            userID = rs.getInt("userID");
            timeSpent = rs.getInt("timeSpent");
            comment = rs.getString("comment");

            TimeSpentOnTask tsot = new TimeSpentOnTask(taskID, userID, timeSpent, comment);
            tsotList.add(tsot);
        }

        return tsotList;
    }

    /**
     * Updates a TimeSpentOnTask object in the database
     *
     * @param tsot The TimeSpentOnTask object to be saved
     * @param task The Task the TimeSpentOnTask object is associated with
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     * *
     */
    public void updateTimeSpentOnTask(TimeSpentOnTask tsot, Task task) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs;
        cs = conn.prepareCall("{call updateTimeSpentOnTask(?,?,?,?)}");
        cs.setInt(1, tsot.getTaskID());
        cs.setInt(2, tsot.getUserID());
        cs.setInt(3, tsot.getTimeSpent());
        cs.setString(4, tsot.getComment());
        cs.execute();

        updateTask(task);
    }

    /**
     * Save a new TimeSpentOnTask object to the database
     *
     * @param tsot The TimeSpentOnTask object to be saved
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void createTimeSpentOnTask(TimeSpentOnTask tsot) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs;
        cs = conn.prepareCall("{call createTimeSpentOnTask(?,?,?)}");
        cs.setInt(1, tsot.getUserID());
        cs.setInt(2, tsot.getTimeSpent());
        cs.setString(3, tsot.getComment());
        cs.execute();

    }

    /**
     * Save a new Task object to the database
     *
     * @param task The task to be saved
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void createTask(Task task) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];
        java.sql.Date sqlStartDate = new java.sql.Date(task.getStartDate().getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(task.getEndDate().getTime());

        System.out.println(task.getCustomer().getCompanyName());

        CallableStatement cs;
        cs = conn.prepareCall("{call createTask(?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setString(1, null);
        cs.setString(2, task.getTaskName());
        cs.setInt(3, task.getType().getTypeID());
        cs.setInt(4, task.getStatus().getStatusID());
        cs.setInt(5, task.getCustomer().getCustomerID());
        cs.setInt(6, task.getUser().getUserID());
        cs.setDate(7, sqlStartDate);
        cs.setDate(8, sqlEndDate);
        cs.setInt(9, task.getEstimatedtime());
        cs.setInt(10, task.getPriority());
        cs.setString(11, task.getDescription());

        cs.execute();
    }

    /**
     * Save a new task object to the database. This task object has already been
     * set to a state of finished.
     *
     * @param task
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void createQuickTask(Task task) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];
        java.sql.Date sqlStartDate = new java.sql.Date(task.getStartDate().getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(task.getEndDate().getTime());

        System.out.println(task.getCustomer().getCompanyName());

        CallableStatement cs;
        cs = conn.prepareCall("{call createTask(?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setString(1, null);
        cs.setString(2, task.getTaskName());
        cs.setInt(3, task.getType().getTypeID());
        cs.setInt(4, task.getStatus().getStatusID());
        cs.setInt(5, task.getCustomer().getCustomerID());
        cs.setInt(6, task.getUser().getUserID());
        cs.setDate(7, sqlStartDate);
        cs.setDate(8, sqlEndDate);
        cs.setInt(9, task.getEstimatedtime());
        cs.setInt(10, task.getPriority());
        cs.setString(11, task.getDescription());

        cs.execute();
    }

    /**
     * Saves a subtask to the database.
     *
     * @param task The task object to be saved.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void createSubTask(Task task) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];
        java.sql.Date sqlStartDate = new java.sql.Date(task.getStartDate().getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(task.getEndDate().getTime());

        CallableStatement cs;
        cs = conn.prepareCall("{call createSubTask(?,?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setString(1, null);
        cs.setInt(2, task.getParentID());
        cs.setString(3, task.getTaskName());
        cs.setInt(4, task.getType().getTypeID());
        cs.setInt(5, task.getStatus().getStatusID());
        cs.setInt(6, task.getCustomer().getCustomerID());
        cs.setInt(7, task.getUser().getUserID());
        cs.setDate(8, sqlStartDate);
        cs.setDate(9, sqlEndDate);
        cs.setInt(10, task.getEstimatedtime());
        cs.setInt(11, task.getPriority());
        cs.setString(12, task.getDescription());

        cs.execute();
    }

    /**
     * Updates a Task object in the database.
     *
     * @param task The Task object to be updated in the database.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void updateTask(Task task) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];
        java.sql.Date sqlStartDate = new java.sql.Date(task.getStartDate().getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(task.getEndDate().getTime());

        CallableStatement cs;
        cs = conn.prepareCall("{call updateTask(?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setInt(1, task.getTaskID());
        cs.setString(2, task.getTaskName());
        cs.setInt(3, task.getType().getTypeID());
        cs.setInt(4, task.getStatus().getStatusID());
        cs.setInt(5, task.getCustomer().getCustomerID());
        cs.setInt(6, task.getUser().getUserID());
        cs.setDate(7, sqlStartDate);
        cs.setDate(8, sqlEndDate);
        cs.setInt(9, task.getEstimatedtime());
        cs.setInt(10, task.getPriority());
        cs.setString(11, task.getDescription());
        cs.execute();
    }

    /**
     * Saves a new task Type
     *
     * @param name The name of the type to be saved.
     * @param description A description of the type to be saved.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     *
     */
    public void createType(String name, String description) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call createType(?)}");
        cs.setString(1, name);
        cs.execute();
    }

    /**
     * Updates a type in the database.
     *
     * @param typeID The ID for the type object.
     * @param name The name of the type.
     * @param description The description of the type.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void updateType(int typeID, String name, String description) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call updateType(?,?)}");
        cs.setInt(1, typeID);
        cs.setString(2, name);
        cs.execute();
    }

    /**
     * Deletes a type from the database
     *
     * @param typeID The ID of the type to be deleted
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void deleteType(int typeID) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call deleteType(?)}");
        cs.setInt(1, typeID);
        cs.execute();
    }

    /**
     * Saves a new Status object to the database
     *
     * @param name The name of the Status.
     * @param description The description of the Status.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void createStatus(String name, String description) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call createStatus(?)}");
        cs.setString(1, name);
        cs.execute();
    }

    /**
     * Updates a Status object in the database.
     *
     * @param statusID The Status object ID
     * @param name The Status objects name
     * @param description The Status objects description
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void updateStatus(int statusID, String name, String description) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call updateStatus(?,?)}");
        cs.setInt(1, statusID);
        cs.setString(2, name);
        cs.execute();
    }

    /**
     *
     * @param statusID
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void deleteStatus(int statusID) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call deleteStatus(?)}");
        cs.setInt(1, statusID);
        cs.execute();
    }

    /**
     * Adds all users from the list to a task.
     *
     * @param list The JList containing all the user objects to be added to the
     * task.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     * @see DBHandler#createNewTask()
     */
    public void addUserToTask(JList list) throws SQLException, IOException {
        ArrayList<User> userList = new ArrayList<>();
        Connection conn = (Connection) initiateSystemDBConn()[0];
        CallableStatement cs;

        DefaultListModel modelOnTask = (DefaultListModel) list.getModel();
        for (int i = 0; i < modelOnTask.getSize(); i++) {

            userList.add((User) modelOnTask.getElementAt(i));
        }
        for (int i = 0; i < userList.size(); i++) {
            cs = conn.prepareCall("{call addUserToTask(?)}");
            cs.setInt(1, userList.get(i).getUserID());
            cs.execute();
        }
    }

    /**
     * Adds a user to a task that has already been created.
     *
     * @param list The JList containing all the user objects to be added to the
     * task.
     * @param taskID The taskID of the task object the users will be attached
     * to.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void addUserToAlreadyMadeTask(JList list, int taskID) throws SQLException, IOException {
        ArrayList<User> userList = new ArrayList<>();
        Connection conn = (Connection) initiateSystemDBConn()[0];
        CallableStatement cs = null;
        DefaultListModel modelOnTask = (DefaultListModel) list.getModel();

        for (int i = 0; i < modelOnTask.getSize(); i++) {
            userList.add((User) modelOnTask.getElementAt(i));
        }
        for (int i = 0; i < userList.size(); i++) {
            cs = conn.prepareCall("{call  addUserToAlreadyMadeTask(?,?)}");
            cs.setInt(1, taskID);
            cs.setInt(2, userList.get(i).getUserID());

            cs.execute();
        }
    }

    /**
     * Retrieves all User objects from the database and adds them to a list.
     *
     * @param conn The connection to be used for the query
     * @return userList - An ArrayList containing all User objects.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     */
    public ArrayList<User> initiateUserList(Connection conn) throws SQLException {
        int userID;
        String userName;
        String password;
        int accessLevel;

        ArrayList<User> userList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getUsers}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            userID = rs.getInt("userID");
            userName = rs.getString("userName");
            password = rs.getString("password");
            accessLevel = rs.getInt("accessLevel");
            User user = new User(userID, userName, password, accessLevel);
            userList.add(user);
        }
        return userList;
    }

    /**
     * Retrieves all Type objects from the database and adds them to a list.
     *
     * @param conn The connection to be used for the query
     * @return typeList - An ArrayList containing all Type objects.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     */
    public ArrayList<Type> initiateTypeList(Connection conn) throws SQLException {
        int typeID;
        String typeName;

        ArrayList<Type> typeList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getTypes}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            typeID = rs.getInt("typeID");
            typeName = rs.getString("typeName");
            Type type = new Type(typeID, typeName);
            typeList.add(type);

        }
        return typeList;
    }

    /**
     * Retrieves all Status objects from the database and adds them to a list.
     *
     * @param conn The connection to be used for the query
     * @return statusList - An ArrayList containing all Status objects.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     */
    public ArrayList<Statuss> initiateStatusList(Connection conn) throws SQLException {
        String statusName;
        int statusID;
        ArrayList<Statuss> statusList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getStatus}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            statusID = rs.getInt("statusID");
            statusName = rs.getString("statusName");
            Statuss status = new Statuss(statusID, statusName);
            statusList.add(status);

        }
        return statusList;
    }

    /**
     * Retrieves all Customer objects from the database and adds them to a list.
     *
     * @param conn The connection to be used for the query
     * @return customerList - An ArrayList containing all Customer objects.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     */
    public ArrayList<Customer> initiateCustomerList(Connection conn) throws SQLException, IOException {
        int customerID;
        int customerPhone;
        String customerName;
        String customerCVR;

        ArrayList<Customer> customerList = new ArrayList<>();

        CallableStatement cs;
        cs = conn.prepareCall("{call getCustomers}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            customerID = rs.getInt("customerID");
            customerName = rs.getString("companyName");
            customerPhone = rs.getInt("phone");
            customerCVR = rs.getString("CVR");
            Customer customer = new Customer(customerID, customerName, customerPhone, customerCVR);
            customerList.add(customer);
        }

        return customerList;

    }

    /**
     * Retrieves all Task objects from the database and adds them to a list.
     *
     * @param conn The connection to be used for the query
     * @return tasks - An ArrayList containing all Task objects.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     */
    public ArrayList<Task> initiateTaskList(Connection conn) throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();
        int taskID;
        int parentID;
        int estimatedtime;
        int priority;
        Type t = null;
        Statuss s = null;
        Customer c = null;
        User u = null;
        String description;
        String taskName;
        Date startDate;
        Date endDate;

        ArrayList<User> userOnTask = new ArrayList<>();

        CallableStatement cs = conn.prepareCall("{call getAllTasks}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            taskID = rs.getInt("taskID");
            parentID = rs.getInt("parentID");
            estimatedtime = rs.getInt("estimatedTime");
            priority = rs.getInt("priority");
            description = rs.getString("description");
            taskName = rs.getString("taskName");
            startDate = rs.getDate("startDate");
            endDate = rs.getDate("endDate");

            for (int i = 0; i < Controller.statusList.size(); i++) {
                if (Controller.statusList.get(i).getStatusID() == rs.getInt("status")) {
                    s = Controller.statusList.get(i);
                }
            }

            for (int i = 0; i < Controller.customerList.size(); i++) {
                if (Controller.customerList.get(i).getCustomerID() == rs.getInt("customer")) {
                    c = Controller.customerList.get(i);
                }
            }

            for (int i = 0; i < Controller.userList.size(); i++) {
                if (Controller.userList.get(i).getUserID() == rs.getInt("taskLeader")) {
                    u = Controller.userList.get(i);
                }
            }

            for (int i = 0; i < Controller.typeList.size(); i++) {
                if (Controller.typeList.get(i).getTypeID() == rs.getInt("type")) {
                    t = Controller.typeList.get(i);
                }
            }
            Task task = new Task(taskID, parentID, taskName, t, s, c, u, startDate, endDate, estimatedtime, priority, description, userOnTask);
            tasks.add(task);
        }
        return tasks;

    }

    /**
     * Removes all users associated with a task.
     *
     * @param taskID The ID of the task from which all users shall be removed.
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public void SPremoveAllUsersOnTask(int taskID) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call deleteAllUserOnTask(?)}");
        cs.setInt(1, taskID);
        cs.executeQuery();
    }
}
