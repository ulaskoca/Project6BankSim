package bankingTest;

import banking.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {


    @Test
    void addCustomer() {
        //Sets up bank to be used
        Bank bank = new Bank("Lynx");
        final String firstName = "Lynx", lastName = "Leuck";

        //Adds the customer, or attempts to and grabs the name
        String s = bank.addCustomer(firstName, lastName);
        assertNotNull(bank.getCustomer(s), "If there are names this is not null: ");

        //adds null variables to test if it gets added
        String sadPath = bank.addCustomer(null, null);
        assertNull(sadPath, "Should be Null because nothing was added");

    }

    @Test
    void removeCustomer() {
        //Sets up bank to be used
        Bank bank = new Bank("Lynx");
        final String firstName = "Lynx", lastName = "Leuck";

        //adds a customer and saves the ID in S, then removes it by the ID then checks if it still exists
        String s = bank.addCustomer(firstName, lastName);
        bank.removeCustomer(s);
        assertNull(bank.getCustomer(s), "Customer has not been removed");
    }

    @Test
    void testGetCustomer() {

        //Sets up bank to be used
        Bank bank = new Bank("Lynx");
        final String customerId = "0";
        final String firstName = "Lynx", lastName = "Leuck";

        //Adds the customer and grabs the ID, then checks if the customer equals the id 0
        //Because I wanted one thing that functioned
        String s = bank.addCustomer(firstName, lastName);
        assertEquals(s, bank.getCustomersAccounts(customerId), "Not The Same");

    }
}