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
    
    
     public TimeSpentOnTask(int userID,int taskID, int timeSpent){
        this.timeSpent = timeSpent;
        this.userID = userID;
        this.taskID = taskID;
    }
    
    public TimeSpentOnTask(int userID,int taskID){
        timeSpent = 0;
        this.userID = userID;
        this.taskID = taskID;
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
    
    
    
}
