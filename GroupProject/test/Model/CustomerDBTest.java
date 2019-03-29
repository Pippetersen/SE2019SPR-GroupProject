/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
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
public class CustomerDBTest {
    public CustomerDBTest() {
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
     * Test of addCustomer method, of class CustomerDB.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        Customer person = null;
        CustomerDB instance = new CustomerDB();
        instance.addCustomer(person);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deleteCustomer method, of class CustomerDB.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        int pos = 0;
        CustomerDB instance = new CustomerDB();
        Customer person = null;
        instance.addCustomer(person);
        instance.deleteCustomer(pos);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of get method, of class CustomerDB.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int pos = 0;
        CustomerDB instance = new CustomerDB();
        Customer temp = new Customer();
        instance.addCustomer(temp);
        Customer result = instance.get(pos);
        assertEquals(temp, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of concatList method, of class CustomerDB.
     */
    @Test
    public void testConcatList() {
        System.out.println("concatList");
        ArrayList<Customer> other = new ArrayList<>();
        CustomerDB instance = new CustomerDB();
        instance.concatList(other);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAll method, of class CustomerDB.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        CustomerDB instance = new CustomerDB();
        Customer temp = new Customer("Bill", "hold", "510-510-5426");
        instance.addCustomer(temp);
        instance.addCustomer(temp);
        ArrayList<Customer> expResult = new ArrayList<>();
        expResult.add(temp);
        expResult.add(temp);
        ArrayList<Customer> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SearchName method, of class CustomerDB.
     */
    @Test
    public void testSearchName() {
        System.out.println("SearchName");
        String name = "Bill";
        CustomerDB instance = new CustomerDB();
        Customer temp = new Customer("Bill", "hold", "510-510-5426");
        instance.addCustomer(temp);
        Customer expResult = temp;
        Customer result = instance.SearchName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SearchNumber method, of class CustomerDB.
     */
    @Test
    public void testSearchNumber() {
        System.out.println("SearchNumber");
        String number = "510-510-5426";
        CustomerDB instance = new CustomerDB();
        Customer temp = new Customer("Bill", "hold", "510-510-5426");
        instance.addCustomer(temp);
        Customer expResult = temp;
        Customer result = instance.SearchNumber(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SearchEmail method, of class CustomerDB.
     */
    @Test
    public void testSearchEmail() {
        System.out.println("SearchEmail");
        String email = "Fake@gmail.com";
        CustomerDB instance = new CustomerDB();
        Customer temp = new Customer("Bill", "Fake@gmail.com", " hold");
        instance.addCustomer(temp);
        Customer expResult = temp;
        Customer result = instance.SearchEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SearchMultiName method, of class CustomerDB.
     */
    @Test
    public void testSearchMultiName() {
        System.out.println("SearchMultiName");
        String name = "Bill";
        CustomerDB instance = new CustomerDB();
        ArrayList<Customer> expResult = new ArrayList<>();
        ArrayList<Customer> result = instance.SearchMultiName(name);
        Customer temp = new Customer("Bill", "Hold", " hold");
        expResult.add(temp);
        expResult.add(temp);
        result.add(temp);
        result.add(temp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
