/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;


/**
 *
 * @author Mohamed Messaoudi
 */
public class Contact {
    
    private String name, sex, role, emailAddress, phoneNumber; 
    
    //*************************************************************************
    //      CONSTRUCTORS
    
    public Contact(String name) {
        this.name = name;
    }
    
    //*************************************************************************
    //      SIMPLE GETTERS AND SETTERS
   
    @Override
    public String toString() {
        return name;
    }

    
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    //*************************************************************************
    //      SETTERS WITH VALIDATION
    
    
  
    
    //*************************************************************************
    //      RE-USABLE VALIDATORS
    
   
}



    //  END  END  END  END  END  END  END  END  END  END  END

  