package InsurancePolicyManagementSystem.Problem2;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, Policy> sortedByExpiry = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedByExpiry.put(policy.getExpiryDate(), policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getExpiringSoonPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        return new ArrayList<>(sortedByExpiry.subMap(today, threshold).values());
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(holderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedByExpiry.headMap(today, true).clear();
        policyMap.values().removeIf(p -> p.getExpiryDate().isBefore(today));
        orderedPolicyMap.values().removeIf(p -> p.getExpiryDate().isBefore(today));
    }

    public List<Policy> getAllPolicies() {
        return new ArrayList<>(policyMap.values());
    }
}

