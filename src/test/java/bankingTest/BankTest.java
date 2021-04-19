
package bankingTest;
import java.lang.*;
import banking.Bank;
import banking.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class BankTest {
    Bank bank = new Bank("Lynx");


    @Test
    void addCustomer() {
        final String firstName ="Lynx", lastName = "Leuck";
        String s = bank.addCustomer(firstName, lastName);
        String sadPath = bank.addCustomer("","");
        assertAll( "addCutomer Group",
                () -> assertNotNull(bank.getCustomer(s),"If there are names this is not null: " ),
                () -> assertNull(sadPath, "Should be Null because nothing was added"));

    }

    @Test
    void removeCustomer() {
        final String firstName ="Lynx", lastName = "Leuck";
        String s = bank.addCustomer(firstName, lastName);
        bank.removeCustomer(s);
        String id = bank.getCustomer(s).getCustomerId();
        assertNull("Is it crazy,", id);
    }

    @Test
    void testGetCustomer() {
        final String customerId = "0";
        final String firstName ="Lynx", lastName = "Leuck";
        String s = bank.addCustomer(firstName, lastName);
        assertEquals(s, bank.getCustomersAccounts(customerId), "Not The Sameee");

    }
}