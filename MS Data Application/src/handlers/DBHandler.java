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
     * 
     * 
     *
     */
    public ArrayList<Customer> retriveCustomers(String query) throws SQLException, IOException {

        ArrayList<Customer> customerList = new ArrayList<>();

        Statement stmt = (Statement) initiateSystemDBConn()[1];

        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String companyName = rs.getString("CompanyName");
            Customer customer = new Customer(companyName);
            customerList.add(customer);
        }
        return customerList;
    }

    public ArrayList<Customer> SPgetCustomers() throws SQLException, IOException {
        String compName = null;

        Connection conn = (Connection) initiateSystemDBConn()[0];

        ArrayList<Customer> customerList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getAllCustomerNames}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            compName = rs.getString("CompanyName");
            Customer customer = new Customer(compName);
            customerList.add(customer);
        }
        return customerList;
    }

    /*
     *Kalder Stored Procedure getTypes
     Der henter navnene på alle typer ud og sætter dem ind i en ArrayList
     */
    public ArrayList<Type> SPgetTypes() throws SQLException, IOException {
        String typeName = null;
        Connection conn = (Connection) initiateSystemDBConn()[0];

        ArrayList<Type> typeList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getTypes}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            typeName = rs.getString("Name");
            Type type = new Type(typeName);
            typeList.add(type);

        }
        return typeList;
    }

    public ArrayList<User> SPgetUsers() throws SQLException, IOException {
        int userID;
        String userName = null;
        String password = null;
        String firstName = null;
        String lastName = null;
        int accessLevel;

        Connection conn = (Connection) initiateSystemDBConn()[0];

        ArrayList<User> userList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getUsers}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            userID = rs.getInt("idUser");
            userName = rs.getString("shortName");
            firstName = rs.getString("userFirstName");
            lastName = rs.getString("userLastName");
            password = rs.getString("password");
            accessLevel = rs.getInt("accessLevel");
            User user = new User(userID, userName, firstName, lastName, password, accessLevel);
            userList.add(user);
        }
        return userList;
    }

    public ArrayList<Statuss> SPgetStatus() throws SQLException, IOException {
        String statusName = null;
        int statusID;
        String description = null;
        Connection conn = (Connection) initiateSystemDBConn()[0];

        ArrayList<Statuss> statusList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getStatus}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            statusName = rs.getString("statusName");
            statusID = rs.getInt("idStatus");
            description = rs.getString("description");
            Statuss status = new Statuss(statusID, statusName, description);
            statusList.add(status);

        }
        return statusList;
    }

    public Task SPgetTask(int taskID) throws IOException, SQLException {

        int priority = 0;
        int estimatedtime = 0;
        String status = null;
        String type = null;
        String description = null;
        String taskName = null;
        String customer = null;
        String user = null;
        Date startDate = null;
        Date endDate = null;
        Task task = null;

        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getTask(?)}");
        cs.setInt(1, taskID);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {

            estimatedtime = rs.getInt("EstimatedTime");

            status = rs.getString("Status");
            Statuss s = new Statuss(status);

            priority = rs.getInt("Priority");

            type = rs.getString("Type");
            Type t = new Type(type);

            description = rs.getString("Description");

            taskName = rs.getString("TaskName");
            startDate = rs.getDate("StartDate");
            endDate = rs.getDate("EndDate");

            customer = rs.getString("Customer");
            Customer c = new Customer(customer);

            user = rs.getString("User");
            User u = new User(user);

            task = new Task(taskID, taskName, t, s, c, u, startDate, endDate, estimatedtime, priority, description);

        }
        return task;
    }

    public ArrayList<Task> SPgetTasks() throws IOException, SQLException {

        ArrayList<Task> tasks = new ArrayList<>();
        int taskID = 0;
        int estimatedtime = 0;
        int priority = 0;
        String status = null;
        String type = null;
        String description = null;
        String taskName = null;
        Date startDate = null;
        Date endDate = null;
        String customer = null;
        String user = null;

        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = conn.prepareCall("{call getAllTasks}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {

            taskID = rs.getInt("TaskID");
            estimatedtime = rs.getInt("EstimatedTime");

            priority = rs.getInt("Priority");

            type = rs.getString("Type");
            Type t = new Type(type);

            status = rs.getString("Status");
            Statuss s = new Statuss(status);

            description = rs.getString("Description");

            taskName = rs.getString("TaskName");
            startDate = rs.getDate("StartDate");
            endDate = rs.getDate("EndDate");

            customer = rs.getString("Customer");
            Customer c = new Customer(customer);

            user = rs.getString("User");
            User u = new User(user);

            Task task = new Task(taskID, taskName, t, s, c, u, startDate, endDate, estimatedtime, priority, description);
            tasks.add(task);
        }
        return tasks;
    }

    public void createTask(Task task) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];
        java.sql.Date sqlStartDate = new java.sql.Date(task.getStartDate().getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(task.getEndDate().getTime());

        CallableStatement cs = null;
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

    public void updateTask(Task task) throws SQLException, IOException {
        Connection conn = (Connection) initiateSystemDBConn()[0];
        java.sql.Date sqlStartDate = new java.sql.Date(task.getStartDate().getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(task.getEndDate().getTime());

        CallableStatement cs = null;
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

    public void addUserToTask(JList list) throws SQLException, IOException {
        ArrayList<User> userList = new ArrayList<>();

        Connection conn = (Connection) initiateSystemDBConn()[0];
        CallableStatement cs = null;

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

    public ArrayList<User> SPgetUserOnTask(int taskID) throws SQLException, IOException {
        String username;
        ArrayList<User> userOnTaskList = new ArrayList<>();

        Connection conn = (Connection) initiateSystemDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getUserOnTask(?)}");
        cs.setInt(1, taskID);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            username = rs.getString("shortName");
            userOnTaskList.add(new User(username));
        }
        return userOnTaskList;
    }

    public ArrayList<User> SPgetUsersFromUserDB() throws SQLException, IOException {
        int userID;
        String userName = null;
        String password = null;
        String firstName = null;
        String lastName = null;
        int accessLevel;

        Connection conn = (Connection) initiateEmployeeDBConn()[0];

        ArrayList<User> userList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getAllUsers}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            userID = rs.getInt("idUser");
            userName = rs.getString("shortName");
            firstName = rs.getString("userFirstName");
            lastName = rs.getString("userLastName");
            password = rs.getString("password");
            accessLevel = rs.getInt("accessLevel");
            User user = new User(userID, userName, firstName, lastName, password, accessLevel);
            userList.add(user);
        }
        return userList;
    }

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

    public ArrayList<User> getUserInUserDB() throws IOException, SQLException {
        ArrayList<User> userList = new ArrayList<>();
        int accessLevel = 0;
        int idUser = 0;
        String username = null;
        String firstname = null;
        String lastname = null;
        String password = null;
        User user = null;

        Connection conn = (Connection) initiateEmployeeDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getAllUsers()}");

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {

            accessLevel = rs.getInt("AccessLevel");
            idUser = rs.getInt("idUser");
            username = rs.getString("shortName");
            firstname = rs.getString("userFirstName");
            lastname = rs.getString("userLastName");
            password = rs.getString("password");

            user = new User(idUser, username, firstname, lastname, password, accessLevel);
            userList.add(user);
        }
        return userList;
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
}
