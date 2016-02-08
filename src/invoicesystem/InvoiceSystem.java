/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.util.List;
import java.util.Map;
/**
 *
 * @author hassanmessaoudi
 */
public class InvoiceSystem {
    private static Map<String, Contact> customerCompanies;
    
    public static void main(String args[]){
        //to do logic here
    }

    public static Map<String, Contact> getCustomerCompanies() {
        return customerCompanies;
    }

    /**
     *
     * @param customerCompanies
     */
    public static void setCustomerCompanies(Map<String, Contact> customerCompanies) {
        InvoiceSystem.customerCompanies = customerCompanies;
    }

    public static void createContact(String customerCompanyName){
        if(!getCustomerCompanies().containsKey(customerCompanyName)){
            Contact contact = new Contact(customerCompanyName);
            getCustomerCompanies().put(customerCompanyName, contact);
        } else {
            throw new IllegalArgumentException(customerCompanyName);
        }
    }
    
}
