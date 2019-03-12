/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import Model.Customer;
import Model.CustomerDB;
import Model.FileData;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Eric Petersen
 */
public class GroupProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //   Testing to create a file that saves the data at the end and upon restart load that data back
        CustomerDB people = new CustomerDB();
        FileData list = new FileData();
        
        list.LoadData(people.getAll());    
        
        for(Customer hold : people.getAll())
        {
            System.out.println(hold.toString());
        }
        /*
        people.addCustomer(new Customer("Paul","Fake@gmail.com","510-510-7799"));
        people.addCustomer(new Customer("Greg","Test@gmail.com","408-550-1573"));
        people.addCustomer(new Customer("Dalia","Faust@gmail.com","347-788-4378"));
        
        for(Customer hold : people.getAll())
        {
            System.out.println(hold.toString());
        }
        
        people.get(0).setName("George");
        people.get(1).setMail("o.@hotmail.com");
        people.get(2).setPhoneNumber("389-435-s35");
        
        for(Customer hold : people.getAll())
        {
            System.out.println(hold.toString());
        }      
        System.out.println(people.get(2).getNumber());
        System.out.println(people.get(2).getName());

        */
        list.SaveData(people.getAll());
        
    }
    
}
