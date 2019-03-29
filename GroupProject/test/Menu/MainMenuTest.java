/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.Customer;
import Model.CustomerDB;
import java.util.List;
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
public class MainMenuTest {
    CustomerDB custDB;
    
    @Before
    public void setUp() {
        custDB = new CustomerDB();
        custDB.addCustomer(new Customer("Bill", "email@email.com","123-456-7890"));
    }
    
    @Test
    public void testAddToMainMenu() {
        System.out.println("addToMainMenu");
        AddCustomerMenu t = new AddCustomerMenu(custDB);
        MainMenu instance = new MainMenu(custDB);
        instance.addToMainMenu(t);
        assertTrue(instance.getMenuList().size() > 4);
    }

    @Test
    public void testRemoveFromMainMenu() {
        System.out.println("removeFromMainMenu");
        MainMenu instance = new MainMenu(custDB);
        MenuInterface result = instance.removeFromMainMenu(0);
        assertTrue(instance.getMenuList().size() < 4);
    }

    @Test
    public void testDisplayMenuItems() {
        System.out.println("displayMenuItems");
        MainMenu instance = new MainMenu(custDB);
        instance.displayMenuItems();
    }
    
    @Test
    public void testToString() {
        System.out.println("toString");
        MainMenu instance = new MainMenu(custDB);
        String expResult = "Main Menu";
        String result = instance.toString();
        assertEquals(expResult, result);
    }    
}
