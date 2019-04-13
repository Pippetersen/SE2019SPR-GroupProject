package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.Scanner;


/**
 *
 * @author clone-sniper
 */
public class FileData {

    //Function to retrieve name of file to be used
    public static String getFileName()
    {
        Scanner in = new Scanner(System.in);      
        System.out.println("Enter name for file");
        String name = in.nextLine();
                   
        return name;
    }

    //Loads Customer data from Byte File 
    public static int LoadData(ArrayList<Customer> client,ArrayList<Tracker> track) throws IOException, ClassNotFoundException
    {   
        String name = getFileName();
        File temp = new File(name);
        if(temp.exists())   //Checks if a file exist and loads the data if it does
        {
            FileInputStream in = null;
            Customer holder = null;
        try 
        {
            in = new FileInputStream(name);
            ObjectInputStream s = new ObjectInputStream(in);

            while(in.available() > 0)    //Loads each object individually  into ArrayList until essentially end of file
            {
               holder = (Customer)s.readObject();
               client.add(holder);
            }    
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File for Customer Data not Found");
        } 
        finally 
        {
            try 
            {
                in.close();
            } catch (IOException ex) 
            {
                System.out.println("File failed to close");
            }
        }
        }
        else
        System.out.println("No Existing Data");
       
        temp = new File("Access_Tracker"); //Checks if a file the contains the access data exist
        if(temp.exists())   
        {
            FileInputStream in = null;
            Tracker holder = null;
        try 
        {
            in = new FileInputStream("Access_Tracker");
            ObjectInputStream s = new ObjectInputStream(in);

            while(in.available() > 0)    //Loads each object individually  into ArrayList until essentially end of file
            {
               holder = (Tracker)s.readObject();
               track.add(holder);
            } 
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File for Tracking Customer Data not Found");
        } 
        finally 
        {
            try 
            {
                in.close();
            } catch (IOException ex) 
            {
                System.out.println("File failed to close");
            }
        }
        }
        else
        System.out.println("No Existing Tracking Data");
        
        if(track.contains(name))
            return track.indexOf(name);
        else 
        {
            Tracker hold = new Tracker(name);
            track.add(hold);
            return 0;
        }
            
    }
    //Saves Customer Data to a Byte File

    public static void SaveData(ArrayList<Customer> client, ArrayList<Tracker> track) throws IOException
    {
            FileOutputStream f = null;
            FileOutputStream t = null;
            try 
            {
                f = new FileOutputStream(getFileName());
                ObjectOutput s = new ObjectOutputStream(f);
                for(Customer hold : client)                     //Loads all of objects into specified file
                {
                s.writeObject(hold);
                s.flush();                    
                }
            } 
            catch (FileNotFoundException ex)                  //If no name is entered, file is by deafult called "Customer File"
            {
                f = new FileOutputStream("Customer File");   
                ObjectOutput s = new ObjectOutputStream(f);
                for(Customer hold : client)                     //Loads all of objects into specified file
                {
                s.writeObject(hold);
                s.flush();
                }
            } 
            try
            {
                t = new FileOutputStream("Access_Tracker");
                ObjectOutput o = new ObjectOutputStream(t);
                for(Tracker hold : track)                     //Loads all of objects into specified file
                {
                o.writeObject(hold);
                o.flush();                    
                }                
            }
            catch (FileNotFoundException ex)    
            {
                System.out.println("Saving Tracker Failed");
            }
            f.close();
            t.close();
    }    
}