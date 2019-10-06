package application;
import java.time.LocalDate;

/**
 * Abstract Account class for employee login and business use. Contains all personal information and user login details.
 * @author Jonathon Shea
 * @version 1.0
 * @since 2019-10-04
 *
 */
public abstract class Account {
    private static int nextId = 1;
    private String address;
    private String hiringDate;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    /**
     * Constructor for the account class. Requires four parameters and sets the default password to 'Welcome1'
     * and sets the username to the next 6-digit number in the sequence incrementing from 1.
     * @param address This is the employee's address.
     * @param phoneNumber This is the employee's phone number.
     * @param firstName This is the employee's first name.
     * @param lastName This is the employee's last name.
     */
   
    public Account(String address, String phoneNumber, String firstName, String lastName){
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = "Welcome1";
        this.username = String.format("%06d", nextId++);
        LocalDate today = LocalDate.now();
        hiringDate = today.toString();

    }


    /**
     * Login method for an account. Checks the input username and password against the stored values.
     * @param username Username entered to be checked.
     * @param password Password entered to be checked.
     * @return Returns false is login is unsuccessful and true if login successful.
     */
    public boolean login(String username, String password){
        boolean correctLogin = false;
        if (username.contentEquals(this.username) &&  password.contentEquals(this.password)){
            correctLogin = true;
        }
        return correctLogin;
    }

    public String getUsername(){
        return this.username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHiringDate(){
        return hiringDate;
    }

    @Override
    public String toString() {
        StringBuilder accountDetails = new StringBuilder("Username: ");
        accountDetails.append(username);
        accountDetails.append('\n');
        accountDetails.append("Name: ");
        accountDetails.append(lastName);
        accountDetails.append(", ");
        accountDetails.append(firstName);
        accountDetails.append('\n');
        accountDetails.append("Address: ");
        accountDetails.append(address);
        accountDetails.append('\n');
        accountDetails.append("Phone Number: ");
        accountDetails.append(phoneNumber);
        accountDetails.append('\n');
        accountDetails.append("Hiring Date: ");
        accountDetails.append(hiringDate);
        accountDetails.append('\n');
        return accountDetails.toString();
    }
}
