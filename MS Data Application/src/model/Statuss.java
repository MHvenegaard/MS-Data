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
        
    private String statussName;

    public Statuss(String statusName) {
        this.statussName = statussName;
    }

    @Override
    public String toString() {
        return statussName;
    }
    
}
