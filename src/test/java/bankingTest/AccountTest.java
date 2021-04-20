package bankingTest;

import banking.Account;
import banking.Bank;
import banking.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AccountTest {
    //Sets up static variable for the first account
    double startingAccountAmount = 100.00;
    String accountDescription = "Rainy Day Fund";
    String customerFirstName = "Tim";
    String customerLastName = "Johnson";
    Bank theBigBank = new Bank("The Big Bank");

    //This is the one variable that needs to change for the account
    String accountTwoDescription = "Flight to the Moon";

    //Sets up the customer using the variables above
    Customer tim = new Customer(theBigBank, customerFirstName, customerLastName);

    //Sets up the first account and implements a few required methods
    Account account = new Account(tim, startingAccountAmount, accountDescription) {
        public void deposit(double amount) {
            //Stub
        }

        public void withdraw(double amount) {
            //Stub
        }
    };

    //Sets up the second account for testing against
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
        //sets the static variables
        double amountToDeposit = 100.00;
        double accountStartingAmount = account.getBalance();
        //attempts to deposit
        account.deposit(amountToDeposit);

        //Checks the balance amount and compares it to the original amount
        assertTrue(account.getBalance() == accountStartingAmount + amountToDeposit, "Deposit Test Results");
    }


    @Test
    void transfer() {
        //Checks and sets the initial variables to be compared later
        double startingAmount = accounttwo.getBalance();
        double transferAmount = 100.00;
        //Ensures there is a starting amount
        account.deposit(transferAmount);
        Account.transfer(account, accounttwo, transferAmount);
        assertEquals(startingAmount + transferAmount, accounttwo, "Transfer does not work ");
    }

}