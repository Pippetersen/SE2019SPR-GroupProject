package Model;

import java.util.ArrayList;

/**
 *
 * @author clone-sniper
 */
public class CustomerDB {
    private ArrayList<Customer> client;
    
    public CustomerDB()
    {
        client = new ArrayList<>();
    }
    //Adds Customer object to ArrayList client
    public void addCustomer(Customer person)
    {
        client.add(person);
    }
    //Removes Customer based on int passeed
    public void deleteCustomer(int pos)
    {
        client.remove(client.get(pos));
    }
    
    public Customer get(int pos)
    {
        return client.get(pos);
    }

    public void concatList(ArrayList<Customer> other){
        client.addAll(other);
    }
    
    public ArrayList<Customer> getAll()
    {
        return client;
    }
    //Search functions for each category that returns Customer object if found, returns null if not
    public Customer SearchName(String name)
    {
        for(Customer hold : client)
        {
            if(hold.getName().equals(name))
                return hold;            
        }
        return null;
    }
   
    public Customer SearchNumber(String number)
    {
        for(Customer hold : client)
        {
            if(hold.getNumber().equals(number))
                return hold;
        }
        return null;
    }
    
        public Customer SearchEmail(String email)
    {
        for(Customer hold : client)
        {
            if(hold.getMail().equals(email))
                return hold;
        }
        return null;
    }
    //Search Funciton that returns ArrayList if looking for Customers that have the same name    
    public ArrayList<Customer> SearchMultiName(String name)
    {
        ArrayList<Customer> temp = new ArrayList<>();
        for(Customer hold : client)
        {
            if(hold.getName().equals(name))
                temp.add(hold);
        }
        return temp;
    }
}
