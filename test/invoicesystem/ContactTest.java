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
    private String companyName, firstName, lastName, emailAddress, 
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
        contact.setFirstName("John");
        contact.setLastName("Wayne");
        contact.setPhoneNum("555-12345");
        //contact.replaceCompanyName(customerCompanyName);
        //contact.setInvoiceAddress("Street 1 /nPC 1234/nCity");
        contact.setNotes("Nothing");
        contact.setTravelAllowance(1.20);
        contact.setVat(21);
        */
  
                
        companyName = "Test Inc.";
        firstName = "John";
        lastName = "Wayne";
        emailAddress = "test@testinc.com";
        phoneNum = "555-12345";
        notes = "Nothing";
        travelAllowance = 1.20;
        vat = 21;
        
        contact = new Contact("Test Inc.")
                .setEmailAddress("test@testinc.com")                            
                .setFirstName("John")
                .setLastName("Wayne")
                .setPhoneNum("555-12345")
                .setNotes("Nothing")
                .setTravelAllowance(1.20)
                .setVat(21);
        
        
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
        firstName = null;
        lastName = null;
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
        assertEquals(firstName, contact.getFirstName());
        assertEquals(lastName, contact.getLastName());
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
    public void setFirstName_correctNameSingleName(){
        fixtureSetUpMockContact();
        firstName = "Bob";
        contact.setFirstName(firstName);
        assertEquals(firstName, contact.getFirstName());
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_correctNameCompositeNameSeparatedBySpace(){
        fixtureSetUpMockContact();
        firstName = "Billy Bob";
        contact.setFirstName(firstName);
        assertEquals(firstName, contact.getFirstName());
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_correctNameCompositeNameSeparatedByHyphen(){
        fixtureSetUpMockContact();
        firstName = "Billy-Bob";
        contact.setFirstName(firstName);
        assertEquals(firstName, contact.getFirstName());
        fixtureTearDownMockContact();
    }

    @Test
    public void setFirstName_emptyString(){
        fixtureSetUpMockContact();
        firstName = "";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field cannot be empty.")
        contact.setFirstName(firstName);
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_null(){
        fixtureSetUpMockContact();
        firstName = null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field cannot be empty.")
        contact.setFirstName(firstName);
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_invalidCharactersNumbers(){
        fixtureSetUpMockContact();
        firstName = "1234";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid characters. Field may only "
                + "contain the following characters: a-z, A-Z, hyphen -");
        contact.setFirstName(firstName);
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_invalidCharactersNonNumbersNonLetters(){
        fixtureSetUpMockContact();
        firstName = "!@#%";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid characters. Field may only "
                + "contain the following characters: a-z, A-Z, hyphen -");
        contact.setFirstName(firstName);
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_invalidCharactersCombination(){
        fixtureSetUpMockContact();
        firstName = "567890+_)(*&}{";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid characters. Field may only "
                + "contain the following characters: a-z, A-Z, hyphen -");
        contact.setFirstName(firstName);
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_allCapsSingleName(){
        fixtureSetUpMockContact();
        firstName = "BOB";
        contact.setFirstName(firstName);
        assertEquals("Bob", contact.getFirstName());
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_allCapsCompositeNameSeparatedBySpace(){
        fixtureSetUpMockContact();
        firstName = "BILLY BOB";
        contact.setFirstName(firstName);
        assertEquals("Billy Bob", contact.getFirstName());
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_allCapsCompositeNameSeparatedByHyphen(){
        fixtureSetUpMockContact();
        firstName = "BILLY-BOB";
        contact.setFirstName(firstName);
        assertEquals("Billy-Bob", contact.getFirstName());
        fixtureTearDownMockContact();
    }
    
    @Test
    public void setFirstName_oneLetterString(){
        fixtureSetUpMockContact();
        firstName = "M";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Field must contain at least 2 characters.");
        contact.setFirstName(firstName);
        fixtureTearDownMockContact();
    }
    
    @Test 
    public void setFirstName_twoLetterString(){
        fixtureSetUpMockContact();
        firstName = "Mo";
        contact.setFirstName(firstName);
        assertEquals(firstName, contact.getFirstName());
        fixtureTearDownMockContact();
    }
    
    @Test 
    public void setFirstName_largeString(){
        fixtureSetUpMockContact();
        firstName = getLargeString();
        contact.setFirstName(firstName);
        assertEquals(firstName, contact.getFirstName());
        fixtureTearDownMockContact();
    }
    
    private String getLargeString(){
        String returnString = "";
        for(int i = 0; i < 100; i++){
            returnString += "Abcdefghijklmnopqrstuvwxyz";
        }
        return returnString;
    }
    /*
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
    
    @Test
    public void testSetCompanyName() {
    System.out.println("replaceCompanyName");
    String companyName = "";
    Contact instance = null;
    instance.replaceCompanyName(companyName);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
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
    
    @Test
    public void testSetFirstName() {
    System.out.println("setFirstName");
    String firstName = "";
    Contact instance = null;
    instance.setFirstName(firstName);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
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
    
    @Test
    public void testSetLastName() {
    System.out.println("setLastName");
    String lastName = "";
    Contact instance = null;
    instance.setLastName(lastName);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
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
    
    @Test
    public void testSetEmailAddress() {
    System.out.println("setEmailAddress");
    String emailAddress = "";
    Contact instance = null;
    instance.setEmailAddress(emailAddress);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
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
    
    @Test
    public void testSetPhoneNum() {
    System.out.println("setPhoneNum");
    String phoneNum = "";
    Contact instance = null;
    instance.setPhoneNum(phoneNum);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
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
    
    @Test
    public void testSetNotes() {
    System.out.println("setNotes");
    String notes = "";
    Contact instance = null;
    instance.setNotes(notes);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
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
    
    @Test
    public void testSetStandardRates() {
    System.out.println("setStandardRates");
    Map<String, Double> standardRates = null;
    Contact instance = null;
    instance.setStandardRates(standardRates);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
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
    
    @Test
    public void testSetVat() {
    System.out.println("setVat");
    int vat = 0;
    Contact instance = null;
    instance.setVat(vat);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
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
    
    @Test
    public void testSetTravelAllowance() {
    System.out.println("setTravelAllowance");
    double travelAllowance = 0.0;
    Contact instance = null;
    instance.setTravelAllowance(travelAllowance);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    */
    
  
}
