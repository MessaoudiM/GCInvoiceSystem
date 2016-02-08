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
 * @author hassanmessaoudi
 */
public class Assignment {
    
    private Contact contact;
    private float rate;
    private LocalDateTime startDateTime, endDateTime;
    private Map<Float, Map<LocalDateTime, LocalDateTime>> hoursMappedToRate;
    private String shift;
    
    public Assignment(Contact contact, float rate, LocalDateTime startDateTime, 
                      LocalDateTime endTime, String shift){
        
        this.contact = contact;
        this.rate = rate;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.shift = shift;
    
    }

    
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
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

    public Map<Float, Map<LocalDateTime, LocalDateTime>> getHoursMappedToRate() {
        return hoursMappedToRate;
    }

    public void setHoursMappedToRate(Map<Float, Map<LocalDateTime, LocalDateTime>> hoursMappedToRate) {
        this.hoursMappedToRate = hoursMappedToRate;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
   
    
}
