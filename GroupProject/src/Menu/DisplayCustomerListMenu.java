/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.CustomerDB;

/**
 *
 * @author Eric Petersen
 */
public class DisplayCustomerListMenu implements MenuInterface {
    //The database pointer
    private static CustomerDB dbPointer;
    
    //Constructor sets dbPointer to the passed db location
    public DisplayCustomerListMenu(CustomerDB tempDB) {
        dbPointer = tempDB;
    }
    //Displays all the customers in the db
    @Override
    public void execute() {
        System.out.println("Displaying all customers in db:");
        for(int i = 0; i < dbPointer.getAll().size(); i++) {
            System.out.println(dbPointer.get(i).toString());
        }
    }
    //To string for menu items
    @Override
    public String toString() {
        return "Display Customers";
    }
}
