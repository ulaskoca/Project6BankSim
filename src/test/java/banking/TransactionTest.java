package banking;

import org.junit.jupiter.api.Test;
import static banking.TransactionType.*;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {


    @Test
    void compareTo() {

        //Initializes all of the First transactions items to be easily changed
        TransactionType transactionTypeOne = DEPOSIT;
        double amountOne = 100.00;
        String descriptionOne = "Blah";

        Transaction transactionOne = new Transaction(transactionTypeOne,amountOne,descriptionOne);

        //Initializes all of the Second Transactions items to be easily changed
        TransactionType transactionTypeTwo = WITHDRAWAL;
        double amountTwo = 300.00;
        String descriptionTwo = "Panda";

        Transaction transactionTwo = new Transaction(transactionTypeTwo,amountTwo,descriptionTwo);

        //Sad Path test
        assertEquals(-1 ,transactionOne.compareTo(transactionTwo),"The two Transactions should not match but Do");

        //Re- initializes the second transaction to check if its identical
        transactionTypeTwo = DEPOSIT;
        amountTwo = 100.00;
        descriptionTwo = "Blah";
        transactionTwo = new Transaction(transactionTypeTwo,amountTwo,descriptionTwo);

        //Happy Path
        assertEquals(0 ,transactionOne.compareTo(transactionTwo),"The two Transactions are identical but dont Match.");

    }
}