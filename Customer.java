/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05160000241_05160000163;

/**
 *
 * @author Göksenin
 */
public class Customer {
    private int CustomerID;
    private String Name;
    private String Surname;

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * @param Surname the Surname to set
     */
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public Customer() {
        this.CustomerID = 0;
        this.Name = "No Name";
        this.Surname = "No Surname ";
    }

    public Customer(int CustomerID, String Name, String Surname) {
        this.CustomerID = CustomerID;
        this.Name = Name;
        this.Surname = Surname;
    }
    public Customer (Customer originalCustomer){
    this.CustomerID = originalCustomer.CustomerID;
    this.Name = originalCustomer.Name;
    this.Surname = originalCustomer.Surname;
    }

    @Override
    public String toString() {
        return "Müşteri Numarası: "+ this.CustomerID+" Müşterinin adı: "+this.Name+
                " "+this.Surname;
    }
    
   
}
