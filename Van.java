import java.util.*;
/**
 * This is a subclass of the commercial class, it deals with data that is related to vans
 *
 * @author Ricards Augustauskis
 * Group 2
 */
public class Van extends Commercial
{
    // This stores the load volume of a van
    private double loadVolume;
    // This stores the data on whether or not a can has a sliding side door
    private boolean slidingSideDoor;
    // This is the constructor for the Van class
    public Van()
    {
        // Calling the constructor of the super class
        super();           
    }
    // This method returns the load volume of a van
    public double getLoadVolume()
    {
        return loadVolume;
    }
    // This method returns true or false depending on whether or not a van has a sliding door
    public boolean getSlidingSideDoor()
    {
        return slidingSideDoor;
    }
    // This method overrides the printDetails() method from the 
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Load volume: "+loadVolume);
        System.out.println("Sliding doors: "+convertStringToBoolean(slidingSideDoor));        
    }
    // This method overrides the readData() method in the super class
    @Override
    public void readData(Scanner scan)
    {   
        if(scan != null)
        {
            super.readData(scan);
            loadVolume = new Double(scan.next());
            slidingSideDoor = convertToBoolean(scan.next());
        }
    }    
}