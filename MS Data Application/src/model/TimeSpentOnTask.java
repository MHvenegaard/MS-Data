package model;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class TimeSpentOnTask {

    private int timeSpent;
    private int userID;
    private int taskID;
    private String comment;

    /**
     * Creates an objekt of TimeSpentOnTask
     * @param taskID
     * @param userID
     * @param timeSpent
     * @param comment
     */
    public TimeSpentOnTask(int taskID, int userID, int timeSpent, String comment) {
        this.timeSpent = timeSpent;
        this.userID = userID;
        this.taskID = taskID;
        this.comment = comment;
    }

    /**
     * Creates an objekt of TimeSpentOnTask
     * @param userID
     */
    public TimeSpentOnTask(int userID) {
        this.userID = userID;
        this.timeSpent = 0;
        this.comment = "";
    }

    /**
     * Creates an objekt of TimeSpentOnTask
     * @param userID
     * @param timeSpent
     * @param comment 
     */
    public TimeSpentOnTask(int userID, int timeSpent, String comment) {
        this.userID = userID;
        this.timeSpent = timeSpent;
        this.comment = comment;
    }

    /**
     * @return - timeSpent
     */
    public int getTimeSpent() {
        return timeSpent;
    }

    /**
     * @param timeSpent 
     */
    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    /**
     * @return - userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID 
     */
    public void setUserID(int userID) {
        this.userID = userID;
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
     * @return - comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
