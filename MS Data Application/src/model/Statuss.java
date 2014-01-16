package model;

import handlers.Controller;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class Statuss {

    private int statusID;
    private String statussName;

    /**
     * Creates an objekt of Statuss
     * @param statusID
     * @param statussName 
     */
    public Statuss(int statusID, String statussName) {
        this.statusID = statusID;
        this.statussName = statussName;
    }

    /**
     * @return - statusID
     */
    public int getStatusID() {
        return statusID;
    }

    /**
     * @param statusID 
     */
    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    /**
     * @return - statussName
     */
    public String getStatussName() {
        return statussName;
    }

    /**
     * @param statussName 
     */
    public void setStatussName(String statussName) {
        this.statussName = statussName;
    }

    /**
     * Returns Statuss s, found in the complete list of Status' with the given ID
     * @param ID
     * @return - Statuss s
     */
    public Statuss getStatusByID(int ID) {
        Statuss s = null;
        for (int i = 0; i < Controller.statusList.size(); i++) {
            if (Controller.statusList.get(i).getStatusID() == ID) {
                s = Controller.statusList.get(i);
            }
        }
        return s;
    }
}
