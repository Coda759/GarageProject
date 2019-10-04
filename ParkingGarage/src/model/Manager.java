package model;

/**
 * Manager employee account; retains all functions of a standard account but allows the manager to perform actions
 * on other employees and set garage parameters.
 * @author Jonathon Shea
 * @version 1.0
 */
public class Manager extends Account {
    /**
     * Constructor for the account class. Requires three parameters and sets the default password to 'Welcome1'
     * and calls the generateUsername method to generate a username.
     *
     * @param address     This is the employee's address.
     * @param phoneNumber This is the employee's phone number.
     * @param firstName   This is the employee's first name.
     * @param lastName    This is the employee's last name.
     */
    public Manager(String address, String phoneNumber, String firstName, String lastName) {
        super(address, phoneNumber, firstName, lastName);
    }
}
