
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
    
    public void addCustomer(Customer person)
    {
        client.add(person);
    }
    
    public void deleteCustomer(int pos)
    {
        client.remove(client.get(pos));
    }
    
    public Customer get(int pos)
    {
        return client.get(pos);
    }
    public ArrayList<Customer> getAll()
    {
        return client;
    }
}
