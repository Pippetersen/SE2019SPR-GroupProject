package Model;

import java.io.Serializable;


/**
 *
 * @author clone-sniper
 */
public class Customer implements Serializable{
    private String Name, Email, PhoneNumber;
    
    //Constructor
    public Customer(String name, String mail, String number)
    {
        Name = name;
        Email = mail;
        PhoneNumber = number;
    }
    public Customer() {
       Name = null;
       Email = null;
       PhoneNumber = null;
    }
    //Getters
    public String getName()
    {
        return Name;
    }
    public String getMail()
    {
        return Email;
    }
    public String getNumber()
    {
        return PhoneNumber;
    }
    //Setters
    public void setName(String name)
    {
        Name = name;
    }
    public void setMail(String mail)
    {
        Email = mail;
    }
    public void setPhoneNumber(String number)
    {
        PhoneNumber = number;
    }

    @Override
    public String toString() {
        return " | Customer Name: " + Name + "\n | Customer Phone Number: " + PhoneNumber + "\n | Customer Email: " + Email;
    }
}
