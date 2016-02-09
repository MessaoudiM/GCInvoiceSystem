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
    private static InvoiceSystem instance = null;

    
    
    //************************************************************************
    //              CONSTRUCTOR
    protected InvoiceSystem(){
    }
    
    public static InvoiceSystem getInstance(){
        if(instance == null){
            InvoiceSystem.instance = new InvoiceSystem();
        }
        return instance;
    }
    
    public static void main(String args[]){
        //to do logic here
        
        //START DEMO
        InvoiceSystemDemo invoiceSystemDemo = InvoiceSystemDemo.getInstance();
       invoiceSystemDemo.startDemo();
        
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
