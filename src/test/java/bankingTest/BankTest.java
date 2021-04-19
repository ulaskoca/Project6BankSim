
package bankingTest;
import java.lang.*;
import banking.Bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class BankTest {
    Bank bank;

    @Test
    void main() {

    }

    @Test
    public void getAllAccounts(){

    }

    @Test
    void addCustomerWizard() {
    }

    @Test
    void addCustomerandAddtoList() {
        final String firstName ="Lynx", lastName = "Leuck";
        bank.addCustomer(firstName, lastName);
        assertNotNull("If there are names this is not null: ", bank.getCustomer(firstName, lastName));
    }

    @Test
    void removeCustomer() {
        final String customerId = "1";
        bank.removeCustomer(customerId);
        assertNull("",bank.getCustomer(customerId));
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void testGetCustomer() {
    }

    @Test
    void getCustomersAccounts() {
        final String customerId = "1";
        assertNotNull(bank.getCustomersAccounts(customerId));
    }
}