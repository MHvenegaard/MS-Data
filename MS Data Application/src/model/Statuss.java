/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Mikkel
 */
public class Statuss {
    
    private int statusID;
    private String statussName;
    private String description;

    public Statuss(String statusName) {
        this.statussName = statussName;
    }

    @Override
    public String toString() {
        return statussName;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatussName() {
        return statussName;
    }

    public void setStatussName(String statussName) {
        this.statussName = statussName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
