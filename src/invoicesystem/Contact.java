/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author hassanmessaoudi
 */
public class Contact {
    
    private String customerCompanyName;
    private String invoiceAddress;
    private String contactFirstName;
    private String contactLastName;
    private String contactEmailAddress;
    private String contactPhoneNum;
    private String notes;
    private Map<String, Integer> workLocations; //key= contact's loc, val= distance in km
    private Map<String, Float> standardRates; // key= shiftName, val= shiftRate
    private int vat;
    private float travelAllowance; //Allowance per km

    public Contact(String customerCompanyName) {
        if(InvoiceSystem.getCustomerCompanyNames().contains(customerCompanyName)){
            throw new IllegalArgumentException(customerCompanyName);
        } else {
            this.customerCompanyName = customerCompanyName;
        }
    }

    @Override
    public String toString() {
        return getCustomerCompanyName();
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactEmailAddress() {
        return contactEmailAddress;
    }

    public void setContactEmailAddress(String contactEmailAddress) {
        this.contactEmailAddress = contactEmailAddress;
    }

    public String getContactPhoneNum() {
        return contactPhoneNum;
    }

    public void setContactPhoneNum(String contactPhoneNum) {
        this.contactPhoneNum = contactPhoneNum;
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

    public Map<String, Float> getStandardRates() {
        return standardRates;
    }

    public void setStandardRates(Map<String, Float> standardRates) {
        this.standardRates = standardRates;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public float getTravelAllowance() {
        return travelAllowance;
    }

    public void setTravelAllowance(float travelAllowance) {
        this.travelAllowance = travelAllowance;
    }
    
    

   
            
            
            
    
}
