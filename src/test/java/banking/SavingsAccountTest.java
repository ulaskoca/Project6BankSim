package banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {


    @Test
    void deposit() {
        //Sets up static variable for the first account
        double startingAccountAmount = 100.00;
        String accountDescription = "Rainy Day Fund";
        String customerFirstName = "Tim";
        String customerLastName = "Johnson";
        Bank theBigBank = new Bank("The Big Bank");


        //Sets up the customer using the variables above
        Customer tim = new Customer(theBigBank, customerFirstName, customerLastName);
        SavingsAccount savingsAccountOne = new SavingsAccount(tim,startingAccountAmount,accountDescription);
        //sets the static variables
        double amountToDeposit = 100.00;
        double accountStartingAmount = savingsAccountOne.getBalance();
        //attempts to deposit
        savingsAccountOne.deposit(amountToDeposit);

        //Checks the balance amount and compares it to the original amount
        assertEquals(accountStartingAmount + amountToDeposit, savingsAccountOne.getBalance(), "Deposit Test Results");

    }

    @Test
    void withdraw() {
        //Sets up static variable for the first account
        double startingAccountAmount = 100.00;
        String accountDescription = "Rainy Day Fund";
        String customerFirstName = "Tim";
        String customerLastName = "Johnson";
        Bank theBigBank = new Bank("The Big Bank");

        //Sets up the customer using the variables above
        Customer tim = new Customer(theBigBank, customerFirstName, customerLastName);
        SavingsAccount savingsAccountOne = new SavingsAccount(tim,startingAccountAmount,accountDescription);
        //sets the static variables
        double amountToWithdraw = 100.00;
        double accountStartingAmount = savingsAccountOne.getBalance();
        //attempts to deposit
        savingsAccountOne.withdraw(amountToWithdraw);

        //Checks the balance amount and compares it to the original amount
        assertEquals(accountStartingAmount - amountToWithdraw, savingsAccountOne.getBalance(), "Withdraw Test Results");

    }

    @Test
    void addInterestTransaction() {
        //Sets up static variable for the first account
        double startingAccountAmount = 100.00;
        String accountDescription = "Rainy Day Fund";
        String customerFirstName = "Tim";
        String customerLastName = "Johnson";
        Bank theBigBank = new Bank("The Big Bank");

        //Sets up the customer using the variables above
        Customer tim = new Customer(theBigBank, customerFirstName, customerLastName);
        SavingsAccount savingsAccountOne = new SavingsAccount(tim,startingAccountAmount,accountDescription);
        //Set up static variables for test
        double currentBalance = savingsAccountOne.getBalance();
        double amountToPayOff = 100.00;

        //attempts to add to the interest rate
        savingsAccountOne.addInterestTransaction(amountToPayOff);
        //Checks the difference between the two
        assertEquals(currentBalance - amountToPayOff, savingsAccountOne.getBalance(), "Payment Was not Successful Test Results");


    }
}