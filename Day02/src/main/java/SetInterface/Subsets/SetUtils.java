package SetInterface.Subsets;

import java.util.Set;

public class SetUtils {
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }
}

