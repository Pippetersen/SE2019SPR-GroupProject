
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
    
    public Customer get(int position)
    {
        return client.get(position);
    }
    
    public ArrayList<Customer> getAll()
    {
        return client;
    }
}
