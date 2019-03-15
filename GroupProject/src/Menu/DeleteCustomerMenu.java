/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.CustomerDB;
import java.util.Scanner;

/**
 *
 * @author Eric Petersen
 */
public class DeleteCustomerMenu implements MenuInterface {
    private static CustomerDB dbPointer;
    
    public DeleteCustomerMenu(CustomerDB tempDB) {
        dbPointer = tempDB;
    }
    //Prompts user for how they would like to delete
    @Override
    public void execute() {
       Scanner STDIN = new Scanner(System.in);
       System.out.println("0: Cancel");
       System.out.println("1: Delete by name");
       System.out.println("2: Delete by phone number");
       System.out.println("3: Delete by email");
       System.out.print("Please enter your choice 0-3:");
       int i = STDIN.nextInt();
       switch(i) {
           case 0:
               return;
           case 1:
               deleteByName();
               return;
           case 2:
               deleteByNum();
               return;
           case 3:
               deleteByEmail();
               return;
           default:
               System.out.println("Invalid choice!");
               this.execute();
       }
    }
    
    private void deleteByName() {
        Scanner STDIN = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the name to look for:");
        String tempName = STDIN.nextLine();
        int occur = 0;
        for(int i = 0; i < dbPointer.getAll().size(); i++){
            if(dbPointer.get(i).getName().equals(tempName)) {
                occur++;
                dbPointer.deleteCustomer(i);
                i = 0;
            }
        }
        if(occur == 0) {
            System.out.println("Name not found in DB");
            return;
        }
        System.out.println("Name found " + occur + " time(s), each deleted.");
    }
    
    private void deleteByNum() {
        Scanner STDIN = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the phone number to look for:");
        String tempNum = STDIN.nextLine();
        int occur = 0;
        for(int i = 0; i < dbPointer.getAll().size(); i++){
            if(dbPointer.get(i).getNumber().equals(tempNum)) {
                occur++;
                dbPointer.deleteCustomer(i);
                i = 0;
            }
        }
        if(occur == 0) {
            System.out.println("Phone number not found in DB");
            return;
        }
        System.out.println("Phone number found " + occur + " time(s), each deleted.");
    }
    
    private void deleteByEmail(){
        Scanner STDIN = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the email to look for:");
        String tempEmail = STDIN.nextLine();
        int occur = 0;
        for(int i = 0; i < dbPointer.getAll().size(); i++){
            if(dbPointer.get(i).getMail().equals(tempEmail)) {
                occur++;
                dbPointer.deleteCustomer(i);
                i = 0;
            }
        }
        if(occur == 0) {
            System.out.println("Email not found in DB");
            return;
        }
        System.out.println("Email found " + occur + " time(s), each deleted.");
    }
    
    @Override
    public String toString() {
        return "Delete Customer";
    }
}
