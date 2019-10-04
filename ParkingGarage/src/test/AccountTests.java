package test;
import model.Account;
import model.Attendant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTests {
    private  Account testAccount = new Attendant("123 test ave. NY 12345", "555-555-5555", "Jonny", "Test");

    @Test
    @DisplayName("Accounts can only login using correct login password.")
    void loginRequiresCorrectPassword(){
        assertFalse(testAccount.login("000001", "Wrong password"), "Login returned true with incorrect password");
        assertTrue(testAccount.login("000001", "Welcome1"), "Login returned false with correct password");
    }

    @Test
    @DisplayName("Accounts can only login using correct login account.")
    void loginRequiresCorrectUsername(){
        assertTrue(testAccount.login("000002", "Welcome1"), "Login returned true with incorrect username");
        assertFalse(testAccount.login("000001", "Welcome1"), "Login returned false with correct username");
    }

}
