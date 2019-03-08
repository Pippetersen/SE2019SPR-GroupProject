/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import Model.Customer;
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
        ArrayList<Customer> client = new ArrayList<>();
        FileData list = new FileData();
        list.LoadData(client);    
        
        for(Customer hold : client)
            System.out.println(hold.toString());

        
        client.add(new Customer("Paul","Fake@gmail.com","510-510-7799"));
        client.add(new Customer("Greg","Test@gmail.com","408-550-1573"));
        client.add(new Customer("Dalia","Faust@gmail.com","347-788-4378"));
    
        //for(Customer hold : client)
          //  System.out.println(hold.toString());
        
        client.get(0).setName("Bill");
        client.get(1).setMail("o.@hotmail.com");
        client.get(2).setPhoneNumber("389-435-s35");

        for(Customer hold : client)
            System.out.println(hold.toString());

        list.SaveData(client);
    }
    
}
