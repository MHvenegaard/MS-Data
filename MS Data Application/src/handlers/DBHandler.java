package handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
 *
 * @author Marc
 */
public class DBHandler {

    public DBHandler() throws ClassNotFoundException {

        //Driveren loades - kræver at MySQL JDBC Driver er tilføjet under Libraries
        Class.forName("com.mysql.jdbc.Driver");

    }

    /**
     * *****************************************************************************
     * NÅR DER SKAL OPRETTES ET NYT DB KALD GØR FØLGENDE: Opret nyt metodekald
     * Kald initiate DB Conn metoden til den DB der skal benyttes Der returneres
     * et array med et Connection og Statement object Lav nu et standard SQL
     * kald og benyt Statement objektet til at udføre denne med. Benyt et
     * eventuelt result sæt Do stuff Luk det eventuelle RS kald stmt.close(); på
     * Statement objektet kald conn.close(); på Connection objektet returner
     * eventuelt objekt/data/whatever metoden nu skulle gøre
     * *********************************************************************** *
     * /
     *
     * /
     *
     * @return Object[] returns an object array containing a created Connection-
     * and Statement object for the Customer database. Object[0] is the
     * Connection object Object[1] is the Statement object
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
    /*
     * @return Object[] returns an object array containing a created Connection- and Statement object for the Employee database.
     * Object[0] is the Connection object
     * Object[1] is the Statement object
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
    /*
     * @return Object[] returns an object array containing a created Connection- and Statement object for the System database.
     * Object[0] is the Connection object
     * Object[1] is the Statement object
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
    /*
     * @return Object[] returns an object array containing a created Connection- and Statement object for the File database.
     * Object[0] is the Connection object
     * Object[1] is the Statement object
     */

    public Object[] initiateFileDBConn() throws IOException, SQLException {
        Properties prop = new Properties();

        //load a properties file
        prop.load(DBHandler.class.getResourceAsStream("/ressources/config.properties"));

        //get the property value and print it out
        String database = prop.getProperty("file_db_databasename");
        String dbuser = prop.getProperty("file_db_username");
        String dbpassword = prop.getProperty("file_db_password");
        String ip = prop.getProperty("file_db_ip");
        String port = prop.getProperty("file_db_port");
        String connectString = "jdbc:mysql://" + ip + ":" + port + "/" + database;

        Connection conn = DriverManager.getConnection(connectString, dbuser, dbpassword);
        Statement stmt = conn.createStatement();

        Object[] returnObjects = new Object[2];
        returnObjects[0] = conn;
        returnObjects[1] = stmt;

        return returnObjects;
    }

    //Get and Save Files
    public void saveFile(String name, InputStream inputStream, int taskID) throws IOException, SQLException {

        Connection conn = (Connection) initiateFileDBConn()[0];

        String sql = "INSERT INTO File (Name, File, TaskID) values (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        statement.setBlob(2, inputStream);
        statement.setInt(3, taskID);

        int row = statement.executeUpdate();
        if (row > 0) {
            System.out.println("A contact was inserted with photo image.");
        }
    }

    public String getFile(int taskID) throws IOException, SQLException {

        Statement stmt = (Statement) initiateFileDBConn()[1];
        ResultSet rs = stmt.executeQuery("SELECT fileName, extension, file FROM Files");

        File file = null;

        if (rs.next()) {

            String filename = rs.getString(1);
            String extension = rs.getString(2);
            Blob blob = rs.getBlob(3);
            InputStream is = blob.getBinaryStream();
            // Find the temporary folder
            String tmpfolder = System.getProperty("java.io.tmpdir");

            file = File.createTempFile(filename, extension, new File(tmpfolder));
            FileOutputStream fos = new FileOutputStream(file);

            int b = 0;
            while ((b = is.read()) != -1) {
                fos.write(b);
            }

        }
        String result;
        if (file != null) {
            result = file.getCanonicalPath();
        } else {
            result = "";
        }
        return result;
    }

    //Get complete lists of objects by SP
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

            TimeSpentOnTask tsot = new TimeSpentOnTask(taskID, userID, timeSpent,comment);
            tsotList.add(tsot);
        }

        return tsotList;
    }

    public void createTimeSpentOnTask(TimeSpentOnTask tsot) throws SQLException, IOException{
        Connection conn = (Connection) initiateSystemDBConn()[0];
        
        CallableStatement cs;
        cs = conn.prepareCall("{call createTimeSpentOnTask(?,?,?,?)}");
        cs.setInt(1, tsot.getTaskID());
        cs.setInt(2, tsot.getUserID());
        cs.setInt(3, tsot.getTimeSpent());
        cs.setString(4, tsot.getComment());
        cs.execute();
    }
    
    //Taskadministration in SystemDB
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

    //Typeadministration in SystemDB
    public void createType(String name, String description) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call createType(?)}");
        cs.setString(1, name);
        cs.execute();
    }

    public void updateType(int typeID, String name, String description) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call updateType(?,?)}");
        cs.setInt(1, typeID);
        cs.setString(2, name);
        cs.execute();
    }

    public void deleteType(int typeID) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call deleteType(?)}");
        cs.setInt(1, typeID);
        cs.execute();
    }

    //Statusadministration in SystemDB
    public void createStatus(String name, String description) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call createStatus(?)}");
        cs.setString(1, name);
        cs.execute();
    }

    public void updateStatus(int statusID, String name, String description) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call updateStatus(?,?)}");
        cs.setInt(1, statusID);
        cs.setString(2, name);
        cs.execute();
    }

    public void deleteStatus(int statusID) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call deleteStatus(?)}");
        cs.setInt(1, statusID);
        cs.execute();
    }

    //Add users to tasks
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

    //Useradministration in UserDB
    public void createUserInUserDB(String userID, String userName, String firstName, String lastName, String password, int accessLevel) throws SQLException, IOException {
        Connection conn = (Connection) initiateEmployeeDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call createUser(?,?,?,?,?,?)}");
        cs.setString(1, null);
        cs.setString(2, userName);
        cs.setString(3, firstName);
        cs.setString(4, lastName);
        cs.setString(5, password);
        cs.setInt(6, accessLevel);
        cs.execute();
    }

    public void updateUserInUserDB(String userName, String firstName, String lastName, String password, int accessLevel, int userID) throws SQLException, IOException {
        Connection conn = (Connection) initiateEmployeeDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call updateUser(?,?,?,?,?,?)}");
        cs.setString(1, userName);
        cs.setString(2, firstName);
        cs.setString(3, lastName);
        cs.setString(4, password);
        cs.setInt(5, accessLevel);
        cs.setInt(6, userID);
        cs.execute();
    }

    public void deleteUserInUserDB(int userID) throws SQLException, IOException {
        Connection conn = (Connection) initiateEmployeeDBConn()[0];
        CallableStatement cs = null;
        cs = conn.prepareCall("{call deleteUser(?)}");
        cs.setInt(1, userID);
        cs.execute();
    }

    //Note 1 - Nikolaj 
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

    //Skal denne virkelig bruges til noget?
    public void SPremoveAllUsersOnTask(int taskID) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call deleteAllUserOnTask(?)}");
        cs.setInt(1, taskID);
        cs.executeQuery();
    }
}
