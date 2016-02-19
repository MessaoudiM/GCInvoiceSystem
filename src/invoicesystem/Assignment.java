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
   
    public Assignment(Client client, LocalDate startDate, LocalDate endDate, LocalTime startTime, 
                      LocalTime endTime, String shift, double rate,
                      String workLocation, String companyName){
        try{
            setClient(client, companyName);
            setShift(shift);
            //setDefaultRate(shift);
            setRate(shift, rate);
            setLocation(workLocation);
            setPeriod(startDate, endDate, startTime, endTime);
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
    public Assignment(Client client, LocalDate startDate, LocalDate endDate, LocalTime startTime, 
                      LocalTime endTime, String shift, double rate, 
                      String workLocation, 
                      Map<Double, Map<LocalTime, LocalTime>> 
                              hoursMappedToRate, String companyName){
         
         this(client, startDate, endDate, startTime, endTime, shift, rate, 
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

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
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
    
     public void setPeriod(LocalDate startDate, LocalDate endDate, LocalTime startTime, 
        LocalTime endTime){
        try{
            isNotEmptyStartDate(startDate);
            isNotEmptyOneOrOtherOfTime(startTime, endTime);
            if(startTime == null && endTime == null){
                setPeriodFromDefaultWorkingHours(startDate, endDate);
            }
            else {
                setPeriodFromUserInput(startDate, endDate, startTime, endTime);
            }
        }
        catch(Exception e){
            throw e;
        }
    }

    private void setPeriodFromDefaultWorkingHours(LocalDate startDate, 
            LocalDate endDate){
  
        LocalTime startTime, endTime;
        
        try{
            if(endDate == null){
                endDate = startDate;
            }

            startTime = client.getDefaultStartTime(getShift());
            endTime = client.getDefaultEndTime(getShift());

                //TODO:
                //CHECK IF PERIOD BETWEEN STARTDATETIME-ENDDATETIME
                //SPANS MULTIPLE DAYS AND ACT ACCORDINGLY
            
            this.startDateTime = LocalDateTime.of(startDate, startTime);
            if(startDateTime.isAfter(endDateTime)){
                // wrap around midnight
                this.endDateTime = 
                        LocalDateTime.of(endDate, endTime).plusDays(1);
            } else {
                this.endDateTime = LocalDateTime.of(endDate, endTime);
            }
        }
        catch(Exception e){
            throw e;
        }
    }
    
    private void setPeriodFromUserInput(LocalDate startDate, LocalDate endDate, 
            LocalTime startTime, LocalTime endTime){
        
        try{
            if(endDate == null){
                endDate = startDate;
            }
            EndDateTimeIsNotBeforeStartDateTime(
                    LocalDateTime.of(startDate, startTime), 
                    LocalDateTime.of(endDate, endTime));
        }
        catch(Exception e){
            throw e;
        }   
    }
    
    private void EndDateTimeIsNotBeforeStartDateTime(
            LocalDateTime startDateTime, LocalDateTime endDateTime){
       
        if(startDateTime.isBefore(endDateTime)){
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
            //TODO:
            //1.CHECK IF PERIOD BETWEEN STARTDATETIME-ENDDATETIME
            //SPANS MULTIPLE DAYS (more than 2) AND ACT ACCORDINGLY
            //2.GIVE USER AT THIS POINT THE POSSIBILITY TO ADD THIS 
            //PERIOD IN AS A SHIFT FOR THIS CLIENT
        }
        else {
            throw new IllegalArgumentException("The time and/or date of the "
                    + "ending of the shift ("+ endDateTime + ")is before the start"
                    + " of the shift (" + startDateTime + ").");
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
            this.location = client.getLocations(String workLocation);
            //this.location = client.findLocation(workLocation);
            //this.location = client.getLocations().get(workLocation);
        }
    }
    
    //*************************************************************************
    //      RE-USABLE VALIDATORS
   
    private boolean isNotEmptyOneOrOtherOfTime(LocalTime startTime, 
            LocalTime endTime){
        if(startTime == null && endTime != null) {
            throw new IllegalArgumentException("Start time cannot be empty.");
        }
        if(startTime != null && endTime == null){
            throw new IllegalArgumentException("End time cannot be empty.");
        }
        return true;
    }
   
     private boolean isNotEmptyStartDate(LocalDate startDate){
        if(startDate == null){
            throw new IllegalArgumentException("Start date cannot be empty.");
        } 
        else {
            return true;
        }
    }
}
