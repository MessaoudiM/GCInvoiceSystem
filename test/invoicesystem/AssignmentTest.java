/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.time.LocalDateTime;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getContact method, of class Assignment.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        Assignment instance = null;
        Contact expResult = null;
        Contact result = instance.getContact();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContact method, of class Assignment.
     */
    @Test
    public void testSetContact() {
        System.out.println("setContact");
        Contact contact = null;
        Assignment instance = null;
        instance.setContact(contact);
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
