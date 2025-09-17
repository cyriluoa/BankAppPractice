import org.example.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTest {


    @Test
    void testDepositIncreasesBalance(){
        BankAccount AliceAccount = new BankAccount("Alice", 100.00);
        AliceAccount.deposit(50.00);
        double balance = AliceAccount.getBalance();
        assertEquals(150.00,balance);
    }

    @Test
    void testDepositNegativeAmount(){
        BankAccount bobAccount = new BankAccount("Bob", 100.00);
        assertThrows(IllegalArgumentException.class, () -> {
            bobAccount.deposit(-10.0);
        });
    }

    @Test
    void testWithdrawDecreasesBalance(){
        BankAccount charlieAccount = new BankAccount("Charlie", 300.00);
        charlieAccount.withdraw(120.00);
        double balance = charlieAccount.getBalance();
        assertEquals(180.00, balance);
    }

    @Test
    void testWithdrawMoreThanBalance(){
        BankAccount danaAccount = new BankAccount("Dana", 50.00);
        assertThrows(IllegalStateException.class, () -> {
            danaAccount.withdraw(60.00);
        });
    }

    @Test
    void testWithdrawNegativeAmount(){
        BankAccount testAccount = new BankAccount("Test", 200.00);
        assertThrows(IllegalArgumentException.class , () -> {
            testAccount.withdraw(-1.00);
        });
    }

    @Test
    void testDepositWithdrawZero(){
        BankAccount testAccount = new BankAccount("Test", 200.00);
        assertThrows(IllegalArgumentException.class, () -> {
            testAccount.deposit(0.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            testAccount.withdraw(0.0);
        });
    }

    @Test
    void testMultipleOperationsConsistency(){
        BankAccount testAccount = new BankAccount("Test", 500.00);
        testAccount.deposit(200.00);
        testAccount.withdraw(150.00);
        testAccount.deposit(10.00);
        testAccount.withdraw(20.00);
        for (int i = 1; i <= 10; i++){
            if (i % 2 == 0){
                double i1 = i * 10;
                testAccount.deposit(i1);
            }
            else{
                double i2 = i * 10;
                testAccount.withdraw(i2);
            }
        }
        double balance = testAccount.getBalance();
        assertEquals(590.00, balance);
    }

    @Test
    void testInitialBalanceIsCorrect() {
        BankAccount acc = new BankAccount("Eve", 250.00);
        assertEquals(250.00, acc.getBalance());
    }

    @Test
    void testAccountHolderNameIsStored() {
        BankAccount acc = new BankAccount("Frank", 100.00);
        assertEquals("Frank", acc.getOwner());
    }

    @Test
    void testFalsePositive(){
        assertEquals(2,2);
    }




}
