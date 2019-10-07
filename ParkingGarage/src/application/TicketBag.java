package application;

import java.util.HashMap;

/**
 * Class hold multiple ticket objects using a HashMap with the ticket id as the key field.
 * @author Jonathon Shea
 * @version 1.0
 */
public class TicketBag {
    private HashMap<String, Ticket> tickets;

    /**
     * Default constructor creates an empty HashMap
     */
    public   TicketBag(){
        tickets = new HashMap();
    }

    /**
     * Generates and adds a ticket object using the provided parameters.
     * @param carId
     * @param attendantId
     * @param rate
     * @param spotId
     * @return Returns the new ticketId
     */
    public String add(String carId, String attendantId, double rate, String spotId){
        Ticket ticket = new Ticket(carId, attendantId, rate, spotId);
        tickets.put(ticket.getTicketId(), ticket);
        return ticket.getTicketId();
    }

    /**
     * Searches for the specified ticket using its ID.
     * @param query
     * @return Returns the ticket details if found. Otherwise not found message.
     */
    public String search(String query){
        Ticket ticket = tickets.get(query);
        String message;
        if(ticket != null)
            message = ticket.toString();
        else
            message = "Ticket not found.";
        return message;
    }
}
