/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Mohamed Messaoudi
 */
public class Location {
    
    private Map<String, List<String>> clientLocations; 
                        //key = short description of client's location
                        //val = enumeration of address-info
                            //list.get(0) = streetname + num
                            //list.get(1) = zipcode
                            //list.get(2) = city
                            //list.get(3) = distance from home address 
    private static String homeAddress; //multilined address string
    private String invoiceLocation;
    private String defaultClientLocation;
    
    public Location(){
    
    }
    
    public List<String> getClientLocation(String location){
        return getClientLocations().get(location);
    }
    
    public Map<String, List<String>> getClientLocations() {
        return clientLocations;
    }

    public void setClientLocations(Map<String, List<String>> clientLocations) {
        this.clientLocations = clientLocations;
    }
    
    public void setWorkLocation(String location, String streetName, 
            String zipCode, String city, Integer distanceFromHome, 
            boolean isDefaultClientLocation){
        if(clientLocations == null){
            clientLocations = new HashMap<>();
        }
        if(location != null || streetName != null || zipCode != null || 
                city != null || distanceFromHome != null){
            List<String> addressInfo = new LinkedList<>();
            addressInfo.add(streetName);
            addressInfo.add(zipCode);
            addressInfo.add(city);
            addressInfo.add("" + distanceFromHome);
            clientLocations.put(location, addressInfo);
            if(isDefaultClientLocation || defaultClientLocation == null){
                setDefaultClientLocation(location);
            }
        }
        else {
            throw new IllegalArgumentException("One or more of the entries has"
                    + "not been provided.");
        }
    }
    
    public String getDefaultClientLocation(){
        if(defaultClientLocation != null){
            return defaultClientLocation;
        } 
        else {
            throw new IllegalStateException("No default location defined.");
        }
    }
    
    private void setDefaultClientLocation(String location) {
        this.defaultClientLocation = location;
    }
    
    public int getDefaultDistanceFromHome(){
        if(defaultClientLocation != null){
            String s = getClientLocations().get(defaultClientLocation).get(3);
            return Integer.parseInt(s);
            
        } 
        else {
            throw new IllegalStateException("No default location defined.");
        }
    }
    
    public void selectDefaultClientLocation(String location ){
        if(getClientLocations().containsKey(location)){
            setDefaultClientLocation(location);
        }
    }

   
    
}
