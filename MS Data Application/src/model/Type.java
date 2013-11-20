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

    private String typeName;
    
    public Type(String typeName) {
       this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
    
}
