/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marc
 */
public class Task {

    private int taskID;
    private int estimatedtime;
    private int priority;
    private int parentID;
    private Statuss status;
    private Type type;
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private User user;
    private String taskName;
    private String description;
    private ArrayList<TaskComment> commentList;
    private ArrayList<Task> taskList;

    public Task(int taskID,int parentID, String taskName, Type type, Statuss status, Customer customer, User user, Date startDate, Date endDate, int estimatedtime, int priority, String description) {
        this.taskID = taskID;
        this.parentID = parentID;
        this.taskName = taskName;
        this.type = type;
        this.status = status;
        this.customer = customer;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.estimatedtime = estimatedtime;
        this.priority = priority;
        this.description = description;
        commentList = new ArrayList<>();
        taskList = new ArrayList<>();
    }

    public Task(String taskName, Type type, Statuss status, Customer customer, User user, Date startDate, Date endDate, int estimatedtime, int priority, String description) {
        this.taskName = taskName;
        this.type = type;
        this.status = status;
        this.customer = customer;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.estimatedtime = estimatedtime;
        this.priority = priority;
        this.description = description;
        commentList = new ArrayList<>();
        taskList = new ArrayList<>();
    }
        //SubTask
        public Task(String taskName, int parentID, Type type, Statuss status, Customer customer, User user, Date startDate, Date endDate, int estimatedtime, int priority, String description) {
        this.taskName = taskName;
        this.parentID = parentID;
        this.type = type;
        this.status = status;
        this.customer = customer;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.estimatedtime = estimatedtime;
        this.priority = priority;
        this.description = description;
        commentList = new ArrayList<>();
        taskList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "" + taskID;
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

    public ArrayList<TaskComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<TaskComment> commentList) {
        this.commentList = commentList;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }
    
}
