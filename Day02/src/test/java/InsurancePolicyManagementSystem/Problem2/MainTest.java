package InsurancePolicyManagementSystem.Problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolicyManagerTest {
    private PolicyManager manager;

    @BeforeEach
    void setUp() {
        manager = new PolicyManager();
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 300.0));
        manager.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().minusDays(5), "Home", 700.0));
    }

    @Test
    void testRetrievePolicyByNumber() {
        Policy policy = manager.getPolicyByNumber("P1001");
        assertNotNull(policy);
        assertEquals("Alice", policy.getPolicyholderName());
    }

    @Test
    void testExpiringSoonPolicies() {
        List<Policy> expiringPolicies = manager.getExpiringSoonPolicies();
        assertEquals(1, expiringPolicies.size());
        assertEquals("Alice", expiringPolicies.get(0).getPolicyholderName());
    }

    @Test
    void testGetPoliciesByHolder() {
        List<Policy> alicePolicies = manager.getPoliciesByHolder("Alice");
        assertEquals(1, alicePolicies.size());
        assertEquals("P1001", alicePolicies.get(0).getPolicyNumber());
    }

    @Test
    void testRemoveExpiredPolicies() {
        manager.removeExpiredPolicies();
        assertNull(manager.getPolicyByNumber("P1003")); // Expired policy should be removed
    }
}
