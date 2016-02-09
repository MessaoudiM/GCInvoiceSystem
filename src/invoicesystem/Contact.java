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
    private String invoiceAddress;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNum;
    private String notes;
    private Map<String, Integer> workLocations; //key= contact's loc, 
                                                //val= distance in km
    private Map<String, Double> standardRates; // key= shiftName, val= shiftRate
    private int vat;
    private double travelAllowance; //Allowance per km

    public Contact(String companyName) {
        //DOUBLY CHECKED IN InvoiceSystem.createContact()
        if(InvoiceSystem.getCompanies()
                .containsKey(companyName)){
            throw new IllegalArgumentException(companyName);
        } else {
            this.companyName = companyName;
            //add to InvoiceSystem.companies (setCompanies pull push)
        }
        
        
    }

    @Override
    public String toString() {
        return getCompanyName();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        //CHECK WHETHER THIS ONE EXISTST IN InvoiceSystem.customerCompanies
        this.companyName = companyName;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public Map<String, Integer> getWorkLocations() {
        return workLocations;
    }

    public void setWorkLocations(Map<String, Integer> workLocations) {
        this.workLocations = workLocations;
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
     * @return
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
