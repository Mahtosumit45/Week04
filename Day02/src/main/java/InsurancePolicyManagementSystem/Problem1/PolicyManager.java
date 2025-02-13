package InsurancePolicyManagementSystem.Problem1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PolicyManager {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public List<Policy> getAllPolicies() {
        return new ArrayList<>(hashSet);
    }

    public List<Policy> getExpiringSoonPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        return treeSet.stream()
                .filter(policy -> policy.getExpiryDate().isBefore(threshold))
                .collect(Collectors.toList());
    }

    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        return hashSet.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .collect(Collectors.toList());
    }

    public Set<String> findDuplicatePolicies() {
        Set<String> uniqueNumbers = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy policy : hashSet) {
            if (!uniqueNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy.getPolicyNumber());
            }
        }
        return duplicates;
    }

    public void comparePerformance() {
        List<Policy> testPolicies = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            testPolicies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", 100.0 + i));
        }

        measurePerformance("HashSet", new HashSet<>(), testPolicies);
        measurePerformance("LinkedHashSet", new LinkedHashSet<>(), testPolicies);
        measurePerformance("TreeSet", new TreeSet<>(), testPolicies);
    }

    private void measurePerformance(String name, Set<Policy> set, List<Policy> policies) {
        long startTime = System.nanoTime();
        set.addAll(policies);
        long endTime = System.nanoTime();
        System.out.println(name + " Insertion Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        set.contains(policies.get(5000));
        endTime = System.nanoTime();
        System.out.println(name + " Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        set.remove(policies.get(5000));
        endTime = System.nanoTime();
        System.out.println(name + " Deletion Time: " + (endTime - startTime) + " ns");
    }
}

