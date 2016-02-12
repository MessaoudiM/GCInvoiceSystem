/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

//import java.util.List;
//import java.util.Map;
//import java.util.HashMap;
//import java.math.BigDecimal;

/**
 *
 * @author hassanmessaoudi
 */
public class InvoiceSystem {

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

 

    /**
     * 
     * @param companyName 
     * @return  Contact
     * 
     */
    public Contact createContact(String companyName){
        try{
            return new Contact(companyName);
        }
        catch(IllegalArgumentException e){
            // TRY AGAIN WITH ANOTHER INPUT
            System.out.println(e);
            return null;
        }
        
    }
    
    /*public Assignment createAssignment(){
    return new Assignment();
    }*/
    
    
}
