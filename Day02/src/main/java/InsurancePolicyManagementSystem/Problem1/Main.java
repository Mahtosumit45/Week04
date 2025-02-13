package InsurancePolicyManagementSystem.Problem1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P123", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        manager.addPolicy(new Policy("P456", "Bob", LocalDate.now().plusDays(40), "Auto", 300.0));
        manager.addPolicy(new Policy("P789", "Charlie", LocalDate.now().plusDays(5), "Home", 700.0));
        manager.addPolicy(new Policy("P123", "Alice", LocalDate.now().plusDays(10), "Health", 500.0)); // Duplicate

        System.out.println("\nAll Policies: " + manager.getAllPolicies());
        System.out.println("\nExpiring Soon: " + manager.getExpiringSoonPolicies());
        System.out.println("\nHealth Policies: " + manager.getPoliciesByCoverageType("Health"));
        System.out.println("\nDuplicate Policies: " + manager.findDuplicatePolicies());

        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance();
    }
}

