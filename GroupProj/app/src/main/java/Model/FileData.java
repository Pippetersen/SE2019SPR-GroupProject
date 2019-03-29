package Model;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.Scanner;


/**
 *
 * @author clone-sniper
 */
public class FileData {
/*   To be later altered for custom file name
    //Function to retrieve name of file to be used
    public static String getFileName()
    {
        Scanner in = new Scanner(System.in);      
        System.out.println("Enter name for file");
        String name = in.nextLine();
                   
        return name;
    }
*/
    //Loads Customer data from "Customer's Data.txt" , for Context parameter, use "this"
    public static void LoadData(CustomerDB custDBObj, Context context) throws IOException, ClassNotFoundException
    {
        File root = new File(Environment.getExternalStorageDirectory(),"Customer's Data.txt");
        if(root.exists())
        {
            try {
                FileInputStream in =  new FileInputStream(root);
                ObjectInputStream is = new ObjectInputStream(in);
                Customer holder = null;
                while (in.available() > 0)    //Loads each object individually  into ArrayList until essentially end of file
                {
                    holder = (Customer) is.readObject();
                    custDBObj.addCustomer(holder);
                }
                is.close();
                in.close();
                Toast.makeText(context,"File Loaded", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                Toast.makeText(context,"File didn't load", Toast.LENGTH_SHORT).show();
            }
        }
        else
            Toast.makeText(context,"No previous file", Toast.LENGTH_SHORT).show();

    }

    //Saves Customer Data to a Byte File called "Customer's Data.txt" , for Context parameter, use "this"
    public static void SaveData(CustomerDB custDBObj, Context context) throws IOException
    {
       File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "Customer's Data.txt");
            try
            {
                ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(root));
                for(Customer hold : custDBObj.getAll())                     //Loads all of objects into specified file
                {
                s.writeObject(hold);
                s.flush();                    
                }
                s.close();
            }
            catch (FileNotFoundException e)                  //If no name is entered, file is by deafult called "Customer File"
            {
                Toast.makeText(context,"File  doesn't exist", Toast.LENGTH_SHORT).show();
            }
            catch (IOException e)
            {
                Toast.makeText(context,"File failed to save", Toast.LENGTH_SHORT).show();
            }
            if(root.exists())
                Toast.makeText(context,"File saved", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context,"File failed to save", Toast.LENGTH_SHORT).show();
    }    
}