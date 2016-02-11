/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

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
public class ContactTest  {
    
    public ContactTest() {
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
     * Test of toString method, of class Contact.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Contact instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanyName method, of class Contact.
     */
    @Test
    public void testGetCompanyName() {
        System.out.println("getCompanyName");
        Contact instance = null;
        String expResult = "";
        String result = instance.getCompanyName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompanyName method, of class Contact.
     */
    @Test
    public void testSetCompanyName() {
        System.out.println("setCompanyName");
        String companyName = "";
        Contact instance = null;
        instance.setCompanyName(companyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Contact.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Contact instance = null;
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Contact.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Contact instance = null;
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Contact.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Contact instance = null;
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Contact.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Contact instance = null;
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailAddress method, of class Contact.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Contact instance = null;
        String expResult = "";
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailAddress method, of class Contact.
     */
    @Test
    public void testSetEmailAddress() {
        System.out.println("setEmailAddress");
        String emailAddress = "";
        Contact instance = null;
        instance.setEmailAddress(emailAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhoneNum method, of class Contact.
     */
    @Test
    public void testGetPhoneNum() {
        System.out.println("getPhoneNum");
        Contact instance = null;
        String expResult = "";
        String result = instance.getPhoneNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhoneNum method, of class Contact.
     */
    @Test
    public void testSetPhoneNum() {
        System.out.println("setPhoneNum");
        String phoneNum = "";
        Contact instance = null;
        instance.setPhoneNum(phoneNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotes method, of class Contact.
     */
    @Test
    public void testGetNotes() {
        System.out.println("getNotes");
        Contact instance = null;
        String expResult = "";
        String result = instance.getNotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotes method, of class Contact.
     */
    @Test
    public void testSetNotes() {
        System.out.println("setNotes");
        String notes = "";
        Contact instance = null;
        instance.setNotes(notes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStandardRates method, of class Contact.
     */
    @Test
    public void testGetStandardRates() {
        System.out.println("getStandardRates");
        Contact instance = null;
        Map<String, Double> expResult = null;
        Map<String, Double> result = instance.getStandardRates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStandardRates method, of class Contact.
     */
    @Test
    public void testSetStandardRates() {
        System.out.println("setStandardRates");
        Map<String, Double> standardRates = null;
        Contact instance = null;
        instance.setStandardRates(standardRates);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVat method, of class Contact.
     */
    @Test
    public void testGetVat() {
        System.out.println("getVat");
        Contact instance = null;
        int expResult = 0;
        int result = instance.getVat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVat method, of class Contact.
     */
    @Test
    public void testSetVat() {
        System.out.println("setVat");
        int vat = 0;
        Contact instance = null;
        instance.setVat(vat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTravelAllowance method, of class Contact.
     */
    @Test
    public void testGetTravelAllowance() {
        System.out.println("getTravelAllowance");
        Contact instance = null;
        double expResult = 0.0;
        double result = instance.getTravelAllowance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTravelAllowance method, of class Contact.
     */
    @Test
    public void testSetTravelAllowance() {
        System.out.println("setTravelAllowance");
        double travelAllowance = 0.0;
        Contact instance = null;
        instance.setTravelAllowance(travelAllowance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
