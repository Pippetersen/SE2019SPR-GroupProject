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
        String currentUser;
        Tracker trackCurrentUser;
        ArrayList<Tracker> trackerList;
        
    private static CustomerDB dbPointer;
        
    //Constructor for Main Menu, passes in a Customer DB and sets each menu up with that DB
    public MainMenu(CustomerDB tempDB, ArrayList<Tracker> tempTracker) {
        menuList = new ArrayList<>();
        dbPointer = tempDB;
        
        if(tempTracker.size() > 0) {
            trackerList = tempTracker;
        } else {
            trackerList = new ArrayList<>();
        }
        getCurrentUser();
        int tempi = checkCurrentUser();
        if(tempi != -1) {
            trackCurrentUser = trackerList.get(tempi);
        } else {
            trackCurrentUser = new Tracker(currentUser);
            trackerList.add(trackCurrentUser);
        }
        
        addCustMenu = new AddCustomerMenu(dbPointer, trackCurrentUser);
        delCustMenu = new DeleteCustomerMenu(dbPointer, trackCurrentUser);
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
    
    //Get current user
    private void getCurrentUser() {
        System.out.println("Please input user name:");
        Scanner STDIN = new Scanner(System.in);
        currentUser = STDIN.nextLine();
    }
    
    //Check if current user already exists in usage list
    private int checkCurrentUser() {
        if (trackerList.isEmpty()) {
            return -1;
        }
        
        for(int i = 0; i < trackerList.size(); i++) {
                if(trackerList.get(i).getName().equals(currentUser)) {
                    return i;
                }
        }
        
        return -1;
    }
}
