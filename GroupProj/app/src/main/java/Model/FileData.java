package Model;

import android.content.Context;
import android.util.Log;

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
/*   currently not in use
    //Function to retrieve name of file to be used
    public static String getFileName()
    {
        Scanner in = new Scanner(System.in);      
        System.out.println("Enter name for file");
        String name = in.nextLine();
                   
        return name;
    }
*/
    //Loads Customer data from Byte File , use getApplicationContext() as parameter for context
    public static void LoadData(ArrayList<Customer> client, Context context) throws IOException, ClassNotFoundException
    {
        File file = context.getFileStreamPath("Customer's Data.txt");
        if(file != null)
        {
            try {
                FileInputStream in = context.openFileInput("Customer's Data.txt");
                ObjectInputStream is = new ObjectInputStream(in);
                Customer holder = null;
                while (in.available() > 0)    //Loads each object individually  into ArrayList until essentially end of file
                {
                    holder = (Customer) is.readObject();
                    client.add(holder);
                }
                is.close();
                in.close();
            } catch (FileNotFoundException e) {
                Log.e("Exception", "File read failed: " + e.toString());
            }
        }

    }

    //Saves Customer Data to a Byte File, , use getApplicationContext() as parameter for context
    public static void SaveData(ArrayList<Customer> client, Context context) throws IOException
    {
            try
            {

                ObjectOutputStream s = new ObjectOutputStream(context.openFileOutput("Customer's Data.txt", Context.MODE_PRIVATE));
                for(Customer hold : client)                     //Loads all of objects into specified file
                {
                s.writeObject(hold);
                s.flush();                    
                }
                s.close();
            }
            catch (FileNotFoundException e)                  //If no name is entered, file is by deafult called "Customer File"
            {
                Log.e("Exception", "File write failed: " + e.toString());
            }
    }    
}