/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.Tracker;
import java.util.ArrayList;

/**
 *
 * @author Eric Petersen
 */
public class DisplayProgramStats implements MenuInterface {
    private final ArrayList<Tracker> trackerList;
    
    DisplayProgramStats(ArrayList<Tracker> tempTracker) {
        trackerList = tempTracker;
    }
    
    @Override
    public void execute() {
        if(trackerList.size() != 0) {
            System.out.println("Displaying all uses of program:");
            for(int i = 0; i < trackerList.size(); i++) {
                System.out.println(trackerList.get(i).toString());
            }
        } else {
            System.out.println("No history exists");
        }
        System.out.println();
    }
    
    //To string for menu items
    @Override
    public String toString() {
        return "Display Program History";
    }
    
}
