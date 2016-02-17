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
        LocalDate assignmentDate;
        LocalTime startTime, endTime;
        String shift, workLocation, companyName;
        double rate = 0.0;
        companyName =null;
        workLocation = "Praktijk de Schans";
        shift = "Dag";
        assignmentDate = LocalDate.of(2016, 30, 12);
        startTime = LocalTime.of(8, 30);
        endTime = LocalTime.of(18, 00);
        

        assignment = new Assignment(client, assignmentDate, startTime, endTime, 
                shift, rate, workLocation, companyName);   
    }
    
    @After
    public void tearDown() {
        if(client != null){
            if(client.getClients() != null){
                client.getClients().clear();
            }
        }
        client = null;
        
        assignment = null;
    }

    //*******************************************************************
    //      TEST constructors
    
    @Test
    public void testNewAssignment_correctParams(){
        
    }
   
    @Test
    public void testNewAssignment_endDateTimeBeforeStartDateTime(){
        assignment = null;
        LocalDate assignmentDate;
        LocalTime startTime, endTime;
        String shift, workLocation, companyName;
        double rate;
        companyName =null;
        workLocation = "Praktijk de Schans";
        shift = "Dag";
        rate = 0.0;
        assignmentDate = LocalDate.of(2016, 29, 12);
        startTime = LocalTime.of(18, 0);
        endTime = LocalTime.of(8, 0);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The time and/or date of the ending of the shift ("+
                            endTime + ")is before the start of the shift (" +
                            startTime + ").");
        assignment = new Assignment(client, assignmentDate, startTime, endTime, 
                shift, rate, workLocation, companyName); 
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
