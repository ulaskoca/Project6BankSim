// Testing certain account class methods

package bankingTest;

import banking.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    // Static variables to start our tests
    double startingAccountAmount = 200.00;

    @Test
    @DisplayName("Account.deposit Tests")
    void deposit() {
        // Create a dummy account
        Account acct = new Account("Ulas", startingAccountAmount, "Personal Account");
        double accountCurrentBalance = acct.getBalance();
        // Deposit money
        double amountToDeposit = 200.00;
        acct.deposit(amountToDeposit);
        // Check the account balance and make sure deposit worked
        assertEquals(accountCurrentBalance + amountToDeposit, acct.getBalance(), "Deposit Test Results");
    }

    @Test
    @DisplayName("Account.withdraw Tests")
    void withdraw() {
        // Create a dummy account
        Account acct = new Account("Ulas", startingAccountAmount, "Personal Account");
        double accountCurrentBalance = acct.getBalance();
        // Withdraw money
        double amountToWithdraw = 200.00;
        acct.withdraw(amountToWithdraw);
        // Check the account balance and make sure withdraw worked
        assertEquals(accountCurrentBalance - amountToWithdraw, acct.getBalance(), "Wirthdraw Test Results");
    }

    @Test
    @DisplayName("Account.transfer Tests")
    void transfer() {
        // Create two dummy accounts
        Account acct1 = new Account("Ulas", startingAccountAmount, "Personal Account");
        Account acct2 = new Account("Lynx", startingAccountAmount, "Personal Account");
        double account2CurrentBalance = acct2.getBalance();
        // Transfer money
        double amountToTransfer = 200.00;
        Account.transfer(acct1, acct2, amountToTransfer);
        // Check if the transfer worked correctly
        assertEquals(account2CurrentBalance - amountToTransfer, acct2.getBalance(), "Transfer Test Results");
    }
}