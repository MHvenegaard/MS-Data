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
    private String description;

    public Type(int typeID, String typeName, String description) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
