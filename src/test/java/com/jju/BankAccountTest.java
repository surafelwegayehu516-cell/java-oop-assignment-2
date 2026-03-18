package com.jju;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class BankAccountTest {

    @Test
    @DisplayName("BankAccount: Basic Deposit")
    public void testBaseDeposit() {
        BankAccount account = new BankAccount("User", 100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("BankAccount: Prevent Overdraft")
    public void testBaseWithdrawalSafety() {
        BankAccount account = new BankAccount("User", 100.0);
        account.withdraw(150.0);
        assertEquals(100.0, account.getBalance(), "Balance should not change if funds are insufficient.");
    }

    @Test
    @DisplayName("SavingsAccount: Apply Interest")
    public void testSavingsInterest() {
        // 10% interest for easy math
        SavingsAccount savings = new SavingsAccount("Saver", 200.0, 0.10);
        savings.applyInterest();
        assertEquals(220.0, savings.getBalance(), 0.001);
    }

    @Test
    @DisplayName("CheckingAccount: Apply Transaction Fee")
    public void testCheckingTransactionFee() {
        // Balance 100, withdraw 40. With 1.50 fee, balance should be 58.50
        CheckingAccount checking = new CheckingAccount("Spender", 100.0);
        checking.withdraw(40.0);
        assertEquals(58.50, checking.getBalance(), 0.001);
    }

    @Test
    @DisplayName("CheckingAccount: Insufficient Funds for Fee")
    public void testCheckingInsufficientWithFee() {
        // Balance 10, withdraw 9. Total (9 + 1.50 = 10.50) exceeds balance.
        CheckingAccount checking = new CheckingAccount("Spender", 10.0);
        checking.withdraw(9.0);
        assertEquals(10.0, checking.getBalance(), "Withdrawal should fail if balance cannot cover the fee.");
    }

    @Test
    @DisplayName("Encapsulation Check: Balance Protection")
    public void testEncapsulation() {
        try {
            // Check if 'balance' field is public via reflection
            java.lang.reflect.Field field = BankAccount.class.getDeclaredField("balance");
            int modifiers = field.getModifiers();
            assertFalse(java.lang.reflect.Modifier.isPublic(modifiers), "The balance field must not be public!");
        } catch (NoSuchFieldException e) {
            fail("Field 'balance' not found.");
        }
    }
}
