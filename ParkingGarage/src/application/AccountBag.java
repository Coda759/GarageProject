package application;


import java.util.HashMap;
import java.util.Map;

/**
 * Holds account objects using a HashSet keyed by username.
 * @author Jonathon Shea
 * @version 1.0
 */
public class AccountBag {
    private Map<String, Account> accountMap;
    private Account activeAccount;

    /**
     * Default constructor. Initializes an empty HashMap.
     */
    public AccountBag(){
        accountMap = new HashMap<>();
        this.generateDefaultAccount();
    }



    /**
     * Login method that checks for the provided username and if found attempts to login.
     * If login is successful it sets the active account to the called account.
     * @param username Username entered to be checked.
     * @param password Password entered to be checked.
     * @return Returns true on a successful login and false when unsuccessful.
     */
    public boolean login(String username, String password){
        boolean loginSuccess = false;
        if(accountMap.containsKey(username)){
            Account account = accountMap.get(username);
            loginSuccess = account.login(username, password);
            if(loginSuccess)
                this.activeAccount = account;
        }

        return loginSuccess;
    }

    /**
     * Sets the active account to null.
     */
    public void logout(){
        activeAccount = null;
    }


    /**
     * Takes 5 parameters 4 of which are employee information and generates a new account and adds it to the bag.
     * The last parameter denotes whether or not the account is an attendant or manager.
     * @param address
     * @param phoneNumber
     * @param firstName
     * @param lastName
     * @param isManager If true account is created as a manager class; if false account as attendant class.
     */
    public String addAccount(String address, String phoneNumber, String firstName, String lastName, Boolean isManager){
        Account newAccount;
        if(isManager)
            newAccount = new Manager(address, phoneNumber, firstName, lastName);
        else
            newAccount = new Attendant(address, phoneNumber, firstName, lastName);
        this.accountMap.put(newAccount.getUsername(), newAccount);
        return newAccount.toString();
    }

    /**
     * Method for updating an account; Finds an account by id and sets all other fields to the input values if found.
     * Does not update values with empty strings or null.
     * @param id Id to be queried to update account.
     * @param password New password.
     * @param address New Address.
     * @param phoneNumber New phone number.
     * @param firstName New First Name.
     * @param lastName New Last Name.
     * @return
     */
    public boolean updateAccount(String id, String password, String address, String phoneNumber, String firstName, String lastName){
        Account account = accountMap.get(id);
        boolean accountUpdated = false;
        if(account != null){
            if(checkInputIsNotEmpty(address))
                account.setAddress(address);
            if(checkInputIsNotEmpty(firstName))
                account.setFirstName(firstName);
            if(checkInputIsNotEmpty(lastName))
                account.setLastName(lastName);
            if(checkInputIsNotEmpty(phoneNumber))
                account.setPassword(phoneNumber);
            if(checkInputIsNotEmpty(password))
                account.setPassword(password);
            accountUpdated = true;
        }
        return accountUpdated;
    }


    private boolean checkInputIsNotEmpty(String input){
        return input != null && !input.trim().contentEquals("");
    }


    public String search(String query){
        Account account = accountMap.get(query);
        String message;
        if(account != null)
            message = account.toString();
        else
            message = "Account not found.";
        return message;
    }

    public String delete(String query){
        String message;
        if(accountMap.remove(query) != null)
            message = "Account deleted.";
        else
            message = "Account not found.";
        return message;
    }

    /**
     * Method for checking if active account is a manager account.
     * @return Returns true if the active account is a manager.
     */
    public boolean getIsManager(){
        return activeAccount instanceof Manager;
    }

    /**
     * Generates a default manager account with the phone number and address of SCCC Ammerman campus and the name Admin Admin.
     * Due to the nature of the class the username id will be 000001
     */
    private void generateDefaultAccount() {
        this.addAccount("533 College Rd, Selden, NY 11784", "(631) 451-4110", "Admin", "Admin", true);
    }

    public String getActiveId(){
        return activeAccount.getUsername();
    }



}
