/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.util.Map;
//import java.util.HashMap;
//import java.util.List;
//import java.util.LinkedList;
//import java.math.BigDecimal;
/**
 *
 * @author hassanmessaoudi
 */
public class Contact {
    
    private String companyName;
    private final Location location;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNum;
    private String notes;
    

    
//move into a separate object
    private Map<String, Double> standardRates; // key= shiftName, val= shiftRate
    private int vat;
    private double travelAllowance; //Allowance per km

    public Contact(String companyName) {
        //DOUBLY CHECKED IN InvoiceSystem.createContact()
        if(InvoiceSystem.getCompanies().containsKey(companyName)){
            throw new IllegalArgumentException(companyName + 
                    " already exists in list of companies.");
        } else {
            this.companyName = companyName;
            //InvoiceSystem.getCompanies().put(companyName, this);
            putContactInCompaniesList();
        }
        location = new Location();
    }
    
    private void putContactInCompaniesList(){
        //change so that invoicesystem itself performs this function
        // with validation done in invoicesystem
        InvoiceSystem.getCompanies().put(getCompanyName(), this);
    }

    @Override
    public String toString() {
        return getCompanyName();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        
        //SPLIT UP IN MULTIPLE METHODS
        
        if(this.getCompanyName().equals(companyName)){
            throw new IllegalArgumentException(companyName + 
                    " is the same as its current name.");
        }
        // Check to see if the new name exists in InvoiceSystem.companies
        if(InvoiceSystem.getCompanies().containsKey(companyName)){
            throw new IllegalArgumentException(companyName + 
                    " already exists in list of companies.");
        } 
        else {
            String oldCompanyName = this.companyName;
            this.companyName = companyName;
            InvoiceSystem.getCompanies().remove(oldCompanyName, this);
            
            // Check to see if the old companyName has been removed
            if (InvoiceSystem.getCompanies().containsKey(oldCompanyName)){
                throw new IllegalStateException(oldCompanyName + 
                        " should not exist in InvoiceSystem.companies");
            } 
            else {
                InvoiceSystem.getCompanies().put(companyName, this);
            }
        }
    }
    
    /*
    public String getInvoiceAddress() {
        return invoiceAddress();
    }
    
    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }*/
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.trim().length() != 0){
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Field: first name, is empty.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.trim().length() != 0){
            this.lastName = lastName;
        }
        else{
            throw new IllegalArgumentException("Field: last name, is empty.");
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        if(emailAddress.trim().length() != 0){
            if(emailAddress.contains("@")&&emailAddress.contains(".")){
                this.emailAddress = emailAddress;
            } 
            else {
                throw new IllegalArgumentException("Invalid format of "
                        + "emailaddress");
            }
        } 
        else{
            throw new IllegalArgumentException("Field: email address, "
                    + "is empty");
        }
    }
       
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

   

    public Map<String, Double> getStandardRates() {
        return standardRates;
    }

    public void setStandardRates(Map<String, Double> standardRates) {
        this.standardRates = standardRates;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    /**
     *
     * @return double
     */
    public double getTravelAllowance() {
        return travelAllowance;
    }

    /**
     *
     * @param travelAllowance
     */
    public void setTravelAllowance(double travelAllowance) {
        this.travelAllowance = travelAllowance;
       
    }
}
