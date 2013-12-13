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
    private String Address;
    private String country;
   
    
    public Customer(String companyName) {
        this.companyName = companyName;
    }

    public Customer(int idCustomer, String companyName, int phone, String Address, String country) {
        this.idCustomer = idCustomer;
        this.companyName = companyName;
        this.phone = phone;
        this.Address = Address;
        this.country = country;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

   
    
    
    
}
