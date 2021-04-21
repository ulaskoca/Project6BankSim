package banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void addSavingsAccount() {
        //Initializes customer
        String customerFirstName = "Tim";
        String customerLastName = "Johnson";
        Bank theBigBank = new Bank("The Big Bank");
        Customer tim = new Customer(theBigBank, customerFirstName, customerLastName);
        //Initializes account
        double initBal = 100.00;
        String desc = "Bug Money";

        //Because this was not a complete program this does not return the correct values
        //This once an account is opened it should return a number or at least return a savings account
        SavingsAccount timsSavingsAccount = tim.addSavingsAccount(initBal, desc);

        assertNotNull(timsSavingsAccount, "The account was not created, don don don");

    }

    @Test
    void removeAccount() {
        //Initializes customer
        String customerFirstName = "Tim";
        String customerLastName = "Johnson";
        Bank theBigBank = new Bank("The Big Bank");
        Customer tim = new Customer(theBigBank, customerFirstName, customerLastName);
        //Initializes account
        double initBal = 100.00;
        String desc = "Bug Money";

        SavingsAccount timsSavingsAccount = tim.addSavingsAccount(initBal, desc);
        tim.removeAccount(timsSavingsAccount.getAccountId());

        assertNull(timsSavingsAccount, "The account was not created, don don don");

    }


    @Test
    void compareTo() {
        //Initializes customer
        String customerFirstName = "Tim";
        String customerLastName = "Johnson";
        Bank theBigBank = new Bank("The Big Bank");
        Customer tim = new Customer(theBigBank, customerFirstName, customerLastName);

        //Initializes customer Jim
        String customerFirstNameTwo = "Jim";
        String customerLastNameTwo = "Tohnson";
        Bank theBigBankTwo = new Bank("The Bigger Bank");
        Customer jim = new Customer(theBigBankTwo, customerFirstNameTwo, customerLastNameTwo);

        //Happy Path
        assertEquals(-1, tim.compareTo(jim), "The two Accounts are not identical but Match.");

        //Initializes customer Jim
        customerFirstNameTwo = "Tim";
        customerLastNameTwo = "Johnson";
        theBigBankTwo = new Bank("The Big Bank");
        jim = new Customer(theBigBankTwo, customerFirstNameTwo, customerLastNameTwo);

        //Happy Path
        assertEquals(0, tim.compareTo(jim), "The two Accounts are identical but Not Match.");

    }
}