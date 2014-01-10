/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marc
 */
public class Customer {

    private int idCustomer;
    private int phone;
    private String companyName;
    private String CVR;
   
    
    public Customer(String companyName) {
        this.companyName = companyName;
    }

    public Customer(int idCustomer, String companyName, int phone, String CVR) {
        this.idCustomer = idCustomer;
        this.companyName = companyName;
        this.phone = phone;
        this.CVR = CVR;
    }
    
    

    @Override
    public String toString() {
        return companyName;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }



   
    
    
    
}
