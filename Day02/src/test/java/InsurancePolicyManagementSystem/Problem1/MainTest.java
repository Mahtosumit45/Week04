package InsurancePolicyManagementSystem.Problem1;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PolicyManagerTest {

    @Test
    void testAddAndRetrievePolicies() {
        PolicyManager manager = new PolicyManager();
        Policy p1 = new Policy("P101", "John Doe", LocalDate.now().plusDays(15), "Health", 400.0);
        manager.addPolicy(p1);

        List<Policy> policies = manager.getAllPolicies();
        assertEquals(1, policies.size());
        assertTrue(policies.contains(p1));
    }

    @Test
    void testExpiringSoonPolicies() {
        PolicyManager manager = new PolicyManager();
        Policy p1 = new Policy("P202", "Alice", LocalDate.now().plusDays(10), "Auto", 200.0);
        Policy p2 = new Policy("P203", "Bob", LocalDate.now().plusDays(40), "Health", 300.0);
        manager.addPolicy(p1);
        manager.addPolicy(p2);

        List<Policy> expiring = manager.getExpiringSoonPolicies();
        assertEquals(1, expiring.size());
        assertTrue(expiring.contains(p1));
    }


}
