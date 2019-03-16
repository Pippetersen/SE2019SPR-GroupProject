/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clone-sniper
 */
public class CustomerTest {
    static Customer instance;
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    instance = new Customer("Bill","Fake@gmail.com","555-265-5684");    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Bill";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMail method, of class Customer.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        String expResult = "Fake@gmail.com";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getNumber method, of class Customer.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        String expResult = "555-265-5684";
        String result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setName method, of class Customer.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "George";    
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setMail method, of class Customer.
     */
    @Test
    public void testSetMail() {
        System.out.println("setMail");
        String mail = "Gagona@hotmail.com";
        instance.setMail(mail);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPhoneNumber method, of class Customer.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String number = "568-868-6895";
        instance.setPhoneNumber(number);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = " | Customer Name: Bill | Customer Phone Number: 555-265-5684 | Customer Email: Fake@gmail.com";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
