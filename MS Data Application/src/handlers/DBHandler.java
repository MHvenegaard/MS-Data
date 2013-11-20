package handlers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.net.ssl.SSLEngineResult.Status;
import model.Customer;
import model.Statuss;
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
     * *********************************************************************** * /
     
     /* @return Object[] returns an object array containing a created Connection-
     * and Statement object for the Customer database. Object[0] is the
     * Connection object Object[1] is the Statement object
     */
    public  Object[] initiateCustomerDBConn() throws IOException, SQLException {
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
        Connection conn = (Connection) initiateCustomerDBConn()[0];

        ArrayList<Customer> customerList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getAllCustomerNames}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            compName = rs.getString("CompanyName");
            Customer customer = new Customer(compName);
            customerList.add(customer);
            //System.out.println("CompanyName kald via StoredProcedurs: " + compName);
        }
        return customerList;
    }

    /*
    *Kalder Stored Procedure getTypes
    Der henter navnene på alle typer ud og sætter dem ind i en ArrayList
    */
    public ArrayList<Type> SPgetTypes() throws SQLException, IOException {
        String typeName = null;
        Connection conn = (Connection) initiateCustomerDBConn()[0];

        ArrayList<Type> typeList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getTypes}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            typeName = rs.getString("Name");
            Type type = new Type(typeName);
            typeList.add(type);
            //System.out.println("CompanyName kald via StoredProcedurs: " + compName);
        }
        return typeList;
    }
    
    public ArrayList<User> SPgetUsers() throws SQLException, IOException {
        String userName = null;
        Connection conn = (Connection) initiateCustomerDBConn()[0];

        ArrayList<User> userList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getUserShortName}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            userName = rs.getString("shortName");
            User user = new User(userName);
            userList.add(user);
            //System.out.println("CompanyName kald via StoredProcedurs: " + compName);
        }
        return userList;
    }
    
      public ArrayList<Statuss> SPgetStatus() throws SQLException, IOException {
        String statusName = null;
        Connection conn = (Connection) initiateCustomerDBConn()[0];

        ArrayList<Statuss> statusList = new ArrayList<>();

        CallableStatement cs = null;
        cs = conn.prepareCall("{call getStatus}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            statusName = rs.getString("statusName");
            Statuss status = new Statuss(statusName);
            statusList.add(status);
            //System.out.println("CompanyName kald via StoredProcedurs: " + compName);
        }
        return statusList;
    }
    
    

    public void createTask(int estimatedTime, String description, String status, int prio,String taskName,String startDate, String endDate,String type, String customer, String user) throws SQLException, IOException{
        Connection conn = (Connection) initiateCustomerDBConn()[0];
        
        CallableStatement cs = null;
        cs = conn.prepareCall("{call createTask(?,?,?,?,?,?,?,?,?,?,?)}");
        cs.setString(1, null);
        cs.setInt(2, estimatedTime);
        cs.setString(3, description);
        cs.setString(4, status);
        cs.setInt(5, prio);
        cs.setString(6, taskName);
        cs.setString(7, startDate);
        cs.setString(8, endDate);
        cs.setString(9, type);
        cs.setString(10, customer);
        cs.setString(11, user);
        cs.execute();
    }
    
}
