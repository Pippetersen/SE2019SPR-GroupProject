/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Model.CustomerDB;
import Model.FileData;
import java.io.IOException;

/**
 *
 * @author Eric Petersen
 */
public class QuitMenu implements MenuInterface   {
    private static CustomerDB dbPointer;
    
    public QuitMenu(CustomerDB tempDB) {
        dbPointer = tempDB;
    }
    
    @Override
    public void execute() {
        FileData tempData = new FileData();
        try {
            //SavaData requires an arrayList<Tracker> parameter to save trackign data 
            tempData.SaveData(dbPointer.getAll());
        } catch(IOException ex) {
            System.out.println("WARNING! Error Saving while exiting!");
            System.out.println(ex.toString());
        }
        System.exit(0);
    }
    
    @Override
    public String toString() {
        return "Quit";
    }
}
