// Testing certain account class methods

package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AccountTest {

    Bank testBank;
    Customer testCustomer;
    Account testAccount;
    double initialBalance;
    String testAccountDescription;

    @BeforeEach
    void createTestCustomer() {
        testBank = new Bank("Test Bank");
        testCustomer = new Customer(testBank, "User", "Test");
        initialBalance = 0.0;
        testAccount = new SavingsAccount(testCustomer, initialBalance, testAccountDescription);

    }

    @Test
    @DisplayName("Account.deposit Tests")
    void testDeposit() {
        //Sets up static variable for the first account
        double startingAccountAmount = 100.00;
        String accountDescription = "Rainy Day Fund";
        String customerFirstName = "Tim";
        String customerLastName = "Johnson";
        Bank theBigBank = new Bank("The Big Bank");


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

        //sets the static variables
        double amountToDeposit = 100.00;
        double accountStartingAmount = account.getBalance();
        //attempts to deposit
        account.deposit(amountToDeposit);

        //Checks the balance amount and compares it to the original amount
        assertEquals(accountStartingAmount + amountToDeposit, account.getBalance(), "Deposit Test Results");
    }

    @Test
    void testSmallDeposit() {
        double expectedResult = 1.0;
        double depositAmount = 1.0;
        testAccount.deposit(depositAmount);
        double actualResult = testAccount.getBalance();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testLargeDeposit() {
        double expectedResult = 10000.0;
        double depositAmount = 10000.0;
        testAccount.deposit(depositAmount);
        double actualResult = testAccount.getBalance();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMultipleDeposits() {
        double depositOne = 5.0;
        double depositTwo = 10.0;
        double depositThree = 35.0;
        double expectedResult = depositOne + depositTwo + depositThree;
        testAccount.deposit(depositOne);
        testAccount.deposit(depositTwo);
        testAccount.deposit(depositThree);
        double actualResult = testAccount.getBalance();
        assertEquals(expectedResult, actualResult);
    }


    @Test
    @DisplayName("Account.transfer Tests")
    void transfer() {
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
        Account accountTwo = new Account(tim, startingAccountAmount, accountTwoDescription) {
            public void deposit(double amount) {
                //Stub
            }

            public void withdraw(double amount) {
                //Stub
            }
        };
        //Checks and sets the initial variables to be compared later
        double startingAmount = accountTwo.getBalance();
        double transferAmount = 100.00;
        //Ensures there is a starting amount
        account.deposit(transferAmount);
        Account.transfer(account, accountTwo, transferAmount);
        assertEquals(startingAmount + transferAmount, accountTwo.getBalance(), "Transfer does not work ");
    }

    @Test
    @DisplayName("Account.withdraw Tests")
    void withdraw() {
        double startingAccountAmount = 200.00;
        // Create a dummy account
        Account acct = new Account(testCustomer, startingAccountAmount, "Personal Account") {
            @Override
            public void deposit(double amount) {
                //Stub
            }

            @Override
            public void withdraw(double amount) {
                //Stub
            }
        };
        double accountCurrentBalance = acct.getBalance();
        // Withdraw money
        double amountToWithdraw = 200.00;
        acct.withdraw(amountToWithdraw);
        // Check the account balance and make sure withdraw worked
        assertEquals(accountCurrentBalance - amountToWithdraw, acct.getBalance(), "Withdraw Test Results");
    }

}