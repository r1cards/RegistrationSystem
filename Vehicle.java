import java.util.*;
/**
 * This is an abstract class that has data about vehicles, such as the a vehicles ID, model, engine size, etc.
 * 
 * @author Ricards Augustauskis
 * Group 2
 */
public abstract class Vehicle
{
    // This stores the group of the vehicle
    private String group;
    // This stores the Id of the vehicle
    private String vehId;
    // This stores the regNo of a vehicle
    private String regNo;
    // This stores the maker of a vehicle
    private String make;
    // This stores the model of the vehicle
    private String model;
    // This can tell us if the vehicle has an aircon/climate control
    private boolean airCon;
    // This stores the size of the engine in litres
    private double engineSize;
    // This stores the fuel type of a vehicle
    private String fuelType;
    // This stores the type of gearbox the vehicle has 
    private String gearbox;
    // This stores data on the vehicles transmission
    private String transmission;
    // This stores the vehicles mileage
    private int mileage;
    // This stores the date at which the car was first registered
    private String dateFirstRegistered;       
    // This is the constructor for the Vehicle Class
    public Vehicle()
    {
       
    }
    // This method seperates individual parts of each line of data
    public void readData(Scanner scan)
    {   
        if(scan != null)
        {
            group = scan.next();                   
            vehId = scan.next();
            regNo = scan.next();
            make = scan.next();
            model = scan.next();
            airCon = convertToBoolean(scan.next());            
            engineSize = new Double(scan.next());            
            fuelType = scan.next();
            gearbox = scan.next();
            transmission = scan.next();
            mileage = scan.nextInt();
            dateFirstRegistered = scan.next();                        
        }
    }
    // Returns the group
    public String getGroup()
    {
        return group;
    }
    // Returns the vehicle ID
    public String getVehId()
    {
        return vehId;
    }
    // Returns the regNo
    public String getRegNo()
    {
        return regNo;
    }
    // Returns the Maker
    public String getMake()
    {
        return make;
    }
    // Returns the model
    public String getModel()
    {
        return model;
    }
    // Here we can check if the aircon is present in a vehicle
    public boolean getAirCon()
    {
        return airCon;
    }
    // Returns the engine size
    public double getEngineSize()
    {
        return engineSize;
    }
    // Returns the fuel type
    public String getFuelType()
    {
        return fuelType;
    }
    // Returns the gearbox 
    public String getGearbox()
    {
        return gearbox;
    }
    // Returns the transmission
    public String getTransmission()
    {
        return transmission;
    }
    // Returns the mileage
    public int getMileage()
    {
        return mileage;
    }
    // Returns the date the car was first registered
    public String getDateFirstRegistered()
    {
        return dateFirstRegistered;
    }
    // Prints the details of a single vehicle
    public void printDetails()
    {   
        System.out.println();
        System.out.println(model+"    Group: "+group+"    Vehicle Id: "+vehId);
        System.out.println("Air conditioning/Climate Control: "+convertStringToBoolean(airCon));
        System.out.println("Engine Size: "+engineSize+"    Fuel: "+fuelType);
        System.out.println("Gearbox: "+gearbox+"    Transmission: "+transmission);        
        System.out.println("Mileage: "+mileage+"    Date first registered: "+dateFirstRegistered);
    }
    // Converts the string to boolean
    public boolean convertToBoolean(String bool)
    {
        return bool.trim().equalsIgnoreCase("yes");
    }
    // Converts boolean to string
    public String convertStringToBoolean(boolean airCon)
    {
        if(airCon == true)
        {
            return "Yes";
        }
        else
        {
            return "No";
        }
    }
}