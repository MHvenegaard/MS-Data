/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marc
 */
public class TimeSpentOnTask {
    
    private int timeSpent;
    private int userID;
    private int taskID;
    private String comment;
    
    
     public TimeSpentOnTask(int taskID,int userID, int timeSpent, String comment){
        this.timeSpent = timeSpent;
        this.userID = userID;
        this.taskID = taskID;
        this.comment = comment;
    }
     
     public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
}
