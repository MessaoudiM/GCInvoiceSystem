/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.util.HashMap;
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
public class ContactTest  {

    private Contact contact;
    private String companyName, personsName, emailAddress,
            phoneNum, notes, shift;
    private double travelAllowance, rate;               
    private int vat;
    private Map<String, Double> ratesMap;                      
    
    public ContactTest() {
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
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
        if(contact != null){
            if(contact.getCompanies() != null){
                contact.getCompanies().clear();
            }
        }
        contact = null;
    }
    
    private void fixtureSetUpMockContact(){     
        
        /*
        contact = new Contact("Test Inc.");
        contact.setEmailAddress("test@testinc.com");
        contact.setPersonsName("John");
        contact.setPhoneNum("555-12345");
        //contact.replaceCompanyName(customerCompanyName);
        //contact.setInvoiceAddress("Street 1 /nPC 1234/nCity");
        contact.setNotes("Nothing");
        contact.setTravelAllowance(1.20);
        contact.setVat(21);
        */
  
                
        companyName = "Test Inc.";
        personsName = "John Wayne";
        emailAddress = "test@testinc.com";
        phoneNum = "555-12345";
        notes = "Nothing";
        travelAllowance = 1.20;
        vat = 21;
        
        contact = new Contact(companyName)
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
        contact.setStandardRates(ratesMap);
    }
    
    private void fixtureTearDownMockContact(){
        if(contact != null){
            if(contact.getCompanies() != null){
                contact.getCompanies().clear();
            }
        }
        contact = null;
        companyName = null;
        personsName = null;
        emailAddress = null;
        phoneNum = null;
        notes = null;
        travelAllowance = 0;                
        vat = 0;
        ratesMap = null;                      
        shift = null;
        rate = 0;
        
    }
    
    @Test 
    public void getContactFields(){
        fixtureSetUpMockContact();

        assertEquals(companyName, contact.getCompanyName());
        assertEquals(personsName, contact.getPersonsName());
        assertEquals(emailAddress, contact.getEmailAddress()) ;
        assertEquals(phoneNum, contact.getPhoneNum());
        assertEquals(notes, contact.getNotes());
        assertEquals(travelAllowance, contact.getTravelAllowance(), 0.0);
        assertEquals(vat, contact.getVat());
        assertEquals(ratesMap, contact.getStandardRates());
       
        fixtureTearDownMockContact();
    }
    
    @Test
    public void newContact_newContact(){
        companyName = "Test Inc. 2";
        contact = new Contact(companyName);
        assertEquals(companyName, contact.getCompanyName());
    }
    
    @Test
    public void newContact_existingContact(){
        fixtureSetUpMockContact();
        
        companyName = "Test Inc.";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(companyName + " already exists.");
        new Contact(companyName);
        
        fixtureTearDownMockContact();
    }
    
    @Test
    public void newContact_null(){
        companyName = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage( "Field cannot be empty." );
        new Contact(companyName);
    }
    
    @Test
    public void newContact_emptyString(){
        companyName = "";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage( "Field cannot be empty." );
        new Contact(companyName);
    }
    
    @Test
    public void replaceCompanyName_newName(){
        fixtureSetUpMockContact();
        companyName = "TestCompany2";
        
        contact.replaceCompanyName(companyName);
        assertEquals("TestCompany2", contact.getCompanyName());
        
        fixtureTearDownMockContact();
    }
    
    @Test
    public void replaceCompanyName_null(){
        fixtureSetUpMockContact();
        companyName = null;
        thrown.expect(IllegalArgumentException.class);
        //thrown.expectMessage( "Field cannot be empty." );
        
        contact.replaceCompanyName(companyName);
        fixtureTearDownMockContact();
    }
    
    @Test
    public void replaceCompanyName_emptyString(){
        fixtureSetUpMockContact();
        companyName = "";        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage( "Field cannot be empty." );
        
        contact.replaceCompanyName(companyName);
        fixtureTearDownMockContact();
    }
    
    @Test
    public void replaceCompanyName_sameName(){
        fixtureSetUpMockContact();
        companyName = "Test Inc.";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field : " + companyName + 
                "cannot be the same as its current value.");
        contact.replaceCompanyName(companyName);
        
        fixtureTearDownMockContact();
    }
    
    @Test
    public void replaceCompanyName_existingNameInCollection(){
        fixtureSetUpMockContact();
        companyName = "TestCompany2";
        Contact contact2 = new Contact(companyName);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(companyName + " already exists.");
        contact.replaceCompanyName(companyName);
        
        fixtureTearDownMockContact();
    }
   
    @Test
    public void setPersonsName_null(){
        fixtureSetUpMockContact();
        personsName = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field cannot be empty.");
        contact.setPersonsName(personsName);
        fixtureTearDownMockContact();
    }
    
       @Test
    public void setPersonsName_invalidCharactersNonNumbersNonLetters(){
        fixtureSetUpMockContact();
        personsName = "!@#%";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Valid characters include: "
                    + "space 0-9 A-Z a-z .,'-");
        contact.setPersonsName(personsName);
        fixtureTearDownMockContact();
    }
    
    
    @Test
    public void setPersonsName_leadingSpace(){
        fixtureSetUpMockContact();
        personsName = " Bob";
        contact.setPersonsName(personsName);
        assertEquals("Bob", contact.getCompanyName());
        fixtureTearDownMockContact();
    }
    
      @Test
    public void setPersonsName_trailingSpace(){
        fixtureSetUpMockContact();
        personsName = "Billy Bob  ";
        contact.setPersonsName(personsName);
        assertEquals("Billy Bob", contact.getPersonsName());
        fixtureTearDownMockContact();
    }
    
     
    
  
}
