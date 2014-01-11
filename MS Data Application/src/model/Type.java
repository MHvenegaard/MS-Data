/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marc
 */
public class Type {

    private int typeID;
    private String typeName;


    public Type(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    
        
    public Type(String typeName) {
       this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
}
