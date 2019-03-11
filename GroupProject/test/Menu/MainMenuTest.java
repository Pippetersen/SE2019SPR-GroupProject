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
public class MainMenuTest {
    private static CustomerDB testDB;
    
    public MainMenuTest() {
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
     * Test of addToMainMenu method, of class MainMenu.
     */
    @Test
    public void testAddToMainMenu() {
        System.out.println("addToMainMenu");
        MenuInterface t = null;
        MainMenu instance = new MainMenu(testDB);
        instance.addToMainMenu(t);
        assertEquals(5, instance.getMenuList().size());
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFromMainMenu method, of class MainMenu.
     */
    @Test
    public void testRemoveFromMainMenu() {
        System.out.println("removeFromMainMenu");
        int i = 1;
        MainMenu instance = new MainMenu(testDB);
        int expResult = 3;
        instance.removeFromMainMenu(i);
        assertEquals(expResult, instance.getMenuList().size());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMenuItems method, of class MainMenu.
     */
    @Test
    public void testDisplayMenuItems() {
        System.out.println("displayMenuItems");
        MainMenu instance = new MainMenu(testDB);
        instance.displayMenuItems();
    }

    /**
     * Test of getUserInput method, of class MainMenu.
     */
    @Test
    public void testGetUserInput() {
        System.out.println("getUserInput test");
        MainMenu instance = new MainMenu(testDB);
        int expResult = 0;
        System.out.println("Please enter 0 for your choice");
        int result = instance.getUserInput();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class MainMenu.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        MainMenu instance = new MainMenu(testDB);
        instance.execute();
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MainMenu.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MainMenu instance = new MainMenu(testDB);
        String expResult = "Main Menu";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
