/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package US001;

import invoicesystem.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.hamcrest.CoreMatchers.*;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Mohamed Messaoudi
 * @date 10 februari 2016
 */
public class TestAssignment {
    
    Contact contact;
    Assignment assignment;
    
    @Before
    public void setUp(){
    //-----------------------------------------------------------------
        //  CREATE CONTACT
        contact = new Contact("Test Inc.");
        contact.setEmailAddress("test@testinc.com");
        contact.setFirstName("John");
        contact.setLastName("Wayne");
        contact.setPhoneNum("555-12345");
        //contact.setCompanyName(customerCompanyName);
        contact.setInvoiceAddress("Street 1 /nPC 1234/nCity");
        contact.setNotes("Nothing");
        contact.setTravelAllowance(1.20);
        contact.setVat(21);
        
        Map<String, Double> ratesMap;
        ratesMap = new HashMap<>();
        String shift = "Dag";
        double rate = 50.00;
        ratesMap.put(shift, rate);
        shift = "Nacht";
        rate = 80.00;
        ratesMap.put(shift, rate);
        contact.setStandardRates(ratesMap);
        
        Map<String, Integer> workLocations = new HashMap<>();
        workLocations.put("Schans", 0);
        contact.setWorkLocations(workLocations);
        //-----------------------------------------------------------------
        LocalDateTime startTime, endTime;
        startTime = LocalDateTime.of(2016, 12, 8, 8, 30);
        endTime = LocalDateTime.of(2016, 12, 8, 17, 0);
        shift = "Dag";
        
        assignment = new Assignment(contact, startTime, endTime, shift);
    }
    
    @After
    public void tearDown(){
        contact = null;
        assignment = null;
        InvoiceSystem.getCompanies().clear();
    }
    
    @Test
    public void testGetContact(){
        assertEquals("Test Inc.", assignment.getContact().getCompanyName());
    }
    
    @Test
    public void testGetStartTime(){}
    
    @Test
    public void testGetStartTimeYear(){}
    
    @Test
    public void testGetStartTimeMonth(){}
    
    @Test
    public void testGetStartDayOfWeek(){}
    
    @Test
    public void testGetStartTimeHour(){}
    
    @Test
    public void testGetStartTimeMinutes(){}
    
    @Test
    public void testGetEndTime(){}
    
    @Test
    public void testGetEndTimeYear(){}
    
    @Test
    public void testGetEndTimeMonth(){}
    
    @Test
    public void testGetEndTimeDayOfWeek(){}
    
    @Test
    public void testGetEndTimeHour(){}
    
    @Test
    public void testGetEndTimeMinutes(){}
    
    @Test
    public void testGetRate(){}
    
    @Test
    public void testGetShift(){}
    
}
