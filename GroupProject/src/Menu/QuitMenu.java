/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author Eric Petersen
 */
public class QuitMenu implements MenuInterface  {

    @Override
    public void execute() {
        //Need to implement saving DB off before closing
        System.exit(0);
    }
    
    @Override
    public String toString() {
        return "Quit";
    }
}
