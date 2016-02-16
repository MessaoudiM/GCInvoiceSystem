/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hassanmessaoudi
 */
public class Client {
    private static Map<String, Client> clients = new HashMap<>();

    
    
    private String companyName;
    private Map<String, Location> locations;
    
    private Location defaultLocation;
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
    
    public Client(String companyName) {
        try{ 
            if(Validation.isNotNull(companyName) && 
               Validation.isNotEmpty(companyName)){
                this.companyName = companyName;
                putEntryInMap(getClients(), companyName, this);
                //putClientInClients(companyName);
                //location = new Location();
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
    
    private Client setCompanyName(String companyName){
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

    public Client setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
    }

    public String getNotes() {
        return notes;
    }

    public Client setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Map<String, Double> getStandardRates() {
        return standardRates;
    }

    public Client setStandardRates(Map<String, Double> standardRates) {
        this.standardRates = standardRates;
        return this;
    }

    public int getVat() {
        return vat;
    }

    public Client setVat(int vat) {
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
    public Client setTravelAllowance(double travelAllowance) {
        this.travelAllowance = travelAllowance;       
        return this;
    }
    
    public final Map<String, Client> getClients() {
        return clients;
    }

    /**
     *
     * @param clients
     */
    public Client setClients(Map<String, Client> clients) {
        Client.clients = clients;
        return this;
    }
    
    //returns default client location
    public Location getDefaultLocation(){
        return defaultLocation;
    }
    
    public Client setDefaultLocation(Location location){
        this.defaultLocation = defaultLocation;
        return this;
    }
    
    public Location findLocation(String location){
        return getLocations().get(location);
    }
    
    public Map<String, Location> getLocations(){
        return locations;
    }
    
    public void setLocations(Map<String, Location> locations){
        this.locations = locations;
    }
    
    public void putLocationInLocations(String desc, Location location){
        putEntryInMap(getLocations(), desc, location);
    }
    
    //*************************************************************************
    //      SETTERS WITH VALIDATION
    
    
    public Client setPersonsName(String personsName) {
        try {
            if (validatePersonsName(personsName)) {
                personsName = personsName.trim();
                this.personsName = personsName;
            }
            return this;
        } 
        catch (Exception e) {
            throw e;
        }
    }
    
    private boolean validatePersonsName(String personsName){
        try{
            if (Validation.isNotNull(personsName) && 
                Validation.isNotEmpty(personsName) &&
                Validation.hasNoInvalidCharacters(personsName)) {
            }
            return true;
        }
        catch(Exception e){
            throw e;
        }
    }
     
    public Client setEmailAddress(String emailAddress) {
        try{ 
            if(validateEmailAddress(emailAddress)){
                emailAddress = emailAddress.trim();
                this.emailAddress = emailAddress;
            }
            return this;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    private boolean validateEmailAddress(String emailAddress) {
        try{
            if(Validation.isNotNull(emailAddress) && 
                    Validation.isValidEmailAddress(emailAddress)){
            }
            return true;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public Client replaceCompanyName(String companyName) {
        try {
            String oldCompanyName = getCompanyName();
            if(validateCompanyName( companyName, oldCompanyName)) {
                    setCompanyName(companyName);
                    getClients().remove(oldCompanyName, this);
                    putEntryInMap(getClients(), companyName, this);
            }
            return this;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    private boolean validateCompanyName(String companyName, 
            String oldCompanyName){
        try{
            if( Validation.isNotNull(companyName) && 
                    Validation.isNotEmpty(companyName) &&
                    Validation.isNotSame(companyName, oldCompanyName) &&
                    isNotInMap(getClients(), companyName)) {
            }
            return true;
        }
        catch(Exception e){
            throw e;
        }
    }

    /*  private Client putClientInClients(String companyName){
    try{
    if(isNotInMap(getClients(), companyName)){
    getClients().put(companyName, this);
    }
    return this;
    }
    catch(IllegalArgumentException e){
    throw e;
    }
    }
    */
    //*************************************************************************
    //   RE-USABLE METHODS
    
    private Client putEntryInMap(Map map, String key, Object value){
        try{
            if(isNotInMap(map, key)){
                map.put(key, value);
            }
            return this;
        }
        catch(IllegalArgumentException e){
            throw e;
        }
    }
    
    //*************************************************************************
    //      RE-USABLE VALIDATORS
    
    private boolean isNotInMap(Map map, String key){
        if(map.containsKey(key)){
            throw new IllegalArgumentException(key
                    + " already exists.");
        }
        return true;
    }
    
    
}
