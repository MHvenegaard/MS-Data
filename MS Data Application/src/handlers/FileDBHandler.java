/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Marc
 */
public class FileDBHandler {
    
    public FileDBHandler() throws ClassNotFoundException{
        
        //Driveren loades - kræver at MySQL JDBC Driver er tilføjet under Libraries
        Class.forName("com.mysql.jdbc.Driver");
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

    //Save Files
    public void saveFile(String name, InputStream inputStream, int taskID) throws IOException, SQLException {

        Connection conn = (Connection) initiateFileDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{CALL SP_SaveFile(?, ?, ?)}");
        cs.setString(1, name);
        cs.setBlob(2, inputStream);
        cs.setInt(3, taskID);

        cs.execute();
    }

    
//    public ArrayList<File> getAllFilesAssociatedWithTaskID(int taskID){
//        ArrayList<File> fileList = null;
//        
//        
//        return fileList;
//    }
    
    
    public ArrayList<File> downloadAllFilesAssociatedWithTaskID(int taskID) throws IOException, SQLException {

        ArrayList<File> fileList = new ArrayList();
        
        Connection conn = (Connection) initiateFileDBConn()[0];
        CallableStatement cs = null;
        cs = conn.prepareCall("{CALL SP_GetAllFilesUsingTaskID(?)}");
        cs.setInt(1, taskID);
        
        ResultSet rs = cs.executeQuery();
        
        while (rs.next()) {
            
            File file = null;

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
            fileList.add(file);
        }
        
        return fileList;
    }
    
    
    
    
}