/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

//import static invoicesystem.InvoiceSystem.createContact;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hassanmessaoudi
 */
public class InvoiceSystemDemo {

    //private Contact contact;
    private  InvoiceSystem invoiceSystem;
    private static InvoiceSystemDemo instance = null;

    protected InvoiceSystemDemo() {
    
    }
    
    /**
     *
     * @return
     */
    public static InvoiceSystemDemo getInstance(){
        if(instance == null){
            
            InvoiceSystemDemo.instance = new InvoiceSystemDemo();
        }
        return instance;
    }
    
    public void startDemo() {
        invoiceSystem = InvoiceSystem.getInstance();
        createDemoContact();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @return Contact
     */
    public Contact createDemoContact(){
    // create demo contact
        Contact contact;
        contact = invoiceSystem.createContact("Willemsen BV");
        contact.setFirstName("Joop");
        contact.setLastName("Willemsen");
        contact.setPhoneNum("0612345678");
        contact.setEmailAddress("administratie@willemsenbv.nl");
  //      contact.setInvoiceAddress("Schans 1 \n3025 BB\nRotterdam");
        contact.setNotes("xxxxxxxxxx");
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
        
/*      Map<String, Integer> workLocations = new HashMap<>();
        workLocations.put("Schans", 0);
        contact.setWorkLocations(workLocations);
        */    
        
        return contact;
    }

   
    
}
