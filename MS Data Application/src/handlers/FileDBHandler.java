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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import model.MyFile;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class FileDBHandler {

    /*
     * The FileDBHandler class Constructor. 
     * The Constructor loads the JDBC Driver
     */
    public FileDBHandler() throws ClassNotFoundException {

        //Driveren loades - kræver at MySQL JDBC Driver er tilføjet under Libraries
        Class.forName("com.mysql.jdbc.Driver");
    }

    /*

     */
    /**
     * Initiates a connection to the file database.
     *
     * @return Object[] returns an object array containing a created Connection-
     * and Statement object for the File database. Object[0] is the Connection
     * object Object[1] is the Statement object
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
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

    /**
     * Saves an input stream as a file object in the file database.
     *
     * @param name The name of the File
     * @param inputStream The inputstream from which the file is created
     * @param taskID The ID of the task to which the file is attached
     */
    public void saveFile(String name, InputStream inputStream, int taskID) throws IOException, SQLException {

        Connection conn = (Connection) initiateFileDBConn()[0];

        CallableStatement cs = null;
        cs = conn.prepareCall("{CALL SP_SaveFile(?, ?, ?)}");
        cs.setString(1, name);
        cs.setBlob(2, inputStream);
        cs.setInt(3, taskID);

        cs.execute();
    }

    /**
     * Downloads the specified file using the fileID
     *
     * @param taskID Used to identify files attached to the Task.
     * @return MyFile - The specified File
     * @throws SQLException The queried data could not be retrieved from the
     * database.
     * @throws IOException A connection to the server could not be established.
     */
    public MyFile downloadFileFromFileID(int fileID) throws IOException, SQLException {

        Connection conn = (Connection) initiateFileDBConn()[0];
        CallableStatement cs = null;
        cs = conn.prepareCall("{CALL SP_GetFileUsingFileID(?)}");
        cs.setInt(1, fileID);

        ResultSet rs = cs.executeQuery();

        rs.next();

        MyFile mf = null;

        int id = rs.getInt(1);
        String filename = rs.getString(2);
        Date creationDate = rs.getDate(3);
        Blob blob = rs.getBlob(4);
        int taskID = rs.getInt(5);
        InputStream is = blob.getBinaryStream();

        // Creates a new file in the temp folder
        String suffix = "";
        String prefix = "";

        String[] tokens = filename.split("\\.(?=[^\\.]+$)");
        // SOURCE:  http://stackoverflow.com/questions/4545937/java-splitting-the-filename-into-a-base-and-extension
        // SOURCE: http://stackoverflow.com/questions/4416425/how-to-split-string-with-some-seperator-but-without-removing-that-seperator-in-j/4416576#4416576

        prefix = tokens[0];
        suffix = tokens[1];

//        System.out.println(prefix);
//        System.out.println(suffix);
//        System.out.println(tmpfolder);
        
        String tmpfolder = System.getProperty("java.io.tmpdir");
        File f = new File(tmpfolder+prefix+"."+suffix);

       // Write file to the temp folder
        FileOutputStream fos = new FileOutputStream(f);
        int b = 0;
        while ((b = is.read()) != -1) {
            fos.write(b);
        }
        fos.close();

        mf = new MyFile(id, filename, creationDate, f, taskID);

        return mf;
    }

    public MyFile retrieveFileInfoUsingFileID(int fileID) throws SQLException, IOException {

        MyFile mf = null;

        Connection conn = (Connection) initiateFileDBConn()[0];
        CallableStatement cs = null;
        cs = conn.prepareCall("{CALL SP_GetFileUsingFileID(?)}");
        cs.setInt(1, fileID);

        ResultSet rs = cs.executeQuery();
        int id = rs.getInt("ID");
        String filename = rs.getString("Filename");
        Date creationDate = rs.getDate("CreationDate");
        int taskID = rs.getInt("TaskID");

        mf = new MyFile(id, filename, creationDate, taskID);

        return mf;
    }

    public ArrayList<MyFile> retrieveAllFilesInfoAttachedToTaskID(int taskIDParam) throws SQLException, IOException {

        ArrayList<MyFile> fileList = new ArrayList();

        Connection conn = (Connection) initiateFileDBConn()[0];
        CallableStatement cs = null;
        cs = conn.prepareCall("{CALL SP_GetAllFileInfosFromTaskID(?)}");
        cs.setInt(1, taskIDParam);

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {

            MyFile mf = null;

            int ID = rs.getInt(1);
            String filename = rs.getString(2);
            Date date = rs.getDate(3);
            int taskID = rs.getInt(4);

            mf = new MyFile(ID, filename, date, taskID);
            fileList.add(mf);
        }

        return fileList;
    }
}
