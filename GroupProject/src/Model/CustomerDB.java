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
    //Search functions for each category that returns Customer location object if found, returns -1 if not
    public int SearchName(String name)
    {
        int i = 0;
        for(Customer hold : client)
        {
            if(hold.getName().equals(name))
                return i;
            i++;
        }
        return -1;
    }
   
    public int SearchNumber(String number)
    {
        int i = 0;
        for(Customer hold : client)
        {
            if(hold.getNumber().equals(number))
                return i;
            i++;
        }
        return -1;
    }
    
    public int SearchEmail(String email)
    {
        int i = 0;
        for(Customer hold : client)
        {
            if(hold.getMail().equals(email))
                return i;
            i++;
        }
        return -1;
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
