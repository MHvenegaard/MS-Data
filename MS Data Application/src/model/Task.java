package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
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
    private ArrayList<Task> taskList;
    private ArrayList<User> userOnTask;

    /**
     * Creates an objekt of Task, used to update task in DB.
     *
     * @param taskID
     * @param parentID
     * @param taskName
     * @param type
     * @param status
     * @param customer
     * @param user
     * @param startDate
     * @param endDate
     * @param estimatedtime
     * @param priority
     * @param description
     * @param userOnTask
     */
    public Task(int taskID, int parentID, String taskName, Type type, Statuss status, Customer customer, User user, Date startDate, Date endDate, int estimatedtime, int priority, String description, ArrayList<User> userOnTask) {
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
        taskList = new ArrayList<>();
        this.userOnTask = new ArrayList<>();
    }

    /**
     * Creates an objekt of Task, used to create new record in DB.
     *
     * @param taskName
     * @param type
     * @param status
     * @param customer
     * @param user
     * @param startDate
     * @param endDate
     * @param estimatedtime
     * @param priority
     * @param description
     */
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
        taskList = new ArrayList<>();
    }

    /**
     * Creates an objekt of Task, used to create record of Task with connection
     * to another task.
     *
     * @param taskName
     * @param parentID
     * @param type
     * @param status
     * @param customer
     * @param user
     * @param startDate
     * @param endDate
     * @param estimatedtime
     * @param priority
     * @param description
     */
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
        taskList = new ArrayList<>();
    }

    /**
     * @return - taskID
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     * @param taskID
     */
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    /**
     * @return - estimatedtime
     */
    public int getEstimatedtime() {
        return estimatedtime;
    }

    /**
     * @param estimatedtime
     */
    public void setEstimatedtime(int estimatedtime) {
        this.estimatedtime = estimatedtime;
    }

    /**
     * @return - status
     */
    public Statuss getStatus() {
        return status;
    }

    /**
     * @param Statuss
     */
    public void setStatusByID(int Statuss) {
        this.status = status.getStatusByID(Statuss);
    }

    /**
     * @return - priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return - type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return - description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return - startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return - endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return - customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return - user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return - taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return - taskList
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * @param taskList
     */
    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * @return - parentID
     */
    public int getParentID() {
        return parentID;
    }

    /**
     * @param parentID
     */
    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    /**
     * @return - userOnTask
     */
    public ArrayList<User> getUserOnTask() {
        return userOnTask;
    }

    /**
     * @param userOnTask
     */
    public void setUserOnTask(ArrayList<User> userOnTask) {
        this.userOnTask = userOnTask;
    }

    /**
     * Adds user to task
     *
     * @param user
     */
    public void addToUserOnTask(User user) {
        userOnTask.add(user);
    }

    /**
     * Removes user from task
     *
     * @param user
     */
    public void removeUserOnTask(User user) {
        userOnTask.remove(user);
    }

    /**
     * @return - taskID
     */
    @Override
    public String toString() {
        return "" + taskID;
    }

}
