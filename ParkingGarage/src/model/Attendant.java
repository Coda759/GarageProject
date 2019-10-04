package model;
/**
 * Attendant class for employee login and business use. Contains all personal information and user login details.
 * @author Jonathon Shea
 * @version 1.0
 *
 */
public class Attendant extends Account {
    /**
     * Constructor for the account class. Requires three parameters and sets the default password to 'Welcome1'
     * and calls the generateUsername method to generate a username.
     *
     * @param address     This is the employee's address.
     * @param phoneNumber This is the employee's phone number.
     * @param firstName   This is the employee's first name.
     * @param lastName    This is the employee's last name.
     */
    public Attendant(String address, String phoneNumber, String firstName, String lastName) {
        super(address, phoneNumber, firstName, lastName);
    }
}
