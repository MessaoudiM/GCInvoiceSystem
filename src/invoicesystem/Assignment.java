/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Mohamed Messaoudi
 * @date 9 februari 2016
 */
public class Assignment {
    
    private Client client;
    private double rate;
    private LocalDate assignmentDate;
    private LocalTime startTime, endTime;
    private LocalDateTime startDateTime, endDateTime;
    private Map<Double, Map<LocalTime, LocalTime>> hoursMappedToRate;
    private String shift;
    private Location location;
    
     
    //*************************************************************************
    //     constructors
   
    public Assignment(Client client, LocalDate assignmentDate, LocalTime startTime, 
                      LocalTime endTime, String shift, double rate,
                      String workLocation, String companyName){
        try{
            setClient(client, companyName);
            this.shift = shift;
            //setDefaultRate(shift);
            setRate(shift, rate);
            setLocation(workLocation);
            setPeriod(assignmentDate, startTime, endTime);
        }
        catch(Exception e){
            throw e;
        }
    }
       
    
        /**
         * 
         * @param client
         * @param startTime
         * @param endTime
         * @param shift
         * @param workLocation
         * @param hoursMappedToRate 
         */
    public Assignment(Client client, LocalDate assignmentDate, LocalTime startTime, 
                      LocalTime endTime, String shift, double rate, 
                      String workLocation, 
                      Map<Double, Map<LocalTime, LocalTime>> 
                              hoursMappedToRate, String companyName){
         
         this(client, assignmentDate, startTime, endTime, shift, rate, 
                 workLocation, companyName);
         this.hoursMappedToRate = hoursMappedToRate;
     }
    
    //*************************************************************************
    //      SIMPLE GETTERS AND SETTERS
   
    

    public Client getClient() {
        return client;
    }

    
    
    public void createClient(String companyName){
        this.client = new Client(companyName);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(String shift, double rate) {
        if(rate == 0.0) {
            this.rate = client.getDefaultRate(shift);
        } else {
            this.rate = rate;
        }
    }
    
   

    public LocalTime getStartDateTime() {
        return startTime;
    }

    public void setStartDateTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndDateTime() {
        return endTime;
    }

    public void setEndDateTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Map<Double, Map<LocalTime, LocalTime>> getHoursMappedToRate() {
        return hoursMappedToRate;
    }

    /**
     *
     * @param hoursMappedToRate
     */
    public void setHoursMappedToRate(Map<Double, Map<LocalTime, 
            LocalTime>> hoursMappedToRate) {
        this.hoursMappedToRate = hoursMappedToRate;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
    // DOES THIS METHOD BELONG IN HERE OR IN Client.java
   //private void setDefaultRate(String shift){
   //    this.rate = getClient().getStandardRates().get(shift);
   //}

    private void getRateDifferentiatedHours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    //*************************************************************************
    //      SETTERS WITH VALIDATION
    
     private void setPeriod(LocalDate assignmentDate, LocalTime startTime, 
        LocalTime endTime){
        
        startDateTime = LocalDateTime.of(assignmentDate, startTime);
        endDateTime = LocalDateTime.of(assignmentDate, endTime);
        if(startTime == null && endTime != null) {
            throw new IllegalArgumentException("Must supply end time.");
        }
        if(startTime != null && endTime == null){
            throw new IllegalArgumentException("Must supply start time.");
        }
        if(startTime == null && endTime == null){
            try{
                startTime = client.getDefaultStartTime(shift);
                endTime = client.getDefaultEndTime(shift);
            }
            catch(Exception e){
                throw e;
            }
        }
        
        if(startDateTime.isBefore(endDateTime)){
            this.startTime = startTime;
            this.endTime = endTime;
        }
        else {
            throw new IllegalArgumentException(
                    "The time and/or date of the ending of the shift ("+
                            endTime + ")is before the start of the shift (" +
                            startTime + ").");
        }
    }
     
     public void setHoursMappedToRate(double rate, LocalTime startTime, 
            LocalTime endTime){
        Map<LocalTime, LocalTime> period;
        
        if(hoursMappedToRate == null){
            hoursMappedToRate = new HashMap<>();
        }
        period = new HashMap<>();
        period.put(startTime, endTime);
        hoursMappedToRate.put(rate, period);
    }
    
     public void setClient(Client client, String companyName) {
        if(client == null){
            createClient(companyName);
        } else {
            this.client = client;
        }
    }
    
    public void setLocation(String workLocation){
        if(workLocation == null){
            if(client.getDefaultLocation() != null){
                this.location = client.getDefaultLocation(); 
            }
        }
        else {
            this.location = client.getLocations().get(workLocation);
        }
    }
    
    //*************************************************************************
    //      RE-USABLE VALIDATORS
   
   
   
   
}
