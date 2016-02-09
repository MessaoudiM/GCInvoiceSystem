/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package US001;

import invoicesystem.*;
import java.util.HashMap;
import java.util.Map;
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
 */
public class TestContact {
    
    Contact contact;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setUp(){
        //COPY TO ANOTHER TESTCLASS
        //InvoiceSystem invoiceSystem = InvoiceSystem.getInstance();
        //InvoiceSystemDemo invoiceSystemDemo = InvoiceSystemDemo.getInstance();
        //contact = invoiceSystemDemo.createDemoContact();
        
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
    }
    
    @After
    public void tearDown(){
        contact = null;
        InvoiceSystem.getCompanies().clear();
    
    }
    
    @Test
    public void testCompanyName(){
        assertEquals("Test Inc.", contact.getCompanyName());
    }
    @Test
    public void testFirstName(){
        assertEquals("John", contact.getFirstName());
    }
    
    @Test
    public void testLastName() {
       assertEquals("Wayne", contact.getLastName());
    }
    
    @Test
    public void testPhoneNum(){
        assertEquals("555-12345", contact.getPhoneNum());
    }
    
    @Test
    public void testEmailAddress(){
        assertEquals("test@testinc.com", contact.getEmailAddress());
    }
    //public void testCompanyName(){}
    
    @Test
    public void testInvoiceAddress(){
        assertEquals("Street 1 /nPC 1234/nCity", contact.getInvoiceAddress());
    }
    
    @Test
    public void testNotes(){
        assertEquals("Nothing", contact.getNotes());
    }
    
    @Test
    public void testStandardRates(){
        assertTrue(contact.getStandardRates().containsKey("Dag"));
        assertTrue(contact.getStandardRates().containsKey("Nacht"));
        assertEquals(50.00, contact.getStandardRates().get("Dag"), 0.0);
        assertEquals(80.00, contact.getStandardRates().get("Nacht"), 0.0);
    }
    
    @Test
    public void testTravelAllowance(){
        assertEquals(1.2, contact.getTravelAllowance(), 0.0);
    }
    
    @Test
    public void testVat(){
        assertEquals(21, contact.getVat());
    }
    
    @Test
    public void testWorkLocations(){
        assertTrue(contact.getWorkLocations().containsKey("Schans"));
        assertEquals((Integer) 0, contact.getWorkLocations().get("Schans"));
    }
    
    @Test
    public void newContact_newContact(){
        String companyName = "TestCompany2";
        contact = new Contact(companyName);
        assertEquals(companyName, contact.getCompanyName());
    }
    
    @Test
    public void newContact_existingContact(){
        
        String companyName = "Test Inc.";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(companyName);
        contact = new Contact(companyName);
    }
    
    @Test
    public void setCompanyName_newName(){
        String companyName = "TestCompany2";
        contact.setCompanyName(companyName);
        assertEquals("TestCompany2", contact.getCompanyName());
    }
    
    @Test
    public void setCompanyName_sameName(){
        String companyName = "Test Inc.";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(companyName + 
                " is the same as its current name.");
        contact.setCompanyName(companyName);
    }
    
    @Test
    public void setCompanyName_existingName(){
        String companyName = "TestCompany2";
        Contact contact2 = new Contact(companyName);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(companyName + 
                " already exists in list of companies.");
        contact.setCompanyName(companyName);
    }

}
