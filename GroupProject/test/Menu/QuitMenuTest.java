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
public class QuitMenuTest {
    MainMenu menu;
    CustomerDB custDB;
    
    @Before
    public void setUp() {
        custDB = new CustomerDB();
        custDB.addCustomer(new Customer("Bill", "email@email.com","123-456-7890"));
        menu = new MainMenu(custDB);
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        QuitMenu instance = new QuitMenu(custDB);
        while(menu.getMenuList().size() > 1) {
            menu.removeFromMainMenu(1);
        }
        menu.execute();
    }
    
    @Test
    public void testToString() {
        System.out.println("toString");
        QuitMenu instance = new QuitMenu(custDB);
        String expResult = "Quit";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
