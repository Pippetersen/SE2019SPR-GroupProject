/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

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
        QuitMenu quitMenu;
        List<MenuInterface> menuList;
    //This is an example
        
    //Constructor initializes each item
    public MainMenu() {
        menuList = new ArrayList<>();
        addCustMenu = new AddCustomerMenu();
        delCustMenu = new DeleteCustomerMenu();
        displayCustMenu = new DisplayCustomerListMenu();
        quitMenu = new QuitMenu();
        //Always have at least the quit menu on the menu
        addToMainMenu(quitMenu);
        //Add the menu items for the first homework assignment
        addToMainMenu(addCustMenu);
        addToMainMenu(delCustMenu);
        addToMainMenu(displayCustMenu);
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
        System.out.print("Enter a command number (0-" + menuList.size() +
                "):");
        return STDIN.nextInt();
    }
    
    @Override
    public void execute() {
        while(true) {
            System.out.println("--Main Menu--");
            displayMenuItems();
            menuList.get(getUserInput()).execute();
        }
    }
    
    @Override
    public String toString() {
        return "Main Menu";
    }
}
