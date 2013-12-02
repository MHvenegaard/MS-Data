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
public class TaskComment {
    
private int taskCommentID;
private Task task;
private Date datetime;
private String comment;
private int hours;

    public TaskComment(Task task, int taskCommentID, Date datetime, String comment, int hours) {
        this.task = task;
        this.taskCommentID = taskCommentID;
        this.datetime = datetime;
        this.comment = comment;
        this.hours = hours;
    }

    public int getTaskCommentID() {
        return taskCommentID;
    }

    public void setTaskCommentID(int taskCommentID) {
        this.taskCommentID = taskCommentID;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    
    @Override
    public String toString() {
    String str = "Opgave: " +task.getTaskName() +", Timer: " +hours + ", Kommentar: "+comment;
    
    return str;
    }
    
}
