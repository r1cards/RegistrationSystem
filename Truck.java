import java.util.*;
/**
 * This is a subclass of the commercial class, it deals with data that is related to trucks
 *
 * @author Ricards Augustauskis
 * Group 2
 */
public class Truck extends Commercial
{
    // This will store the different 
    private ArrayList<String> attributes;   
    // This is the constructor for the Truck class
    public Truck()
    {
       // Calling the constructor of the super class
       super();
       attributes = new ArrayList<>();
    }
    // This method overrides the printDetails() method in the super class
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Attributes: ");
        for(String attribute: attributes)
        {
            System.out.println("- "+attribute);
        }              
    }
    // This method overrides the readData() method in the super class
    @Override
    public void readData(Scanner scan)
    {   
        if(scan != null)
        {               
            super.readData(scan);
            while(scan.hasNext())
            {
                attributes.add(scan.next());
            }
        }
    }
}