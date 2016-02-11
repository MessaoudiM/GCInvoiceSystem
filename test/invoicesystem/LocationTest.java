/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesystem;

import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hassanmessaoudi
 */
public class LocationTest {
    
    public LocationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getClientLocations method, of class Location.
     */
    @Test
    public void testGetClientLocations() {
        System.out.println("getClientLocations");
        Location instance = new Location();
        Map<String, List<String>> expResult = null;
        Map<String, List<String>> result = instance.getClientLocations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientLocations method, of class Location.
     */
    @Test
    public void testSetClientLocations() {
        System.out.println("setClientLocations");
        Map<String, List<String>> clientLocations = null;
        Location instance = new Location();
        instance.setClientLocations(clientLocations);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWorkLocation method, of class Location.
     */
    @Test
    public void testSetWorkLocation() {
        System.out.println("setWorkLocation");
        String location = "";
        String streetName = "";
        String zipCode = "";
        String city = "";
        Integer distanceFromHome = null;
        boolean isDefaultClientLocation = false;
        Location instance = new Location();
        instance.setWorkLocation(location, streetName, zipCode, city, distanceFromHome, isDefaultClientLocation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefaultClientLocation method, of class Location.
     */
    @Test
    public void testGetDefaultClientLocation() {
        System.out.println("getDefaultClientLocation");
        Location instance = new Location();
        String expResult = "";
        String result = instance.getDefaultClientLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefaultDistanceFromHome method, of class Location.
     */
    @Test
    public void testGetDefaultDistanceFromHome() {
        System.out.println("getDefaultDistanceFromHome");
        Location instance = new Location();
        int expResult = 0;
        int result = instance.getDefaultDistanceFromHome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectDefaultClientLocation method, of class Location.
     */
    @Test
    public void testSelectDefaultClientLocation() {
        System.out.println("selectDefaultClientLocation");
        String location = "";
        Location instance = new Location();
        instance.selectDefaultClientLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
