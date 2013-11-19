package handlers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import model.Customer;

/**
 *
 * @author Marc
 */
public class DBHandler {

    public DBHandler() throws ClassNotFoundException, SQLException {

        //Driveren loades - kræver at MySQL JDBC Driver er tilføjet under Libraries
        Class.forName("com.mysql.jdbc.Driver");


    }
   

/*******************************************************************************
* NÅR DER SKAL OPRETTES ET NYT DB KALD GØR FØLGENDE:    
* Opret nyt metodekald
* Kald initiate DB Conn metoden til den DB der skal benyttes
* Der returneres et array med et Connection og Statement object
* Lav nu et standard SQL kald og benyt Statement objektet til at udføre denne med.
* Benyt et eventuelt result sæt
* Do stuff
* Luk det eventuelle RS
* kald stmt.close(); på Statement objektet
* kald conn.close(); på Connection objektet
* returner eventuelt objekt/data/whatever metoden nu skulle gøre
********************************************************************************
    
    
    
    
    
    
    
    
    
    
    
    
    /*
     * @return Object[] returns an object array containing a created Connection- and Statement object for the Customer database.
     * Object[0] is the Connection object
     * Object[1] is the Statement object
     */
    private Object[] initiateCustomerDBConn() throws SQLException, IOException {
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
    private Object[] initiateEmployeeDBConn() throws SQLException, IOException {
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
    private Statement initiateSystemDBConn() throws SQLException, IOException {
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

        return stmt;
    }
    
    /*
     * 
     * 
     *
     */
    
    public ArrayList<Customer> retriveCustomers(String query) throws SQLException, IOException {
        
        ArrayList<Customer> CustomerList = new ArrayList<>();
        
        ResultSet rs = initiateSystemDBConn().executeQuery(query);
        while (rs.next()) {
            String companyName = rs.getString("CompanyName");
            Customer customer = new Customer(companyName);
            CustomerList.add(customer);
        }
        return CustomerList;
    }
    
}
