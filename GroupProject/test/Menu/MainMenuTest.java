/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

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
        MainMenu instance = new MainMenu();
        instance.addToMainMenu(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFromMainMenu method, of class MainMenu.
     */
    @Test
    public void testRemoveFromMainMenu() {
        System.out.println("removeFromMainMenu");
        int i = 0;
        MainMenu instance = new MainMenu();
        MenuInterface expResult = null;
        MenuInterface result = instance.removeFromMainMenu(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMenuItems method, of class MainMenu.
     */
    @Test
    public void testDisplayMenuItems() {
        System.out.println("displayMenuItems");
        MainMenu instance = new MainMenu();
        instance.displayMenuItems();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInput method, of class MainMenu.
     */
    @Test
    public void testGetUserInput() {
        System.out.println("getUserInput");
        MainMenu instance = new MainMenu();
        int expResult = 0;
        int result = instance.getUserInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class MainMenu.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        MainMenu instance = new MainMenu();
        instance.execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MainMenu.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MainMenu instance = new MainMenu();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
