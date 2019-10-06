package application;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Ticket class for holding all information regarding a parked car.
 * @author Jonathon Shea
 */
public class Ticket {
    private String ticketId;
    private String carId;
    private String date;
    private String attendantId;
    private double rate;
    private String spotId;
    private String parkTime;


    public Ticket(String carId, String attendantId, double rate, String spotId) {
        this.carId = carId;
        this.attendantId = attendantId;
        this.rate = rate;
        this.spotId = spotId;
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        this.date = today.toString();
        this.parkTime = time.toString();
        generateId();
    }


    private void generateId(){
        StringBuilder id = new StringBuilder(this.attendantId);
        id.append(this.date.replaceAll("-", "").trim());
        id.append(this.parkTime.replaceAll(":","").trim());
        id.append(carId.trim());
        id.append(attendantId.trim());
        this.ticketId = id.toString();
    }

    public String getTicketId(){
        return ticketId;
    }

    public String getParkTime(){
        return parkTime;
    }

    public double getRate(){
        return this.rate;
    }

    @Override
    public String toString() {
        StringBuilder ticketPrintout = new StringBuilder("Ticket ID: ");
        ticketPrintout.append(ticketId);
        ticketPrintout.append("\nAttendant ID: ");
        ticketPrintout.append(attendantId);
        ticketPrintout.append("\nVehicle ID: ");
        ticketPrintout.append(carId);
        ticketPrintout.append("\nParking Spot: ");
        ticketPrintout.append(spotId);
        ticketPrintout.append("\nPark Time: ");
        ticketPrintout.append(parkTime);
        ticketPrintout.append("| Park Date: ");
        ticketPrintout.append(date);
        ticketPrintout.append("\nRate: ");
        ticketPrintout.append(rate);
        return ticketPrintout.toString();

    }
}
