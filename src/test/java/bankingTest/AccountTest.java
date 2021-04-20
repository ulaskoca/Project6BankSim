package bankingTest;

import banking.Account;
import banking.Bank;
import banking.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AccountTest {
    double startingAccountAmount = 100.00;
    String accountDescription = "Rainy Day Fund";
    String accountTwoDescription = "Flight to the Moon";
    String customerFirstName = "Tim";
    String customerLastName = "Johnson";
    Bank theBigBank = new Bank("The Big Bank");
    Customer tim = new Customer(theBigBank, customerFirstName, customerLastName);
    Account account = new Account(tim, startingAccountAmount, accountDescription) {
        public void deposit(double amount) {
            //Stub
        }

        public void withdraw(double amount) {
            //Stub
        }
    };
    Account accounttwo = new Account(tim, startingAccountAmount, accountTwoDescription) {
        public void deposit(double amount) {
            //Stub
        }

        public void withdraw(double amount) {
            //Stub
        }
    };

    @Test
    void testDeposit() {
        double amountToDeposit = 100.00;
        double accountStartingAmount = account.getBalance();
        account.deposit(amountToDeposit);
        assertTrue(account.getBalance() == accountStartingAmount + amountToDeposit, "Deposit Test Results");
    }


    @Test
    void transfer() {
        double startingAmount = accounttwo.getBalance();
        double transferAmount = 100.00;
        //Ensures there is a starting amount
        account.deposit(transferAmount);
        Account.transfer(account, accounttwo, transferAmount);
        assertEquals(startingAmount + transferAmount, accounttwo, "Transfer does not work ");
    }

}