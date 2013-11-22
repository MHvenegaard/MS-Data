/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Marc
 */
public class Task {
    
    private int taskID;
    private int estimatedtime;
    private int status;
    private int priority;
    private Type type;
    private String description;
    private Date datetime;
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private User user;

    public Task(int estimatedtime, int status, int priority, Type type, String description, Date datetime) {
        this.estimatedtime = estimatedtime;
        this.status = status;
        this.priority = priority;
        this.type = type;
        this.description = description;
        this.datetime = datetime;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getEstimatedtime() {
        return estimatedtime;
    }

    public void setEstimatedtime(int estimatedtime) {
        this.estimatedtime = estimatedtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
    
}
