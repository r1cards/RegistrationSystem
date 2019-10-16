import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * This class is able to create ReservationSystem, it can read data about vehicles and customers from text files and write that data down. 
 *
 * @author Ricards Augustauskis
 * Group 2
 */
public class ReservationSystem
{   
    // This arrayList is used to store data on vehicles
    //private ArrayList<Vehicle> vehicleList;
    // This arrayList is used to store data on customers
    //private ArrayList<Customer> customerList;
    // This is the constructor or the reservation system
    private Map<String, VehicleReservation> vehicleReservationMap;
    // This HashMap is used to store data on vehicles
    private Map<String, Vehicle> vehicleMap;
    // This HashMap is used to store data on customers
    private Map<String, Customer> customerMap;
    // This is a private field of type Random
    private Random randomGenerator;
    // This is a private field of type boolean
    private boolean firstCallToGenerateReservationNo;
    // This stores the last reservation number
    private int lastReservationNumber;
    // This stores the file name, of a file where the last reservation number is stored"
    private String lastNumberGeneratedFileName;
    // This is a private field of type Diary
    private Diary diary;
    // This stores the file name, of a file where customer data is "dumped"
    private String dumpCustomerDataFileName;
    // This stores the file name, of a file where vehicle reservation data is "dumped"
    private String dumpVehicleReservationDataFileName;
    // This is the constructor or the reservation system
    public ReservationSystem(String reservationSystemName)
    {
        //vehicleList = new ArrayList<Vehicle>();
        //customerList = new ArrayList<Customer>();
        vehicleMap = new HashMap<String, Vehicle>();
        customerMap = new HashMap<String, Customer>();
        vehicleReservationMap = new HashMap<String, VehicleReservation>();
        randomGenerator = new Random();
        firstCallToGenerateReservationNo = true;
        lastReservationNumber = 0;
        dumpCustomerDataFileName = reservationSystemName + "_customer_dump.txt";
        lastNumberGeneratedFileName = "last_number_generated.txt";
        dumpVehicleReservationDataFileName = reservationSystemName + "_vehicle_reservation_dump.txt";
    }
    // This method closes down the reservation system by writing all of the customer and vehicle reservation data to the "dump" files
    public void closeDownSystem()
    {
        writeCustomerData(dumpCustomerDataFileName);
        writeVehicleReservationData(dumpVehicleReservationDataFileName);
    }
    // This method reloads the reservation system by reading customer and vehicle reservation data from the "dump" files
    public void reloadSystem()
    {
        readCustomerData(dumpCustomerDataFileName);
        readVehicleReservationData(dumpVehicleReservationDataFileName);
    }
    // This method returns the number of vehicles
    public int getNumberOfVehicles()
    {
        return vehicleMap.size();
    }
    // This method returns the number of customers
    public int getNumberOfCustomers()
    {
        return customerMap.size();
    }
    // This method returns the number of reservations
    public int getNumberOfVehicleReservations()
    {
        return vehicleReservationMap.size();
    }
    // Prints all of the vehicles and their details
    public void printAllVehicles()
    {
        //for(Vehicle vehicle : vehicleList)
        //{
        //    vehicle.printDetails();
        //}
        for(String vehicleID : vehicleMap.keySet())
        {
            Vehicle vehicle = vehicleMap.get(vehicleID);
            vehicle.printDetails();
        }
    }
    // This method reads vehicle data from a text file
    public void readVehicleData(String fileName){
        try
        {
            String typeOfData = "";
            File file = new File(fileName);
            Scanner read = new Scanner(file);
            while(read.hasNextLine())
            {                
                String lineOfText = read.nextLine().trim();                               
                if(lineOfText.startsWith("["))
                {
                    typeOfData = lineOfText.toLowerCase();                    
                }
                else if(!lineOfText.startsWith("//") && lineOfText.length() != 0)
                {
                    Scanner scan = new Scanner(lineOfText);
                    scan.useDelimiter("\\s*,\\s*");
                    //System.out.println(typeOfData);
                    Vehicle vehicle = null;
                    switch(typeOfData)
                    {
                        case "[car data]":                        
                        vehicle = new Car();
                        vehicle.readData(scan);                                
                        storeVehicle(vehicle);
                        break;
                        case "[van data]":
                        vehicle = new Van();
                        vehicle.readData(scan);                               
                        storeVehicle(vehicle);
                        break;
                        case "[truck data]":
                        vehicle = new Truck();
                        vehicle.readData(scan);
                        storeVehicle(vehicle);
                        break;
                    }                    
                }
            }                
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }        
    }
    // This method reads the car details from a file
    public void readVehicleData()
    {
        readVehicleData(getFilePath());
    }
    // This method stores customers to customerList
    private void storeCustomer(Customer customer)
    {   
        //customerList.add(customer);       
        customerMap.put(customer.getCustomerID(), customer);       
    }
    // This method stores customers to vehicleList
    private void storeVehicle(Vehicle vehicle)
    {   
        //vehicleList.add(vehicle);       
        vehicleMap.put(vehicle.getVehId(), vehicle);       
    }
    // This method prints out all of the customers that are in the customerList
    public void printAllCustomers()
    {
        //for(Customer customer : customerList)
        //{
        //    customer.printDetails();
        //}
        for(String customerID : customerMap.keySet())
        {
            Customer customer = customerMap.get(customerID);
            customer.printDetails();
        }
    }
    // This method reads customer data from a text file
    public void readCustomerData(String fileName){
        try
        {   File file = new File(fileName);        
            Scanner read = new Scanner(file);
            while(read.hasNextLine())   
            {                
                String lineOfText = read.nextLine().trim(); 
                if(!lineOfText.startsWith("//") && lineOfText.length() != 0)                
                {                    
                    Scanner scan = new Scanner(lineOfText);
                    scan.useDelimiter("\\s*,\\s*");
                    Customer customer = new Customer();
                    customer.readData(scan);
                    customer.setCustomerID(generateCustomerID("AB-", 6));
                    storeCustomer(customer);                            
                }                    
            }                
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);        
        }            
    }
    // This method reads data from a .txt file
    public void readCustomerData()
    {
        readCustomerData(getFilePath());
    }
    // Thi method writes customer data to a text file
    public void writeCustomerData()
    {
        writeCustomerData(getFilePathForSave());
    }
    // This method can write customer data to a .txt file
    public void writeCustomerData(String fileName)
    {
        try
        {
            PrintWriter pWriter = new PrintWriter(fileName);
            //for(Customer customer: customerList)
            //{               
            //    customer.writeData(pWriter);
            //}
            for(String customerID : customerMap.keySet())            
            {  
                Customer customer = customerMap.get(customerID);
                customer.writeData(pWriter);
            }
            pWriter.close();
            System.out.println("Data has been successfuly written to "+fileName+" file.");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }        
    }
    // This method generates a random customerID that is a certain length
    private String generateCustomerID(String prefix, int length)
    {
        String id = prefix;
        do
        {
            id = prefix;
            // This generates a random number of a given length
            for(int r = 0; r<length; r++)
            {           
                int number = randomGenerator.nextInt(10);  
                id = id+number;
            } 
            //System.out.println(id);
        }
        while(!validateID(id));         
        return id;                  
    }
    // This method validates the id of a customer that it is unique
    private boolean validateID(String id)
    {
        for(String customerID : customerMap.keySet())
        {
            Customer customer = customerMap.get(customerID);
            if(customer.getCustomerID().equals(id))
            {                  
                return false;
            }            
        }
        return true;
    }
    // This method returns a vehicle with a specific ID
    public Vehicle getVehicle(String id)
    {
        Vehicle vehicle = vehicleMap.get(id);
        return vehicle;
    }
    // This method returns a customer with a specific ID
    public Customer getCustomer(String id)
    {
        Customer customer = customerMap.get(id);
        return customer;
    }
    // This method opens a fileDialogBox, where the user is able to select a file, and then the method returns the path to that file
    private String getFilePath()
    {
        Frame frame = null;
        FileDialog filebox = new FileDialog(frame,"Open", FileDialog.LOAD);            
        filebox.setVisible(true);        
        String filePath = filebox.getFile();
        if(filePath.contains(".txt"))
        {
            //File datafile = new File(filebox.getFile());
            System.out.println("Data has been successfully read from "+filePath+" file.");
            return filePath;
        }
        else
        {
            System.out.println("Please select a text document!"); 
        }
        return null;
    }
    // This mothed stores a vehicle in a reservation map
    private void storeVehicleReservation(VehicleReservation vehicleReservation)
    {           
        diary.addReservation(vehicleReservationMap.put(vehicleReservation.getReservationNo(), vehicleReservation));       
    }
    // This method generates a random reservation number
    public String generateReservationNo()
    {
        if (firstCallToGenerateReservationNo)
        {
            int randomNumber = randomGenerator.nextInt(10);
            lastReservationNumber = randomNumber;
        }
        else
        {
            lastReservationNumber++;
        }
        if(validateReservationNo(lastReservationNumber))
        {
            return reservationNumberPadder(lastReservationNumber+""); 
        }else 
        {
            return  generateReservationNo();
        }
    }
    // This method writes a reservation number to the lastReservationNumber text file
    private void writeReservationNumber(int reservationNumber) 
    {
        try
        {
            PrintWriter pWriter = new PrintWriter("lastReservationNumber.txt");
            pWriter.write(reservationNumber);
            pWriter.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }                              
    }
    // This method will pad the reservation number out with "0"
    private String reservationNumberPadder(String generatedNumber)
    {   
        while(generatedNumber.length()<=5)
        {            
            generatedNumber = "0"+generatedNumber;
        }
        return generatedNumber;
    }
    // This method makes a vehicle reservation
    public boolean makeVehicleReservation(String customerID, String vehID, String startDate, int noOfDays)
    {
        String reservationNo = generateReservationNo()+"";
        // Here we check if the customer with that ID exists
        if(vehicleMap.get(customerID)==null)
        {
            System.out.println("There is no customer with "+customerID+" id number.");
            return false;
        }
        // Here we check if a vihicle with a given ID actually exists
        if(vehicleMap.get(vehID)==null)
        {
            System.out.println("There is no vehicle with "+vehID+" id number.");
            return false;
        }
        // Here we check if the startDate is valid
        if (DateUtil.isValidDateString(startDate)) {
            VehicleReservation vehicleReservation = new VehicleReservation(reservationNo, vehID, customerID, startDate, noOfDays);
            vehicleReservationMap.put(reservationNo, vehicleReservation);
            return true;
        }
        return false;
    }
    // This method returns a vehicle reservation 
    public VehicleReservation getVehicleReservation(String reservationNo)
    {
        VehicleReservation vehicleReservation = vehicleReservationMap.get(reservationNo);
        if(vehicleReservation != null)
        {
            return vehicleReservation;
        }
        else
        {
            System.out.println("This reservation does not exist.");
            return null;
        }
    }
    // This method writes vehicle reservation data on to a text file
    public void wrtieVehicleReservationData()
    {
        writeVehicleReservationData(getFilePathForSave());
    }
    // This method is used to write vehicle reservation data to a text file
    public void writeVehicleReservationData(String fileName)
    {
        try
        {
            PrintWriter pWriter = new PrintWriter(fileName);
            //for(Customer customer: customerList)
            //{               
            //    customer.writeData(pWriter);
            //}
            for(String reservationNumber : vehicleReservationMap.keySet())            
            {  
                VehicleReservation vehicleReservation = vehicleReservationMap.get(reservationNumber);
                vehicleReservation.writeData(pWriter);
            }
            pWriter.close();
            System.out.println("Data has been successfuly written to "+fileName+" file.");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }        
    }
    // This method prints out all of the vehicle reservations
    public void printAllVehicleReservations()
    {
        for(String reservationNumber : vehicleReservationMap.keySet())
        {
            VehicleReservation vehicleReservation = vehicleReservationMap.get(reservationNumber);
            vehicleReservation.printDetails();
        }
    }
    // This method reads vehicle resvation data from a text file
    public void readVehicleReservationData(String fileName)
    {
        try
        {   File file = new File(fileName);        
            Scanner read = new Scanner(file);
            while(read.hasNextLine())
            {                
                String lineOfText = read.nextLine().trim(); 
                if(lineOfText.length() != 0)                
                {                    
                    Scanner scan = new Scanner(lineOfText);
                    scan.useDelimiter("\\s*,\\s*");
                    VehicleReservation vehicleReservation = new VehicleReservation();
                    vehicleReservation.readData(scan);
                    storeVehicleReservation(vehicleReservation);                            
                }                    
            }                
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);        
        }        
    }
    // This method reads vehicle reservations from a text file
    public void readVehicleReservationData()
    {
        readVehicleReservationData(getFilePath());
    }
    // This method prints out all of the diary entries
    public void printDiaryEntries(String startDate, String endDate)
    {
        if (DateUtil.isValidDateString(startDate))
        {
            if (DateUtil.isValidDateString(endDate))
            {
                //convert the Strings to Date objects
                Date start = DateUtil.convertStringToDate(startDate);
                Date end = DateUtil.convertStringToDate(endDate);
                diary.printEntries(start, end);
            }
            else
            {
                System.out.println("End date is invalid. Enter the date like this: dd-mm-yyyy");
            }
        }
        else
        {
            System.out.println("End date is invalid. Enter the date like this: dd-mm-yyyy");
        }
    }
    // This method removes a vehicle reservation
    public void deleteVehicleReservation(String reservationNumber)
    {        
        if (vehicleReservationMap.get(reservationNumber) != null)
        {
            diary.deleteReservation(vehicleReservationMap.get(reservationNumber));
            vehicleReservationMap.remove(reservationNumber);
        }
        else
        {
            System.out.println("Reservation does not exist");
        }
    }    
    // This method checks if a generated reservation number is unique
    private boolean validateReservationNo(int reservationNo)
    {
        for(String reservationNumber : vehicleReservationMap.keySet())
        {
            VehicleReservation vehicleReservation = vehicleReservationMap.get(reservationNumber);
            if(vehicleReservation.getReservationNo().equals(reservationNo))
            {                  
                return false;
            }            
        }
        return true;
    }
    // This method returns a filepath 
    private String getFilePathForSave()
    {
        Frame frame = null;
        FileDialog saveFileDialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        saveFileDialog.setDirectory("C:\\Users\\ricards\\Desktop\\java_project");
        saveFileDialog.setVisible(true);
        String filePath = saveFileDialog.getFile();
        // Here we check if the user has entered the correct file type
        if(!filePath.contains(".txt"))
        {
            filePath += ".txt";
        }
        return filePath;
    }
} 