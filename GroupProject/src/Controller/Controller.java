/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Menu.MainMenu;
import Model.*;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Cameron Patterson
 */
public class Controller {

    /**
     * This class holds the main method for the project and thus runs the menu which uses
     *   the functionality of the model package
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //Initialize Model
        CustomerDB mainDataB = new CustomerDB();
        
        //Load db file then add db file to DB
        ArrayList<Customer> client = new ArrayList<>();
        ArrayList<Tracker> userList = new ArrayList<>();
        //LoadData now requires an extra arrayList<Tracker> in its parameter to 
        //keep track of each files access/edit and returns a int pointing to 
        //its location in the list
        FileData.LoadData(client, userList);
        mainDataB.concatList(client);
        
        MainMenu menu = new MainMenu(mainDataB, userList);
        //start program loop
        menu.execute();
    }
    
}
