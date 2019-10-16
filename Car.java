import java.util.*;
/**
 * This is a subclass of the vehicle class, it deals with data that is related to cars
 *
 * @author Ricards Augustauskis
 * Group 2
 */
public class Car extends Vehicle
{
    // This stores the bodyType of a car
    private String bodyType;
    // This stores the number of doors that the car has
    private int noOfDoors;
    // This stores the number of seats that the car has
    private int noOfSeats;
    // This is the constructor for the Car class
    public Car()
    {   
        // Calling the constructor of the super class
        super();
    }
    // This method overrides the printDetails() method from the Vehicle class
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Body type: "+bodyType);
        System.out.println("Number of doors: "+noOfDoors);
        System.out.println("Number of seats: "+noOfSeats);
    }
    // This method overrides the Vehicles readData() method
    @Override
    public void readData(Scanner scan)
    {   
        if(scan != null)
        {
            super.readData(scan);
            bodyType = scan.next();
            noOfDoors = scan.nextInt();
            noOfSeats = scan.nextInt();  
        }
    }
    // This returns the bodyType of a car 
    public String getBodyType()
    {
        return bodyType;
    }
    // This returns the number of doors that a car has
    public int getNoOfDoors()
    {
        return noOfDoors;
    }
    // This returns the number of seats that a car has
    public int getNoOfSeats()
    {
        return noOfSeats;
    }
}