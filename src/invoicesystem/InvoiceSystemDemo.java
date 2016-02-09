/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import static invoicesystem.InvoiceSystem.createContact;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hassanmessaoudi
 */
public class InvoiceSystemDemo {

    private Contact contact;
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
            InvoiceSystem invoiceSystem = InvoiceSystem.getInstance();
            InvoiceSystemDemo.instance = new InvoiceSystemDemo();
        }
        return instance;
    }
    
    public void createDemoContact(){
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

    public void startDemo() {
        createDemoContact();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
