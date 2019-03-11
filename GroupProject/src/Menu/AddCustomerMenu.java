/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.CustomerDB;
import Model.Customer;
import java.util.Scanner;

/**
 *
 * @author Eric Petersen
 */
public class AddCustomerMenu implements MenuInterface {
    //Needs customer DB to add customers.
    private static CustomerDB dbPointer;
    
    public AddCustomerMenu(CustomerDB tempDB) {
        dbPointer = tempDB;
    }
    
    @Override
    public void execute() {
        Scanner STDIN = new Scanner(System.in);
        System.out.println("-Add Customer-");
        System.out.print("Please enter customer name:");
        String tempName = STDIN.nextLine();
        System.out.print("Please enter customer email:");
        String tempEmail = STDIN.nextLine();
        System.out.print("Please enter customer phone number:");
        String tempNum = STDIN.nextLine();
        dbPointer.addCustomer(new Customer(tempName, tempEmail, tempNum));
    }
    
    @Override
    public String toString() {
        return "Add Customer";
    }
}
