/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.util.HashMap;
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
    private static Map<String, Contact> companies = new HashMap<>();

    
    
    private String companyName;
    private Location location;
    private String personsName;
    private String emailAddress;
    private String phoneNum;
    private String notes;
   
//move into a separate object
    private Map<String, Double> standardRates; // key= shiftName, val= shiftRate
    private int vat;
    private double travelAllowance; //Allowance per km
    private final InvoiceSystem invoiceSystem = InvoiceSystem.getInstance();

    
    //*************************************************************************
    //      CONSTRUCTORS
    
    public Contact(String companyName) {
        /*  if(companyName == null) {
        throw new NullPointerException(
        "Name = null in Contact constructor");
        }
        
        if(companyName.trim().length() == 0){
        throw new IllegalArgumentException("Company name cannot be empty");
        }
        */
    
        
        //if(getCompanies().containsKey(companyName)){
        //    throw new IllegalArgumentException(companyName +" already exists.");
        //}
        //else {
        
        /*if(isNotInCompanies(companyName)){
        this.companyName = companyName;
        location = new Location();
        putContactInCompanies(companyName);
        }             */
        
        try{ 
            if(isNotEmptyOrNull(companyName)){
                this.companyName = companyName;
                putContactInCompanies(companyName);
                location = new Location();
            }
        }
        catch(Exception e){
            throw e;
        }
    }
    
  
    //*************************************************************************
    //      SIMPLE GETTERS AND SETTERS
   
    @Override
    public String toString() {
        return getCompanyName();
    }

    public String getCompanyName() {
        return companyName;
    }
    
    private Contact setCompanyName(String companyName){
        this.companyName = companyName;
        return this;
    }
    
    public String getPersonsName() {
        return personsName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
  
    public String getPhoneNum() {
        return phoneNum;
    }

    public Contact setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
    }

    public String getNotes() {
        return notes;
    }

    public Contact setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Map<String, Double> getStandardRates() {
        return standardRates;
    }

    public Contact setStandardRates(Map<String, Double> standardRates) {
        this.standardRates = standardRates;
        return this;
    }

    public int getVat() {
        return vat;
    }

    public Contact setVat(int vat) {
        this.vat = vat;
        return this;
    }

    /*
    public String getInvoiceAddress() {
        return invoiceAddress();
    }
    
    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }*/
    
    
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
    public Contact setTravelAllowance(double travelAllowance) {
        this.travelAllowance = travelAllowance;       
        return this;
    }
    
    public final Map<String, Contact> getCompanies() {
        return companies;
    }

    /**
     *
     * @param companies
     */
    public Contact setCompanies(Map<String, Contact> companies) {
        Contact.companies = companies;
        return this;
    }
    
    //*************************************************************************
    //      SETTERS WITH VALIDATION
    
    
    public Contact setPersonsName(String personsName) {
        try {
            if (isNotEmptyOrNull(personsName) &&
                    hasNoInvalidCharacters(personsName)) {
                this.personsName = personsName;
            }
            return this;
        } catch (Exception e) {
            throw e;
        }
    }
     
    public Contact setEmailAddress(String emailAddress) {
        if(emailAddress.trim().length() != 0){
            if(emailAddress.contains("@")&&emailAddress.contains(".")){
                this.emailAddress = emailAddress;
                return this;
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
    
    public Contact replaceCompanyName(String companyName) {
        try {
            String oldCompanyName = getCompanyName();
            if( isNotEmptyOrNull(companyName) &&
                isNotSame(companyName, oldCompanyName) &&
                isNotInCompanies(companyName)) {
                    setCompanyName(companyName);
                    getCompanies().remove(oldCompanyName, this);
                    putContactInCompanies(companyName);
            }
            return this;
        }
        catch(Exception e){
            throw e;
        }
    }

    private Contact putContactInCompanies(String companyName){
        try{
            if(isNotInCompanies(companyName)){
                getCompanies().put(companyName, this);
            }
            return this;
        }
        catch(IllegalArgumentException e){
            throw e;
        }
    }
    
    //*************************************************************************
    //      RE-USABLE VALIDATORS
    
    private boolean isNotInCompanies(String companyName){
        if(getCompanies().containsKey(companyName)){
            throw new IllegalArgumentException(companyName
                    + " already exists.");
        }
        return true;
    }
    
    private boolean isNotEmptyOrNull(String name){
        if(name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Field cannot be empty.");
        }
        return true;
    }
    
    private boolean isNotSame(String newString, String oldString){
        if(oldString.equals(newString)){
            throw new IllegalArgumentException("Field : " + newString + 
                    "cannot be the same as its current value.");
        }
        return true;
    }

    private boolean hasNoInvalidCharacters(String personsName) {
        if(personsName.matches("[\\w\\s-.',]+")){
        //if(personsName.matches("^[\\p{L}]+$ .'-+")){
            return true;
        } else {
            throw new IllegalArgumentException("Valid characters include: "
                    + "space 0-9 A-Z a-z .,'-");
        }
    }
    
    
}



    //  END  END  END  END  END  END  END  END  END  END  END

  
    //*************************************************************************
    //      BUILDER
    
    
    /*
    public static class Builder{
    
    //Required parameters
    private String companyName;
    
    //Optional parameters
    private Location location;
    private String personsName;
    private String emailAddress;
    private String phoneNum;
    private String notes;
    
    //move into a separate object
    private Map<String, Double> standardRates; // key= shiftName, val= shiftRate
    private int vat;
    private double travelAllowance; //Allowance per km
    
    public Builder(String companyName){
    this.companyName = companyName;
    }
    
    public Builder personsName(String personsName){
    this.personsName = personsName;
    return this;
    }
    
    public Builder emailAddress(String emailAddress){
    this.emailAddress = emailAddress;
    return this;
    }
    
    public Builder phoneNum(String phoneNum){
    this.phoneNum = phoneNum;
    return this;
    }
    
    public Builder notes(String notes){
    this.notes = notes;
    return this;
    }
    
    public Builder vat(int vat){
    this.vat = vat;
    return this;
    }
    
    public Builder travelAllowance(double travelAllowance){
    this.travelAllowance = travelAllowance;
    return this;
    }
    
    public Builder locations (Location location){
    this.location = location;
    return this;
    }
    
    public Builder standardRates(Map<String, Double> standardRates){
    this.standardRates = standardRates;
    return this;
    }
    
    public Contact build(){
    return new Contact(this);
    }
    }
    
    private Contact(Builder builder){
    // Required parameters
    companyName = builder.companyName;
    
    //Optional parameters
    location = builder.location;
    personsName = builder.personsName;
    emailAddress = builder.emailAddress;
    phoneNum = builder.phoneNum;
    notes = builder.notes;
    
    //move into a separate object
    standardRates = builder.standardRates; // key= shiftName, val= shiftRate
    vat = builder.vat;
    travelAllowance = builder.travelAllowance; //Allow
    }
    */
    
