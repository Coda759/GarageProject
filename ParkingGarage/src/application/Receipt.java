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
    private double amountDue;

    /**
     * Constructor uses a ticket object to calculate amount due and park duration.
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
        amountDue = (double)parkDuration * ticket.getRate() / 3600;

    }

    public String getReceiptId(){
        return ticket.getTicketId();
    }


    @Override
    public String toString() {
        StringBuilder receiptPrintout = new StringBuilder(this.ticket.toString());
        receiptPrintout.append("\nParking duration: ");
        receiptPrintout.append(parkDuration);
        receiptPrintout.append("\nAmount due: ");
        receiptPrintout.append(amountDue);
        return receiptPrintout.toString();
    }

    public String getAmountDueString(){
        return String.format("$%.2f",amountDue);
    }
}
