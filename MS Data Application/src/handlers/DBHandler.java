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
    public ArrayList<Customer> initiateCustomerList(Connection conn) throws SQLException, IOException {
        System.out.println("Henter kunder");
        int customerID;
        int customerPhone;
        String customerName;
        String customerCVR;

        ArrayList<Customer> customerList = new ArrayList<>();

        CallableStatement cs;
        cs = conn.prepareCall("{call getCustomers}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            customerID = rs.getInt("CustomerID");
            customerName = rs.getString("CompanyName");
            System.out.println(customerName);
            customerPhone = rs.getInt("Phone");
            customerCVR = rs.getString("CVR");
            Customer customer = new Customer(customerID, customerName, customerPhone, customerCVR);
            customerList.add(customer);
        }
        return customerList;
    }

    public ArrayList<Type> SPgetTypes() throws SQLException, IOException {
        int typeID;
        String typeName;

        Connection conn = (Connection) initiateSystemDBConn()[0];

        ArrayList<Type> typeList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getTypes}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            typeID = rs.getInt("ID");
            typeName = rs.getString("Name");
            Type type = new Type(typeID, typeName);
            typeList.add(type);

        }
        return typeList;
    }

    public ArrayList<User> SPgetUsers() throws SQLException, IOException {
        int userID;
        String userName;
        String password;
        int accessLevel;

        Connection conn = (Connection) initiateSystemDBConn()[0];

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

    public ArrayList<Statuss> SPgetStatus() throws SQLException, IOException {
        String statusName;
        int statusID;

        Connection conn = (Connection) initiateSystemDBConn()[0];

        ArrayList<Statuss> statusList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getStatus}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            statusName = rs.getString("statusName");
            statusID = rs.getInt("statusID");
            Statuss status = new Statuss(statusID, statusName);
            statusList.add(status);

        }
        return statusList;
    }

    public ArrayList<Task> SPgetTasks() throws IOException, SQLException {

        ArrayList<Task> tasks = new ArrayList<>();
        int taskID;
        int parentID;
        int estimatedtime;
        int priority;
        String taskName;
        String type;
        String description;
        Date startDate;
        Date endDate;

        ArrayList<User> userOnTask = new ArrayList<>();

        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = conn.prepareCall("{call getAllTasks}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {

            taskID = rs.getInt("taskID");
            parentID = rs.getInt("parentID");
            estimatedtime = rs.getInt("estimatedTime");
            priority = rs.getInt("priority");
            type = rs.getString("type");
            Type t = new Type(type);

            
            description = rs.getString("description");
            taskName = rs.getString("taskName");
            startDate = rs.getDate("startDate");
            endDate = rs.getDate("endDate");

            Statuss s = null;
            for (int i = 0; i < Controller.statusList.size(); i++) {
                if(Controller.statusList.get(i).getStatussName().equals(rs.getString("status"))){
                    s = Controller.statusList.get(i);
                }               
            }
            
            Customer c = null;
            for (int i = 0; i < Controller.customerList.size(); i++) {

                if (Controller.customerList.get(i).getCompanyName().equals(rs.getString("customer"))) {
                    c = Controller.customerList.get(i);
                }
            }

            User u = null;
            for (int i = 0; i < Controller.userList.size(); i++) {
                if (Controller.userList.get(i).getUserName().equals(rs.getString("user"))) {
                    u = Controller.userList.get(i);
                }
            }

            //VIL IKKE SENDE DEN MED SÅ HENTER UD I CONTROLLER
            //userOnTask = SPgetUserOnTask(taskID);

            Task task = new Task(taskID, parentID, taskName, t, s, c, u, startDate, endDate, estimatedtime, priority, description, userOnTask);

            System.out.println(s + " - " + c + " - " + u);
            tasks.add(task);
        }
        return tasks;
    }

    public ArrayList<TimeSpentOnTask> SPgetTimeSpentOnTask() throws SQLException, IOException {
        ArrayList<TimeSpentOnTask> tsotList = new ArrayList();
        int taskID;
        int userID;
        int timeSpent;
        
        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getAllTimeSpentOnTask}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            taskID = rs.getInt("taskID");
            userID = rs.getInt("userID");
            timeSpent = rs.getInt("timeSpent");
            
            TimeSpentOnTask tsot = new TimeSpentOnTask(userID, taskID, timeSpent);
            tsotList.add(tsot);
        }

        return tsotList;
    }

    //Taskadministration in SystemDB
    public void createTask(Task task) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];
        java.sql.Date sqlStartDate = new java.sql.Date(task.getStartDate().getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(task.getEndDate().getTime());

        CallableStatement cs;
        cs = conn.prepareCall("{call createTask(?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setString(1, null);
        cs.setString(2, task.getTaskName());
        cs.setString(3, task.getType().getTypeName());
        cs.setString(4, task.getStatus().getStatussName());
        cs.setString(5, task.getCustomer().getCompanyName());
        cs.setString(6, task.getUser().getUserName());
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
        cs.setString(4, task.getType().getTypeName());
        cs.setString(5, task.getStatus().getStatussName());
        cs.setString(6, task.getCustomer().getCompanyName());
        cs.setString(7, task.getUser().getUserName());
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
        cs.setString(3, task.getType().getTypeName());
        cs.setString(4, task.getStatus().getStatussName());
        cs.setString(5, task.getCustomer().getCompanyName());
        cs.setString(6, task.getUser().getUserName());
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
        System.out.println("Henter bruger");
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
        System.out.println("Henter Type");
        int typeID;
        String typeName;

        ArrayList<Type> typeList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getTypes}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            typeID = rs.getInt("typeID");
            typeName = rs.getString("typeName");
            System.out.println("TypeID : "+typeID);
            Type type = new Type(typeID, typeName);
            typeList.add(type);

        }
        return typeList;
    }

    public ArrayList<Statuss> initiateStatusList(Connection conn) throws SQLException {
        System.out.println("Henter Status");
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

    public ArrayList<Task> initiateTaskList(Connection conn) throws SQLException {
         System.out.println("Henter Task");
        ArrayList<Task> tasks = new ArrayList<>();
        int taskID;
        int parentID;
        int estimatedtime;
        int priority;
        Type t = null;
        String description;
        String taskName;
        String status;
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
            status = rs.getString("status");
            
            Statuss s = null;
            for (int i = 0; i < Controller.statusList.size(); i++) {
                if(Controller.statusList.get(i).getStatussName().equals(status)){
                    s = Controller.statusList.get(i);
                }               
            }
            
            Customer c = null;
            for (int i = 0; i < Controller.customerList.size(); i++) {
                if (Controller.customerList.get(i).getCompanyName().equals(rs.getString("customer"))) {
                    c = Controller.customerList.get(i);
                }
            }

            User u = null;
            
            for (int i = 0; i < Controller.userList.size(); i++) {
                if (Controller.userList.get(i).getUserName().equals(rs.getString("user"))) {
                    u = Controller.userList.get(i);
                }
            }
            
            System.out.println(s + " - " + c + " - " + u + "TEST");
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
