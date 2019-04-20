/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author clone-sniper
 */
public class Tracker implements Serializable {
    private String name;
    private int accessed, edit;
    
    public Tracker(String _name,int acc, int edt)
    {
        name = _name;
        accessed = acc;
        edit = edt;
    }
    public Tracker(String _name)
    {
        name = _name;
        accessed = 0;
        edit = 0;
    }
    
    public int getAccess()
    {
        return accessed;
    }
    
    public int getEdit()
    {
        return edit;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void FileAccessed()
    {
        accessed++;
    }
    
    public void FileEdit()
    {
        edit++;
    }
    
    @Override
    public String toString() 
    {
        return name + "\nAccessed: " + accessed + "+\nEdited: " + edit;
    }
}
