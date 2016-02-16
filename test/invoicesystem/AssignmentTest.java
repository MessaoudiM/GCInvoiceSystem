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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hassanmessaoudi
 */
public class AssignmentTest {
    
    private Client client;
    private Assignment assignment;
    
    public AssignmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        // create mock client -----------------------------------------------
        
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
        
        //  -----------------------------------------------
    }
    
    @After
    public void tearDown() {
        client = null;
        assignment = null;
    }

    //*******************************************************************
    //      TEST constructors
    
    @Test
    public void testNewAssignment_correctParams(){
        LocalDateTime startDateTime = LocalDateTime.of(2016, 12, 5, 8, 30);
        LocalDateTime endDateTime = LocalDateTime.of(2016, 12, 5, 18, 00);
        String shift = "Dag";
        Location workLocation = new Location();
        //List<String> workLocation = client.getLocation("default");
        assignment = new Assignment(client, startDateTime, endDateTime, 
                shift, workLocation);
    }
    
    /**
     * Test of getClient method, of class Assignment.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        Assignment instance = null;
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClient method, of class Assignment.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        Client client = null;
        Assignment instance = null;
        instance.setClient(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRate method, of class Assignment.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        Assignment instance = null;
        double expResult = 0.0;
        double result = instance.getRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRate method, of class Assignment.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        double rate = 0.0;
        Assignment instance = null;
        instance.setRate(rate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDateTime method, of class Assignment.
     */
    @Test
    public void testGetStartDateTime() {
        System.out.println("getStartDateTime");
        Assignment instance = null;
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getStartDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDateTime method, of class Assignment.
     */
    @Test
    public void testSetStartDateTime() {
        System.out.println("setStartDateTime");
        LocalDateTime startDateTime = null;
        Assignment instance = null;
        instance.setStartDateTime(startDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDateTime method, of class Assignment.
     */
    @Test
    public void testGetEndDateTime() {
        System.out.println("getEndDateTime");
        Assignment instance = null;
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getEndDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDateTime method, of class Assignment.
     */
    @Test
    public void testSetEndDateTime() {
        System.out.println("setEndDateTime");
        LocalDateTime endDateTime = null;
        Assignment instance = null;
        instance.setEndDateTime(endDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoursMappedToRate method, of class Assignment.
     */
    @Test
    public void testGetHoursMappedToRate() {
        System.out.println("getHoursMappedToRate");
        Assignment instance = null;
        Map<Double, Map<LocalDateTime, LocalDateTime>> expResult = null;
        Map<Double, Map<LocalDateTime, LocalDateTime>> result = instance.getHoursMappedToRate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoursMappedToRate method, of class Assignment.
     */
    @Test
    public void testSetHoursMappedToRate_Map() {
        System.out.println("setHoursMappedToRate");
        Map<Double, Map<LocalDateTime, LocalDateTime>> hoursMappedToRate = null;
        Assignment instance = null;
        instance.setHoursMappedToRate(hoursMappedToRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoursMappedToRate method, of class Assignment.
     */
    @Test
    public void testSetHoursMappedToRate_3args() {
        System.out.println("setHoursMappedToRate");
        double rate = 0.0;
        LocalDateTime startTime = null;
        LocalDateTime endTime = null;
        Assignment instance = null;
        instance.setHoursMappedToRate(rate, startTime, endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShift method, of class Assignment.
     */
    @Test
    public void testGetShift() {
        System.out.println("getShift");
        Assignment instance = null;
        String expResult = "";
        String result = instance.getShift();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShift method, of class Assignment.
     */
    @Test
    public void testSetShift() {
        System.out.println("setShift");
        String shift = "";
        Assignment instance = null;
        instance.setShift(shift);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
