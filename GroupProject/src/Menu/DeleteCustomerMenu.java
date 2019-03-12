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
public class DeleteCustomerMenu implements MenuInterface {
    private static CustomerDB dbPointer;
    
    public DeleteCustomerMenu(CustomerDB tempDB) {
        dbPointer = tempDB;
    }
    @Override
    public void execute() {
        //To be implemented
        System.out.println("This is not implemented yet");
    }
    
    @Override
    public String toString() {
        return "Delete Customer";
    }
}
