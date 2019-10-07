package application;

import java.util.HashMap;

/**
 * Bag for holding receipt objects implemented with a HashMap.
 */
public class ReceiptBag {
    private HashMap<String, Receipt> receipts;

    public   ReceiptBag()
    {
        receipts = new HashMap();
    }

    /**
     * Generates and adds a receipt using a ticket object.
     * @param ticket
     */
    public void add(Ticket ticket){
        Receipt receipt = new Receipt(ticket);
        receipts.put(receipt.getReceiptId(), receipt);
    }
    /**
     * Searches for the specified receipt using the ticket's ID.
     * @param query
     * @return Returns the receipt details if found. Otherwise not found message.
     */
    public String search(String query){
        Receipt receipt = receipts.get(query);
        String message;
        if(receipt != null)
            message = receipt.toString();
        else
            message = "Receipt not found.";
        return message;
    }

    public String getAmountDue(String query){
        return receipts.get(query).getAmountDueString();
    }
}