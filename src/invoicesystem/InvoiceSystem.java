/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

//import java.util.List;
import java.util.Map;
import java.util.HashMap;
//import java.math.BigDecimal;

/**
 *
 * @author hassanmessaoudi
 */
public class InvoiceSystem {
    
    private static Map<String, Contact> customerCompanies;
    
    private static Contact contact;
    
    //************************************************************************
    //              CONSTRUCTOR
    public InvoiceSystem(){
    
    }
    
    public static void main(String args[]){
        //to do logic here
        
        // create demo contact
        contact = createContact("Willemsen BV");
        contact.setContactFirstName("Joop");
        contact.setContactLastName("Willemsen");
        contact.setContactPhoneNum("0612345678");
        contact.setContactEmailAddress("administratie@willemsenbv.nl");
        contact.setInvoiceAddress("Schans 1 \n3025 BB\nRotterdam");
        Map<String, Double> ratesMap;
        ratesMap = new HashMap<>();
        String shift = "Dag";
        double rate = 50.00;
        ratesMap.put(shift, rate);
        shift = "Nacht";
        rate = 80.00;
        ratesMap.put(shift, rate);
        contact.setStandardRates(ratesMap);
        contact.setNotes("xxxxxxxxxx");
        contact.setTravelAllowance(1.20);
        contact.setVat(21);
        Map<String, Integer> workLocations = new HashMap<>();
        workLocations.put("Schans", 0);
        contact.setWorkLocations(workLocations);
        
        
    }

    public static Map<String, Contact> getCustomerCompanies() {
        return customerCompanies;
    }

    /**
     *
     * @param customerCompanies
     */
    public static void setCustomerCompanies(Map<String, 
            Contact> customerCompanies) {
        InvoiceSystem.customerCompanies = customerCompanies;
    }

    /**
     * 
     * @param customerCompanyName 
     * @return  Contact
     * 
     */
    public static Contact createContact(String customerCompanyName){
        //Check to see if the customerCompanyName is already in use
        if(!getCustomerCompanies().containsKey(customerCompanyName)){
            Contact contact = new Contact(customerCompanyName);
            getCustomerCompanies().put(customerCompanyName, contact);
            return contact;
        } else {
            throw new IllegalArgumentException(customerCompanyName);
        }
    }
    
}
