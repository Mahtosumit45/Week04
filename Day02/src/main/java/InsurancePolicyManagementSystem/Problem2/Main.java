package InsurancePolicyManagementSystem.Problem2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 300.0));
        manager.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().minusDays(5), "Home", 700.0));

        System.out.println("\nAll Policies: " + manager.getAllPolicies());
        System.out.println("\nExpiring Soon: " + manager.getExpiringSoonPolicies());
        System.out.println("\nPolicies of Alice: " + manager.getPoliciesByHolder("Alice"));

        manager.removeExpiredPolicies();
        System.out.println("\nAfter Removing Expired Policies: " + manager.getAllPolicies());
    }
}

