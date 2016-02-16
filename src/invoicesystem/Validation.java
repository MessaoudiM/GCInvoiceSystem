/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

/**
 *
 * @author hassanmessaoudi
 */
public class Validation {
     
    public final static boolean isNotNull(String input){
        if(input == null){
            throw new IllegalArgumentException("Field cannot be null.");
        }
        return true;
    }
    
    public final static boolean isNotEmpty(String input){
        if(input.trim().length() == 0) {
            throw new IllegalArgumentException("Field cannot be empty.");
        }
        return true;
    }
    
    //THIS MAY CAUSE ANNOYING PROBLEMS WHEN WANTING TO EDIT PARTS OF
    // THE CONTACT;S INFO, WHILE FILLING IN THE COMPANIES NAME
    public final static boolean isNotSame(String newString, String oldString){
        if(oldString.equals(newString)){
            throw new IllegalArgumentException("Field : " + newString + 
                    "cannot be the same as its current value.");
        }
        return true;
    }

    public final static boolean hasNoInvalidCharacters(String input) {
        if(input.matches("[\\w\\s-.',]+")){
        //if(personsName.matches("^[\\p{L}]+$ .'-+")){
            return true;
        } else {
            throw new IllegalArgumentException("Valid characters include: "
                    + "space 0-9 A-Z a-z .,'-");
        }
    }
    
    public final static boolean isValidEmailAddress(String input){
        if(input.contains("@") && input.contains(".")){
            return true;
        } else {
            throw new IllegalArgumentException(input + " is not valid. "
                    + "Ensure it contains . (dot) @ (at).");
        }
    }
}
