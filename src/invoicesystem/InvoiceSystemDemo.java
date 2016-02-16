/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

//import static invoicesystem.InvoiceSystem.createClient;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hassanmessaoudi
 */
public class InvoiceSystemDemo {

    //private Client client;
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
        createDemoClient();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @return Client
     */
    public Client createDemoClient(){
    // create demo client
        Client client;
        client = invoiceSystem.createClient("Willemsen BV");
        client.setPersonsName("Joop");
        client.setPhoneNum("0612345678");
        client.setEmailAddress("administratie@willemsenbv.nl");
  //      client.setInvoiceAddress("Schans 1 \n3025 BB\nRotterdam");
        client.setNotes("xxxxxxxxxx");
        client.setTravelAllowance(1.20);
        client.setVat(21);
        
        
        Map<String, Double> ratesMap;
        ratesMap = new HashMap<>();
        String shift = "Dag";
        double rate = 50.00;
        ratesMap.put(shift, rate);
        shift = "Nacht";
        rate = 80.00;
        ratesMap.put(shift, rate);
        client.setStandardRates(ratesMap);
        
/*      Map<String, Integer> workLocations = new HashMap<>();
        workLocations.put("Schans", 0);
        client.setWorkLocations(workLocations);
        */    
        
        return client;
    }

   
    
}
