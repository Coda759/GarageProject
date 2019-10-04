package model;


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
     * Takes 5 parameters 4 of which are employee information and generates a new account and adds it to the bag.
     * The last parameter denotes whether or not the account is an attendant or manager.
     * @param address
     * @param phoneNumber
     * @param firstName
     * @param lastName
     * @param isManager If true account is created as a manager class; if false account as attendant class.
     */
    public void addAccount(String address, String phoneNumber, String firstName, String lastName, Boolean isManager){
        Account newAccount;
        if(isManager)
            newAccount = new Manager(address, phoneNumber, firstName, lastName);
        else
            newAccount = new Attendant(address, phoneNumber, firstName, lastName);


    }


}
