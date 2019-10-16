import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * This class deals with customer personal data
 *
 * @author Ricards Augustauskis
 * Group 2
 */
public class Customer
{
    // This stores the customers ID
    private String customerID;
    // This stores the customers surname
    private String surname;
    // This stores the customers first name
    private String firstName;
    // This stres the customers other initials
    private String otherInitials;
    // This stores the customers title
    private String title;
    // This is one of the constructors for the Customer class
    public Customer()
    {
        
    }
    // This is a constructor for the Customer class which takes in 4 parameters 
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
        customerID = "unknown";
    }
    // This method prints out the details of each customer
    public void printDetails()
    {   
        System.out.println(title+" "+otherInitials+" "+surname+" "+firstName);
        System.out.println("Customer ID: "+customerID);    
        System.out.println();
    }
    // This method read customer data from a .txt file
    public void readData(Scanner scan)
    {   
        if(scan != null)
        {
            customerID = scan.next();
            surname = scan.next();
            firstName = scan.next();
            otherInitials = scan.next();
            title = scan.next();
            scan.close();            
        }
    }
    // This method is used to set a pattern in which the data will be written onto a .txt file
    public void writeData(PrintWriter pWriter)
    {   
        String lineOfOutput = getCustomerID()+", "+getSurname()+
            ", "+getFirstName()+", "+getOtherInitials()+", "+getTitle();         
        pWriter.println(lineOfOutput);        
    }
    // This method returns the a customers ID 
    public String getCustomerID()
    {
        return customerID;
    }
    // This method returns the surname of a customer
    public String getSurname()
    {
        return surname;
    }
    // This method returns the first name of a customer
    public String getFirstName()
    {
        return firstName;
    }
    // This method returns the initials of a customer
    public String getOtherInitials()
    {
        return otherInitials;
    }
    // This method returns a customers title
    public String getTitle()
    {
        return title;
    }
    // This method is used to set a customers ID
    public void setCustomerID(String customerID)
    {
        this.customerID = customerID;
    }
}