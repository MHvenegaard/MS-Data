package model;

import java.io.File;
import java.sql.Date;


public class MyFile {
    
    private int id;
    private String name;
    private Date creationDate;
    private File file;
    private int taskID;
    
    public MyFile(int id, String name, Date creationDate, File file, int taskID) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.file = file;
        this.taskID = taskID;
    }

    public MyFile(int id, String name, Date creationDate, int taskID) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.taskID = taskID;
        file = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    
    
    
    
    
    
}
