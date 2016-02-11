/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Mohamed Messaoudi
 * @date 9 februari 2016
 */
public class Assignment {
    
    private Contact contact;
    private double rate;
    private LocalDateTime startDateTime, endDateTime;
    private Map<Double, Map<LocalDateTime, LocalDateTime>> hoursMappedToRate;
    private String shift;
    private final Location workLocation;
    
    public Assignment(Contact contact, LocalDateTime startDateTime, 
                      LocalDateTime endDateTime, String shift, 
                      Location workLocation, 
                      Map<Double, Map<LocalDateTime, LocalDateTime>> 
                              hoursMappedToRate){
         
         this(contact, startDateTime, endDateTime, shift, workLocation);
         this.hoursMappedToRate = hoursMappedToRate;
     }
    
    public Assignment(Contact contact, LocalDateTime startDateTime, 
                      LocalDateTime endDateTime, String shift, 
                      Location workLocation ){
        
        this.contact = contact;
        this.shift = shift;
        setDefaultRate(shift);
        setPeriod(startDateTime, endDateTime);
        this.workLocation = workLocation;
        
    }
    
    private void setPeriod(LocalDateTime startDateTime, 
            LocalDateTime endDateTime){
        
        if(startDateTime.isBefore(endDateTime)){
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
        }
        else {
            throw new IllegalArgumentException(
                    "The time and/or date of the ending of the shift ("+
                            endDateTime + ")is before the start of the shift (" +
                            startDateTime + ").");
        }
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
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

    public Map<Double, Map<LocalDateTime, LocalDateTime>> getHoursMappedToRate() {
        return hoursMappedToRate;
    }

    /**
     *
     * @param hoursMappedToRate
     */
    public void setHoursMappedToRate(Map<Double, Map<LocalDateTime, 
            LocalDateTime>> hoursMappedToRate) {
        this.hoursMappedToRate = hoursMappedToRate;
    }

    public void setHoursMappedToRate(double rate, LocalDateTime startTime, 
            LocalDateTime endTime){
        Map<LocalDateTime, LocalDateTime> period;
        
        if(hoursMappedToRate == null){
            hoursMappedToRate = new HashMap<>();
        }
        period = new HashMap<>();
        period.put(startTime, endTime);
        hoursMappedToRate.put(rate, period);
    }
    
    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
   private void setDefaultRate(String shift){
       this.rate = getContact().getStandardRates().get(shift);
   }

    private void getRateDifferentiatedHours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}
