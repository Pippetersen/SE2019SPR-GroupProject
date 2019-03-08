/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import Model.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Eric Petersen
 */
public class GroupProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persist");
        EntityManager em = emf.createEntityManager();
        
        Customer cust = em.find(Customer.class, 1);
        System.out.println(cust.getName());
        cust.setName("Bob");
        System.out.println(cust.getName());
        Customer cust2 = em.find(Customer.class, 2);
        System.out.println(cust2.getEmail());
        System.out.println(cust2.toString());
    }
    
}
