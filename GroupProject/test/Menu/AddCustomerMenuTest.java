/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.CustomerDB;
import Model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eric Petersen
 */
public class AddCustomerMenuTest {
    private CustomerDB custDB;
    
    @Before
    public void setUp() {
        custDB = new CustomerDB();
        custDB.addCustomer(new Customer("Bill", "email@email.com","123-456-7890"));
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
        AddCustomerMenu instance = new AddCustomerMenu(custDB);
        instance.execute();
        
        assertTrue(custDB.getAll().size() > 1);
    }

    /**
     * Test of toString method, of class AddCustomerMenu.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AddCustomerMenu instance = new AddCustomerMenu(custDB);
        String expResult = "Add Customer";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
