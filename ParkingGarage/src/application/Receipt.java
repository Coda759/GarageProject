package application;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Receipt class, holds a Ticket object the parked duration and total cost.
 * @author Jonathon Shea
 *
 */
public class Receipt {
    private Ticket ticket;
    private long parkDuration;
    private double total;

    /**
     * Constructor uses a ticket object to calculate total due and park duration.
     * @param ticket
     */
    public Receipt(Ticket ticket){
        this.ticket = ticket;
        calculateTotal(ticket.getParkTime());
    }


    private void calculateTotal(String parkTime){
        LocalTime now = LocalTime.now();
        LocalTime parked = LocalTime.parse(parkTime);
        parkDuration = SECONDS.between(parked, now);
        double parkDurationHours = parkDuration / 3600;
        total = parkDurationHours * ticket.getRate();

    }

    public String getReceiptId(){
        return ticket.getTicketId();
    }


    @Override
    public String toString() {
        StringBuilder receiptPrintout = new StringBuilder(this.ticket.toString());
        receiptPrintout.append("\nParking duration: ");
        receiptPrintout.append(parkDuration);
        receiptPrintout.append("\nTotal due: ");
        receiptPrintout.append(total);
        return receiptPrintout.toString();
    }
}
