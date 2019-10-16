import java.util.*;
/**
 * This class is used to test if the code is working properly
 *
 * @author Ricards Augustauskis
 * Group 2
 */
public class Test
{   
    // This is the constructor for the test class
    public Test()
    {
        // Here we try creating a new vehicle 
        // Vehicle vehicle = new Vehicle("A, TF-61273, MJ09TFD, Fiat");
        
        // Here we test the printDetails() method
        // vehicle.printDetails();

        // Here we test if the method readVehicleData() prints the content of the vehicle_data_1.txt to the terminal
        // ReservationSystem reservationSystem = new ReservationSystem();
        // reservationSystem.readVehicleData();        
        
        // If the method readVehicleData() works then test the method printAllVehicles()
        // reservationSystem.printAllVehicles();

        // Here we check the method readVehicleData() but do not select a file,close the FileDialog
        // reservationSystem.readVehicleData();
        
        // Here we check and see what happens if there is no data and we call the method printAllVehicles()
        // reservationSystem.printAllVehicles();

        // Create a testScanner with data and check if the method readData() from the Vehicle class
        // Scanner testScanner = new Scanner("C, TF-67358, NR59GHM, Ford");

        //Here we create a vehicle and read the data
        //Vehicle vehicle = new Vehicle();
        //vehicle.readData(testScanner);
        //Here we print the data to the terminal and see if readData(testScanner) worked as expected
        //vehicle.printDetails();

        //Here we test the method readData(testScanner2) after we added the additional field  
        // Scanner testScanner2 = new Scanner("AA, TF-63403, MJ09TDA, Fiat, Panda Active Eco, No, 1.1, Unleaded, five-speed manual, FWD, 13584, 29-07-2009, Hatchback, 5, 5");
        // Vehicle vehicle2 = new Vehicle();
        // vehicle2.readData(testScanner2);
        // vehicle2.printDetails();

        // Here we test if the method readVehicleData() works properly
        // reservationSystem.readVehicleData();
        // reservationSystem.printAllVehicles();

        // Here we test if the method readCustomerData() reads the data properly
        // reservationSystem.readCustomerData();
        // reservationSystem.printAllCustomers();

        // Here we test if writeCustomerData() works properly
        // Customer customer = new Customer("James, Howard, E, Mr");
        // reservationSystem.writeCustomerData("empty.txt");

        // Here we test if the Customer constructor works properly
        // Customer customer = new Customer("James, Howard, E, Mr");
        // System.out.println(customer.getCustomerID()+", "+customer.getSurname()+
        // ", "+customer.getFirstName()+", "+customer.getOtherInitials()+", "+customer.getTitle());

        // Here we test what is going to happen if we select a non .txt file
        // reservationSystem.readVehicleData();

        // Here we test what is going to happen if we select a non .txt file
        // reservationSystem.readCustomerData();

        // Here we test if the generateCustomerID() method works properly
        // ReservationSystem reservationSystem = new ReservationSystem();
        // reservationSystem.generateCustomerID("AB-", 6);

        // Here we test if the getVehicle() and getCustomer() methods are working properly
        // ReservationSystem reservationSystem = new ReservationSystem();
        // reservationSystem.readVehicleData();
        // reservationSystem.getVehicle("GH-68002");
        // reservationSystem.readCustomerData();
        // reservationSystem.getCustomer("AB-154278");
        
        // Here we test if we are able to write the customer data to a text file
        // reservationSystem.writeCustomerData(empty.txt);
        // reservationSystem.readCustomerData(empty.txt);
        // reservationSystem.printAllCustomers();

        // Here we test if the methods in the DateUtil class work properly
        // DateUtil date = new DateUtil();
        // System.out.println(date.convertStringToDate("Friday, 25 January 2016"));
        // System.out.println(date.isLeapYear(1999));
        // System.out.println(date.isValidDateString("12-03-2016"));  
        
        // Here we test if the "upgraded" ReservationSystem class works properly
        // ReservationSystem res = new ReservationSystem("res");
        // res.readVehicleData("vehicle_data_2.txt");
        // res.readCustomerData("customer_data.txt");
        // res.printAllCustomers();
        
        // Here we test if the number padder method works properly
        // System.out.println(res.reservationNumberPadder(3));
        
        // Here we test if the reservationnumber generator works properly
        // System.out.println(res.generateReservationNo());
        
        // Here we test if the getFilePathForSave() method works properly.
        // ReservationSystem res = new ReservationSystem("res");
        // System.out.println(res.getFilePathForSave());
        
        // Here we test if we are able to write a vehicle reservation and close down the system.
        // ReservationSystem reservation_system = new ReservationSystem("reservation_system");
        // reservation_system.readVehicleData("vehicle_data_2.txt");
        // reservation_system.readCustomerData("customer_data.txt");
        // DateUtil date = new DateUtil();
        // reservation_system.makeVehicleReservation("AB-681723", TF-64810, 26-04-2019, 4);
        // reservation_system.closeDownSystem();
        
        // Here we check if we are able to reload the system.
        // ReservationSystem reservation_system = new ReservationSystem("reservation_system");
        // reservation_system.reloadSystem();
        // reservation_system.printAllCustomers();
        // reservation_system.printAllVehicles();
        // reservation_system.printAllVehicleReservations();
        
        // Here we test if we are able to read vehicle reservation data.
        // ReservationSystem reservation_system = new ReservationSystem("reservation_system");
        // reservation_system.readVehicleReservationData("reservation_system_vehicle_reservation_dump");
        // reservation_system.printAllVehicleReservations();
        
        // Here we test what happens if we give incorrect data to the makeVehicleReservation() method.
        // ReservationSystem reservation_system = new ReservationSystem("reservation_system");
        // reservation_system.readVehicleData("vehicle_data_2.txt");
        // reservation_system.readCustomerData("customer_data.txt");
        // DateUtil date = new DateUtil();
        // reservation_system.makeVehicleReservation("AB-881723", TF-69810, 35-04-2019, -1);
        
        // Here we test if the get methods in the ReservationSystem work properly.
        // ReservationSystem reservation_system = new ReservationSystem("reservation_system");
        // reservation_system.readVehicleData("vehicle_data_2.txt");
        // reservation_system.readCustomerData("customer_data.txt");
        // System.out.println(reservation_system.getNumberOfVehicles());
        // System.out.println(reservation_system. getNumberOfCustomers());
        // reservation_system.readVehicleReservationData("reservation_system_vehicle_reservation_dump");
        // System.out.println(reservation_system.getNumberOfVehicleReservations());
    }    
}