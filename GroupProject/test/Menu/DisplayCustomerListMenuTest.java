/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.Customer;
import Model.CustomerDB;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eric Petersen
 */
public class DisplayCustomerListMenuTest {
    
    CustomerDB custDB;
    
    @Before
    public void setUp() {
        custDB = new CustomerDB();
        custDB.addCustomer(new Customer("Bill", "email@email.com","123-456-7890"));
    }
    
    @Test
    public void testExecute() {
        System.out.println("execute");
        DisplayCustomerListMenu instance = new DisplayCustomerListMenu(custDB);
        instance.execute();
        assertTrue(custDB.getAll().size() > 0);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        DisplayCustomerListMenu instance = new DisplayCustomerListMenu(custDB);
        String expResult = "Display Customers";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
