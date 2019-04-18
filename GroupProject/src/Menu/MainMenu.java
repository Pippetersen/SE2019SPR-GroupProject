/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.CustomerDB;
import Model.Tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eric Petersen
 */
public final class MainMenu implements MenuInterface {
    //Menu objects to be used in the main menu
    private final
        AddCustomerMenu addCustMenu;
        DeleteCustomerMenu delCustMenu;
        DisplayCustomerListMenu displayCustMenu;
        DisplayProgramStats displayProgMenu;
        QuitMenu quitMenu;
        List<MenuInterface> menuList;
        
    private static CustomerDB dbPointer;
    private ArrayList<Tracker> trackerList;
        
    //Constructor for Main Menu, passes in a Customer DB and sets each menu up with that DB
    public MainMenu(CustomerDB tempDB, ArrayList<Tracker> tempTracker) {
        menuList = new ArrayList<>();
        dbPointer = tempDB;
        trackerList = tempTracker;
        addCustMenu = new AddCustomerMenu(dbPointer);
        delCustMenu = new DeleteCustomerMenu(dbPointer);
        displayCustMenu = new DisplayCustomerListMenu(dbPointer);
        displayProgMenu = new DisplayProgramStats(tempTracker);
        quitMenu = new QuitMenu(dbPointer, trackerList);
        //Always have at least the quit menu on the menu
        addToMainMenu(quitMenu);
        //Add the menu items for the first homework assignment
        addToMainMenu(addCustMenu);
        addToMainMenu(delCustMenu);
        addToMainMenu(displayCustMenu);
        addToMainMenu(displayProgMenu);
    }
    
    //Add a menu item to the list
    public void addToMainMenu(MenuInterface t) {
        menuList.add(t);
    }
    //Remove specific index item from the menu list; and returns the popped object
    public MenuInterface removeFromMainMenu(int i) {
        return menuList.remove(i);
    }
    
    //Display current menu items
    public void displayMenuItems() {
        for(int i = 0; i < menuList.size(); i++) {
            System.out.println(i + ": " + menuList.get(i));
        }
    }
    
    //Get a selection choice from user input
    public int getUserInput() {
        Scanner STDIN = new Scanner(System.in);

        if (menuList.size() > 1) {
            System.out.print("Enter a command number (0-" + 
                (menuList.size()-1) +
                "):");
            return STDIN.nextInt();
        }
        
        System.out.print("Enter a command number (0-0):");
        return STDIN.nextInt();
    }
  
    //Execute menu, traps the program in the menu list
    @Override
    public void execute() {
        while(true) {
            System.out.println("--Main Menu--");
            displayMenuItems();
            menuList.get(getUserInput()).execute();
        }
    }
    //toString method
    @Override
    public String toString() {
        return "Main Menu";
    }
    //Getter for List
    public List<MenuInterface> getMenuList() {
        return menuList;
    }
}
