/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author hassanmessaoudi
 */
public class AssignmentTest {
    
    private Client client;
    private Assignment assignment;
    private LocalDateTime startDateTime, endDateTime;
    private LocalDate startDate, endDate;
    private LocalTime startTime, endTime;
       
    
    public AssignmentTest() {
    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();
   
    @Before
    public void setUp() {
        createMockClient();
        createMockLocations();
        createMockAssignment();
    }
    
    private void createMockClient(){
    String companyName, personsName, emailAddress,
               phoneNum, notes, shift;
        double travelAllowance, rate;               
        int vat;
        Map<String, Double> ratesMap;     
    
        companyName = "Test Inc.";
        personsName = "John Wayne";
        emailAddress = "test@testinc.com";
        phoneNum = "555-12345";
        notes = "Nothing";
        travelAllowance = 1.20;
        vat = 21;
        
        client = new Client(companyName)
                .setEmailAddress(emailAddress)                            
                .setPersonsName(personsName)
                .setPhoneNum(phoneNum)
                .setNotes(notes)
                .setTravelAllowance(travelAllowance)
                .setVat(vat);
        
        
        ratesMap = new HashMap<>();
        shift = "Dag";
        rate = 50.00;
        ratesMap.put(shift, rate);
        shift = "Nacht";
        rate = 80.00;
        ratesMap.put(shift, rate);
        client.setStandardRates(ratesMap);
    }
    
    private void createMockLocations(){
        String workLocation;
        workLocation = "Praktijk de Schans";
        client.createNewLocation("Praktijk de Schans", "Schans", "1",
                                "3025 HH", "Rdam", 0);

        client.createNewLocation("Praktijk Cool", "Coolhaven", "2",
                                "3015 HA", "Rdam", 10);
    }
    private void createMockAssignment(){
        String shift, workLocation, companyName;
        double rate = 0.0;
        companyName =null;
        workLocation = "Praktijk de Schans";
        shift = "Dag";
        startDate = LocalDate.of(2016, 12, 30);
        endDate = LocalDate.of(2016, 12, 30);
        startTime = LocalTime.of(8, 30);
        endTime = LocalTime.of(18, 00);
        

        assignment = new Assignment(client, startDate, endDate, startTime, endTime, 
                shift, rate, workLocation, companyName);   
        resetDateAndTime();
    }
    
    @After
    public void tearDown() {
        resetDateAndTime();
        if(client != null){
            if(client.getClients() != null){
                client.getClients().clear();
            }
        }
        client = null;
        assignment = null;
        
    }
    
    private void resetDateAndTime(){
        startDateTime = null;
        endDateTime = null;
        startDate = null;
        endDate = null;
        startTime = null; 
        endTime = null;
    }

    //*******************************************************************
    //      TEST constructors
    
    @Test
    public void testNewAssignment_correctParams(){
        
    }
   
    @Test
    public void setPeriod_endDateTimeBeforeStartDateTime(){
        
        startDate = LocalDate.of(2016, 12, 29);
        endDate = LocalDate.of(2016, 12, 28);
        startTime = LocalTime.of(18, 0);
        endTime = LocalTime.of(8, 0);
        startDateTime = LocalDateTime.of(startDate, startTime);
        endDateTime = LocalDateTime.of(endDate, endTime);
                
        thrown.expect(IllegalArgumentException.class);
        
        thrown.expectMessage("The time and/or date of the ending of the shift ("+
                            endDateTime + ")is before the start of the shift (" +
                            startDateTime + ").");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
      
    }
    
    @Test
    public void setPeriod_SD(){
        
        String shift;
        
        startDate = LocalDate.of(2016, 11, 29);
        endDate = null;
        startTime = null;
        endTime = null;
 
        shift = "Dag";        
        startDateTime = LocalDateTime.of(startDate, client.getDefaultStartTime(shift));
        endDateTime = LocalDateTime.of(startDate, client.getDefaultEndTime(shift));
        
        assignment.setPeriod(startDate, endDate, startTime, endTime);
        assertEquals(startDateTime, assignment.getStartDateTime());
        assertEquals(endDateTime, assignment.getEndDateTime());
    }
    
    @Test
    public void setPeriod_SDED(){
        
        String shift;
        
        startDate = LocalDate.of(2016, 11, 29);
        endDate = LocalDate.of(2016, 11, 29);
        startTime = null;
        endTime = null;
        
        shift = "Dag";
        startDateTime = LocalDateTime.of(startDate, client.getDefaultStartTime(shift));
        endDateTime = LocalDateTime.of(endDate, client.getDefaultEndTime(shift));
        
        assignment.setPeriod(startDate, endDate, startTime, endTime);
        assertEquals(startDateTime, assignment.getStartDateTime());
        assertEquals(endDateTime, assignment.getEndDateTime());
    }
    
    @Test
    public void setPeriod_SDST(){
       
        startDate = LocalDate.of(2016, 12, 29);
        endDate = null;
        startTime = LocalTime.of(8, 0);
        endTime = null;
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("End time cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_SDET(){
      
        startDate = LocalDate.of(2016, 12, 29);
        endDate = null;
        startTime = null;
        endTime = LocalTime.of(18, 0);
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start time cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_SDEDST(){
       
        startDate = LocalDate.of(2016, 12, 29);
        endDate = LocalDate.of(2016, 12, 29);
        startTime = LocalTime.of(8, 0);
        endTime = null;
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("End time cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_SDEDET(){
     
        startDate = LocalDate.of(2016, 12, 29);
        endDate = LocalDate.of(2016, 12, 29);
        startTime = null;
        endTime = LocalTime.of(18, 0);
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start time cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_SDSTET(){
      
        startDate = LocalDate.of(2016, 12, 29);
        endDate = null;
        startTime = LocalTime.of(8, 0);
        endTime = LocalTime.of(18, 0);
        
        startDateTime = LocalDateTime.of(startDate, startTime);
        endDateTime = LocalDateTime.of(startDate, endTime);
        
        assignment.setPeriod(startDate, endDate, startTime, endTime);
        assertEquals(startDateTime, assignment.getStartDateTime());
        assertEquals(endDateTime, assignment.getEndDateTime());
    }
    
    @Test
    public void setPeriod_SDEDSTET(){
      
        startDate = LocalDate.of(2016, 12, 29);
        endDate = LocalDate.of(2016, 12, 29);
        startTime = LocalTime.of(8, 0);
        endTime = LocalTime.of(18, 0);
        
        startDateTime = LocalDateTime.of(startDate, startTime);
        endDateTime = LocalDateTime.of(endDate, endTime);
        
        assignment.setPeriod(startDate, endDate, startTime, endTime);
        assertEquals(startDateTime, assignment.getStartDateTime());
        assertEquals(endDateTime, assignment.getEndDateTime());
    }
    
    @Test
    public void setPeriod_ED(){
       
        startDate = null;
        endDate = LocalDate.of(2016, 12, 29);
        startTime = null;
        endTime = null;
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start date cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_EDST(){
   
        startDate = null;
        endDate = LocalDate.of(2016, 12, 29);
        startTime = LocalTime.of(8, 0);
        endTime = null;
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start date cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_EDET(){
     
        startDate = null;
        endDate = LocalDate.of(2016, 12, 29);
        startTime = null;
        endTime = LocalTime.of(18, 0);
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start date cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_EDSTET(){
        
        
        startDate = null;
        endDate = LocalDate.of(2016, 12, 29);
        startTime = LocalTime.of(8, 0);
        endTime = LocalTime.of(18, 0);
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start date cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_ST(){
       
        
        startDate = null;
        endDate = null;
        startTime = LocalTime.of(8, 0);
        endTime = null;
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start date cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_STET(){
       
        
        startDate = null;
        endDate = null;
        startTime = LocalTime.of(8, 0);
        endTime = LocalTime.of(18, 0);
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start date cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test
    public void setPeriod_ET(){
   
        startDate = null;
        endDate = null;
        startTime = null;
        endTime = LocalTime.of(18, 0);
        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Start date cannot be empty.");
        assignment.setPeriod(startDate, endDate, startTime, endTime);
    }
    
    @Test 
    public void testNewAssignment_defaultShiftTimes(){}
    
    @Test 
    public void testNewAssignment_defaultRate(){}
    
    @Test 
    public void testNewAssignment_defaultLocation(){}
    
    @Test
    public void testNewAssignment_noDefaultLocation(){}
    
    @Test 
    public void testNewAssignment_createClient(){}
    
    
}
