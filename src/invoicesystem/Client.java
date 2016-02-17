/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
   
    //maybe move into a separate object
    private Map<String, Double> standardRates; // key= shiftName, val= shiftRate
    private Map<String, Map<String, LocalTime>> standardWorkingHours;
    private Map<String, Integer> standardRestBreaks;
    
    private int vat;
    private double travelAllowance; //Allowance per km
    private final InvoiceSystem invoiceSystem = InvoiceSystem.getInstance();

    
    //*************************************************************************
    //      CONSTRUCTORS
    
    public Client(String companyName) {
        try{ 
            if(Validation.isNotNull(companyName) && 
               Validation.isNotEmpty(companyName)){
                locations = new HashMap<>();
                this.companyName = companyName;
                createMockMaps();
                putEntryInMap(getClients(), companyName, this);
            }
        }
        catch(Exception e){
            throw e;
        }
    }
    
    //*************************************************************************
    //      SIMPLE GETTERS AND SETTERS
    
    private void createMockMaps(){  
        LocalTime startTime, endTime;
        Map<String, LocalTime> workingHours;
        HashMap<String, Double> ratesMap;
        standardRates = new HashMap<>();
        ratesMap = new HashMap<>();
        workingHours = new HashMap<>();
        standardWorkingHours = new HashMap<>();
        
        standardRestBreaks = new HashMap<>();
        
        //stdRates
        ratesMap.put("Dag", 60.00);
        setStandardRates(ratesMap);
        ratesMap.put("Nacht", 80.00);
        setStandardRates(ratesMap);
        
        //stdWorkingHours
        startTime = LocalTime.of(8, 00);
        endTime = LocalTime.of(17, 00);
        workingHours.put("start", startTime);
        workingHours.put("end", endTime);
        standardWorkingHours.put("Dag", workingHours);
        
        workingHours = new HashMap<>();
        startTime = LocalTime.of(23, 00);
        endTime = LocalTime.of(8, 00);
        workingHours.put("start", startTime);
        workingHours.put("end", endTime);
        standardWorkingHours.put("Nacht", workingHours);
        
        //standardRestBreaks
        standardRestBreaks.put("Dag", 60);
        standardRestBreaks.put("Nacht", 90);

    }
   
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
    public double getDefaultRate (String shift){
        if(getStandardRates().get(shift) != null){
            return getStandardRates().get(shift);
        }
        else{
            throw new IllegalArgumentException(shift + "  is currently "
                    + "not a valid shift to choose a default rate from. "
                    + "Please create it or choose from one "
                    + "of the following shifts: XXXX");
        }    
    }
    
    private Map<String, Double> getStandardRates() {
        return standardRates;
    }

    public Client setStandardRates(Map<String, Double> standardRates) {
        this.standardRates = standardRates;
        return this;
    }

    public LocalTime getDefaultStartTime(String shift){
        if(getStandardWorkingHours(shift).get("start") != null){
            return getStandardWorkingHours(shift).get("start");
        } 
        else {
            throw new IllegalArgumentException(shift + " does not contain "
                    + "start time.");
        }
    }
    
    public LocalTime getDefaultEndTime(String shift){
        if(getStandardWorkingHours(shift).get("end") != null){
            return getStandardWorkingHours(shift).get("end");
        } 
        else{
            throw new IllegalArgumentException(shift + " does not contain "
                    + "end time.");
        }
    }
    
    public int getDefaultRestBreak(String shift){
        if(getStandardRestBreaks().get(shift) != null){
            return getStandardRestBreaks().get(shift);
        }
        else {
            throw new IllegalArgumentException(shift + "  is currently "
                    + "not a valid shift to choose a default rest break from. "
                    + "Please create it or choose from one "
                    + "of the following shifts: XXXX");
        }
    }
    private Map<String, Integer> getStandardRestBreaks(){
        return standardRestBreaks;
    }
    
    private Map<String, LocalTime> getStandardWorkingHours(String shift){
        if(standardWorkingHours.get(shift) != null){
            return standardWorkingHours.get(shift);
        }
        else {
            throw new IllegalArgumentException(shift + " is currently "
                    + "not a valid shift to choose default working hours from. "
                    + "Please create it or choose from one "
                    + "of the following shifts: XXXX"); 
        }
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
    
    public void createNewLocation(String desc, String streetName, 
            String streetNumber, String zipCode, String city, 
            int distanceFromHome){
        
        try{
            Location location; 
            location = new Location(desc, streetName, streetNumber, zipCode, 
                    city, distanceFromHome);
            putLocationInLocations(location.getDesc(), location);
        
        }
        catch(Exception e){
            throw e;
        }
        
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
