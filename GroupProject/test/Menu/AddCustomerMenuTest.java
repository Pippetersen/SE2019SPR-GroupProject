/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.CustomerDB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eric Petersen
 */
public class AddCustomerMenuTest {
    private static CustomerDB testDB;
    
    public AddCustomerMenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testDB = new CustomerDB();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class AddCustomerMenu.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddCustomerMenu instance = new AddCustomerMenu(testDB);
        instance.execute();
        
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class AddCustomerMenu.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AddCustomerMenu instance = null;
        String expResult = "Add Customer";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
