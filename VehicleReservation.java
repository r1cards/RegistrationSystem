import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * This class is able to create a Vehicle Reservation, which includes the reservation number, the vehicles ID, the customers ID, the reservations start date
 * and the number of days that the reservation will be held  
 *
 * @author Ricards Augustauskis
 * Group 2
 */
public class VehicleReservation
{
    // This stores the reservation number
    private String reservationNo;
    // This stores the vehicleID
    private String vehID;
    // This stores the customerID
    private String customerID;
    // This stores the date of the first day of the reservation
    private Date startDate;
    // This stores the duration of the reservation
    private int noOfDays;
    // This is the constructor for the VehicleReservation class without any parameters
    public VehicleReservation()
    {

    }
    // This is the constructor for the VehicleReservation class with parameters
    public VehicleReservation(String reservationNo, String vehID, String customerID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.vehID = vehID;
        this.customerID = customerID;
        if(DateUtil.isValidDateString(startDate))
        {
            this.startDate = DateUtil.convertStringToDate(startDate);
        } 
        else
        {
            this.startDate = null;
        }
        this.noOfDays = noOfDays;        
    }    
    // This method returns the reservation number
    public String getReservationNo()
    {
        return reservationNo;
    }
    // This method returns the vehicle ID
    public String getVehID()
    {
        return vehID;
    }
    // This method returns the start date
    public Date getStartDate()
    {
        return startDate;
    }
    // This method returns the number of days 
    public int getNoOfDays()
    {
        return noOfDays;
    }
    // This method prints out the details of a reservation
    public void printDetails()
    {   
        System.out.println();
        System.out.println("Reservation Number: "+reservationNo);
        System.out.println("Vehicle ID: "+vehID);
        System.out.println("Customer ID: "+customerID);
        System.out.println("Start Date: "+reservationNo);
        System.out.println("Number of Days: "+noOfDays);        
    }
    // This method writes reservation data onto a text file
    public void writeData(PrintWriter pWriter)
    {   
        String lineOfOutput = getReservationNo()+", "+getVehID()+
            ", "+customerID+", "+getStartDate()+", "+getNoOfDays();      
        pWriter.println(lineOfOutput);        
    }
    // This method reads reservation data from a text file 
    public void readData(Scanner scan)
    {   
        if(scan != null)
        {
            reservationNo = scan.next();
            vehID = scan.next();
            customerID = scan.next();
            reservationNo = scan.next();
            noOfDays = scan.nextInt();
            scan.close();            
        }
    }
    // This is the vehicle reservations to string method 
    public String toString()
    {
        return String.format("Reservation Number: %s, Vehicle ID: %s, Customer ID: %s, Start date: %s, Number of days: %s",
            reservationNo,vehID,customerID,DateUtil.convertDateToShortString(startDate),noOfDays);
    }
}