package SetInterface.SymmetricDifference;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> intersection = new HashSet<>(set1);

        result.addAll(set2);  // Union of both sets
        intersection.retainAll(set2); // Intersection of both sets

        result.removeAll(intersection); // Remove common elements to get symmetric difference
        return result;
    }
}

