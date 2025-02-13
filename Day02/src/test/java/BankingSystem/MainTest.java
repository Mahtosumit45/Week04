package BankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

class BankTest {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bank.createAccount("101", 1000);
        bank.createAccount("102", 1500);
        bank.createAccount("103", 500);
    }

    @Test
    void testCreateAccount() {
        assertTrue(bank.createAccount("104", 2000), "Should successfully create a new account");
        assertFalse(bank.createAccount("101", 500), "Should not allow duplicate account creation");
    }

    @Test
    void testDeposit() {
        assertTrue(bank.deposit("101", 500), "Deposit should succeed for an existing account");
        assertEquals(1500, bank.getBalance("101"), "Balance should be updated after deposit");

        assertFalse(bank.deposit("999", 100), "Deposit should fail for a non-existent account");
    }

    @Test
    void testRequestWithdrawal() {
        assertTrue(bank.requestWithdrawal("102", 500), "Withdrawal request should succeed if funds are sufficient");
        assertFalse(bank.requestWithdrawal("103", 600), "Withdrawal request should fail if funds are insufficient");
        assertFalse(bank.requestWithdrawal("999", 100), "Withdrawal request should fail for a non-existent account");
    }


    @Test
    void testGetSortedAccountsByBalance() {
        Map<String, Double> sortedAccounts = bank.getSortedAccountsByBalance();

        // The expected order is 103 (500), 101 (1000), 102 (1500)
        assertEquals(3, sortedAccounts.size(), "Sorted account list should contain three elements");
        assertEquals("103", sortedAccounts.keySet().iterator().next(), "First account should be the one with the lowest balance");
    }


