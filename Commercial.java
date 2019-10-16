import java.util.*;
/**
 * This is a subclass of the vehicle class, it deals with data that is related to commercial vehicles
 *
 * @author Ricards Augustauskis
 * Group 2
 */
public abstract class Commercial extends Vehicle
{
    // This stores the payload of a vehicle
    private int payload;
    // This is the constructor for the Commercial class
    public Commercial()
    {
      // Calling the constructor of the super class
      super(); 
    }
    // This overrides the readData() method in the super class
    @Override
    public void readData(Scanner scan)
    {
        if(scan != null)
        {
            super.readData(scan);
            payload = scan.nextInt();                        
        }
    }
    // This overrides the printDetails() method in the super class
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Payload: "+payload+" kg");
    }
    // This returns the payload ammount
    public int getPayload()
    {
        return payload;
    }
}