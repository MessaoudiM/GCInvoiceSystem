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
public class InvoiceSystemTest {
    
    public InvoiceSystemTest() {
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
     * Test of getInstance method, of class InvoiceSystem.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        InvoiceSystem expResult = null;
        InvoiceSystem result = InvoiceSystem.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class InvoiceSystem.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        InvoiceSystem.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanies method, of class InvoiceSystem.
     */
    @Test
    public void testGetCompanies() {
        System.out.println("getCompanies");
        Map<String, Client> expResult = null;
        //Map<String, Client> result = InvoiceSystem.getCompanies();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompanies method, of class InvoiceSystem.
     */
    @Test
    public void testSetCompanies() {
        System.out.println("setCompanies");
        Map<String, Client> companies = null;
        //InvoiceSystem.setCompanies(companies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createClient method, of class InvoiceSystem.
     */
    @Test
    public void testCreateClient() {
        System.out.println("createClient");
        String companyName = "";
        InvoiceSystem instance = new InvoiceSystem();
        Client expResult = null;
        Client result = instance.createClient(companyName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of putClientInCompanies method, of class InvoiceSystem.
     */
    @Test
    public void testPutClientInCompanies() {
        System.out.println("putClientInCompanies");
        Client client = new Client("Test Inc.");
        InvoiceSystem instance = new InvoiceSystem();
        //client.putClientInCompanies("tst");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
