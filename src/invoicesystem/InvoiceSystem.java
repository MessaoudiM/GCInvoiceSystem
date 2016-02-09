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
    
    private static Map<String, Contact> companies = new HashMap<>();
    //private static Contact contact;
    private static InvoiceSystem instance = null;

    
    
    //************************************************************************
    //              CONSTRUCTOR
    protected InvoiceSystem(){
        //companies = new HashMap<>();
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

    public static Map<String, Contact> getCompanies() {
        return companies;
    }

    /**
     *
     * @param companies
     */
    public static void setCompanies(Map<String, Contact> companies) {
        InvoiceSystem.companies = companies;
    }

    /**
     * 
     * @param companyName 
     * @return  Contact
     * 
     */
    public Contact createContact(String companyName){
        //Check to see if the companyName is already in use
        /*
        if(getCustomerCompanies().isEmpty()){
        Contact contact = new Contact(customerCompanyName);
        getCustomerCompanies().put(customerCompanyName, contact);
        return contact;
        */
        
        if(!getCompanies().containsKey(companyName)){
            Contact contact = new Contact(companyName);
            getCompanies().put(companyName, contact);
            return contact;
        
        } else {
            throw new IllegalArgumentException(companyName);
        }
    }
    
}
