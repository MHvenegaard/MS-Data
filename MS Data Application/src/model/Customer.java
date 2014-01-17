package model;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class Customer {

    private int customerID;
    private int phone;
    private String companyName;
    private String CVR;

    /**
     * Creates an object of Customer
     *
     * @param idCustomer
     * @param companyName
     * @param phone
     * @param CVR
     */
    public Customer(int idCustomer, String companyName, int phone, String CVR) {
        this.customerID = idCustomer;
        this.companyName = companyName;
        this.phone = phone;
        this.CVR = CVR;
    }

    /**
     * @return - customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param idCustomer
     */
    public void setIdCustomer(int idCustomer) {
        this.customerID = idCustomer;
    }

    /**
     * @return - companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return - phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return - CVR
     */
    public String getCVR() {
        return CVR;
    }

    /**
     * @param CVR
     */
    public void setCVR(String CVR) {
        this.CVR = CVR;
    }

    /**
     * @return - companyName
     */
    @Override
    public String toString() {
        return companyName;
    }
}
