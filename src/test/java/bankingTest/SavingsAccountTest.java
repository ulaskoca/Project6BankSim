package bankingTest;

import banking.Bank;
import banking.Customer;
import banking.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
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
    SavingsAccount savingsAccountOne = new SavingsAccount(tim,startingAccountAmount,accountDescription);
    SavingsAccount savingsAccountTwo = new SavingsAccount(tim,startingAccountAmount,accountTwoDescription);

    @Test
    void deposit() {
        //sets the static variables
        double amountToDeposit = 100.00;
        double accountStartingAmount = savingsAccountOne.getBalance();
        //attempts to deposit
        savingsAccountOne.deposit(amountToDeposit);

        //Checks the balance amount and compares it to the original amount
        assertTrue(savingsAccountOne.getBalance() == accountStartingAmount + amountToDeposit, "Deposit Test Results");

    }

    @Test
    void withdraw() {
        //sets the static variables
        double amountToWithdraw = 100.00;
        double accountStartingAmount = savingsAccountOne.getBalance();
        //attempts to deposit
        savingsAccountOne.withdraw(amountToWithdraw);

        //Checks the balance amount and compares it to the original amount
        assertTrue(savingsAccountOne.getBalance() == accountStartingAmount - amountToWithdraw, "Withdraw Test Results");

    }

    @Test
    void addInterestTransaction() {

        //Set up static variables for test
        double currentBalance = savingsAccountOne.getBalance();
        double amountToPayOff = 100.00;

        //attempts to add to the interest rate
        savingsAccountOne.addInterestTransaction(amountToPayOff);
        //Checks the difference between the two
        assertTrue(savingsAccountOne.getBalance() == currentBalance - amountToPayOff, "Payment Was not Successful Test Results");


    }
}