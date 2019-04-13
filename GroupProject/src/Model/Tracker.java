/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author clone-sniper
 */
public class Tracker {
    private String name;
    private int accessed, edit;
    
    Tracker(String _name,int acc, int edt)
    {
        name = _name;
        accessed = acc;
        edit = edt;
    }
    Tracker(String _name)
    {
        name = _name;
        accessed = 0;
        edit = 0;
    }
    
    int getAccess()
    {
        return accessed;
    }
    
    int getEdit()
    {
        return edit;
    }
    
    void FileAccessed()
    {
        accessed++;
    }
    
    void FileEdit()
    {
        edit++;
    }
    
    @Override
    public String toString() 
    {
        return name + "\nAccessed: " + accessed + "+nEdited: " + edit;
    }
}
