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
    private Statuss status;
    private int priority;
    private Type type;
    private String description;
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private User user;
    private String taskName;

    public Task(int estimatedtime, Statuss status, int priority, Type type, String description, Date startDate, Date endDate) {
        this.estimatedtime = estimatedtime;
        this.status = status;
        this.priority = priority;
        this.type = type;
        this.description = description;
        this.startDate = startDate;
        this.endDate  = endDate;
        
    }

    public Task(int taskID, int estimatedtime, Statuss status, int priority, Type type, String description, Date startDate, Date endDate, Customer customer, User user, String taskName) {
        this.taskID = taskID;
        this.estimatedtime = estimatedtime;
        this.status = status;
        this.priority = priority;
        this.type = type;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.user = user;
        this.taskName = taskName;
    }

    
    
    @Override
    public String toString() {
        return "Task{" + "status=" + status + ", priority=" + priority + ", type=" + type + ", customer=" + customer + ", taskName=" + taskName + '}';
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

    public Statuss getStatus() {
        return status;
    }

    public void setStatus(int Statuss) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    
}
