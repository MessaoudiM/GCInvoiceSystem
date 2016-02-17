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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author hassanmessaoudi
 */
public class ClientTest {
    
private Client client;
    private String companyName, personsName, emailAddress,
            phoneNum, notes, shift;
    private double travelAllowance, rate;               
    private int vat;
    private Map<String, Double> ratesMap;                      
    
    public ClientTest() {
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
        if(client != null){
            if(client.getClients() != null){
                client.getClients().clear();
            }
        }
        client = null;
    }
    
    private void fixtureSetUpMockClient(){     
        
        /*
        client = new Client("Test Inc.");
        client.setEmailAddress("test@testinc.com");
        client.setPersonsName("John");
        client.setPhoneNum("555-12345");
        //client.replaceCompanyName(customerCompanyName);
        //client.setInvoiceAddress("Street 1 /nPC 1234/nCity");
        client.setNotes("Nothing");
        client.setTravelAllowance(1.20);
        client.setVat(21);
        */
  
                
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
    
    private void fixtureTearDownMockClient(){
        if(client != null){
            if(client.getClients() != null){
                client.getClients().clear();
            }
        }
        client = null;
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
    public void getClientFields(){
        fixtureSetUpMockClient();

        assertEquals(companyName, client.getCompanyName());
        assertEquals(personsName, client.getPersonsName());
        assertEquals(emailAddress, client.getEmailAddress()) ;
        assertEquals(phoneNum, client.getPhoneNum());
        assertEquals(notes, client.getNotes());
        assertEquals(travelAllowance, client.getTravelAllowance(), 0.0);
        assertEquals(vat, client.getVat());
        assertEquals(80.00, client.getDefaultRate("Nacht"), 0.0);
       // assertEquals(ratesMap, client.getStandardRates());
       
        fixtureTearDownMockClient();
    }
    
    //*********************************************************************
    //      TEST constructor x4
    @Test
    public void newClient_newClient(){
        companyName = "Test Inc. 2";
        client = new Client(companyName);
        assertEquals(companyName, client.getCompanyName());
    }
    
    @Test
    public void newClient_existingClient(){
        fixtureSetUpMockClient();
        
        companyName = "Test Inc.";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(companyName + " already exists.");
        new Client(companyName);
        
        fixtureTearDownMockClient();
    }
    
    @Test
    public void newClient_null(){
        companyName = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage( "Field cannot be null." );
        new Client(companyName);
    }
    
    
    @Test
    public void newClient_emptyString(){
        companyName = "";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage( "Field cannot be empty." );
        new Client(companyName);
    }
    
    //*********************************************************************
    //      TEST replaceCompanyName x5
    @Test
    public void replaceCompanyName_newName(){
        fixtureSetUpMockClient();
        companyName = "TestClient2";
        
        client.replaceCompanyName(companyName);
        assertEquals("TestClient2", client.getCompanyName());
        
        fixtureTearDownMockClient();
    }
    
    @Test
    public void replaceCompanyName_null(){
        fixtureSetUpMockClient();
        companyName = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage( "Field cannot be null." );
        
        client.replaceCompanyName(companyName);
        fixtureTearDownMockClient();
    }
    
    @Test
    public void replaceCompanyName_emptyString(){
        fixtureSetUpMockClient();
        companyName = "";        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage( "Field cannot be empty." );
        
        client.replaceCompanyName(companyName);
        fixtureTearDownMockClient();
    }
    
    @Test
    public void replaceCompanyName_sameName(){
        fixtureSetUpMockClient();
        companyName = "Test Inc.";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field : " + companyName + 
                "cannot be the same as its current value.");
        client.replaceCompanyName(companyName);
        
        fixtureTearDownMockClient();
    }
    
    @Test
    public void replaceCompanyName_existingNameInCollection(){
        fixtureSetUpMockClient();
        companyName = "TestClient2";
        Client client2 = new Client(companyName);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(companyName + " already exists.");
        client.replaceCompanyName(companyName);
        
        fixtureTearDownMockClient();
    }
   
    //*********************************************************************
    //      TEST setPersonsName x5
    @Test
    public void setPersonsName_null(){
        fixtureSetUpMockClient();
        personsName = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field cannot be null.");
        client.setPersonsName(personsName);
        fixtureTearDownMockClient();
    }
    
    //may cause problems
    @Test
    public void setPersonsName_empty(){
        fixtureSetUpMockClient();
        personsName = "";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field cannot be empty.");
        client.setPersonsName(personsName);
        fixtureTearDownMockClient();
    }
    
    @Test
    public void setPersonsName_allValidCharacters(){
        fixtureSetUpMockClient();
        personsName = "Billy-Bob 'Obrien jr., the 1st";
        client.setPersonsName(personsName);
        assertEquals(personsName, client.getPersonsName());
        fixtureTearDownMockClient();
    }
    
    @Test
    public void setPersonsName_invalidCharactersNonNumbersNonLetters(){
        fixtureSetUpMockClient();
        personsName = "!@#%";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Valid characters include: "
                    + "space 0-9 A-Z a-z .,'-");
        client.setPersonsName(personsName);
        fixtureTearDownMockClient();
    }
    
    @Test
    public void setPersonsName_trailingSpaceLeadingSpace(){
        fixtureSetUpMockClient();
        personsName = "   Billy Bob   ";
        client.setPersonsName(personsName);
        assertEquals("Billy Bob", client.getPersonsName());
        fixtureTearDownMockClient();
    }

    //*********************************************************************
    //      TEST setEmailAddress x4
  
    @Test
    public void setEmailAddress_allValidCharacters(){
        fixtureSetUpMockClient();
        emailAddress = "Bob@testinc.com";
        client.setEmailAddress(emailAddress);
        assertEquals("Bob@testinc.com", client.getEmailAddress());
        fixtureTearDownMockClient();
    }
  
    @Test
    public void setEmailAddress_missingRequiredCharacters(){
        fixtureSetUpMockClient();
        emailAddress = "Bobtestinccom";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(emailAddress + " is not valid. "
                    + "Ensure it contains . (dot) @ (at).");
        client.setEmailAddress(emailAddress);
        fixtureTearDownMockClient();
    }
    
    @Test
    public void setEmailAddress_trailingSpaceLeadingSpace(){
        fixtureSetUpMockClient();
        emailAddress = "   Bob@testinc.com   ";
        client.setEmailAddress(emailAddress);
        assertEquals("Bob@testinc.com", client.getEmailAddress());
        fixtureTearDownMockClient();
    }
    
    @Test
    public void setEmailAddress_null(){
        fixtureSetUpMockClient();
        emailAddress = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field cannot be null");
        client.setEmailAddress(emailAddress);
        fixtureTearDownMockClient();   
    }
}
