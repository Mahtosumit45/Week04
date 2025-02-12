package SetInterface.TwoSetsAreEqual;

import java.util.Set;

public class SetComparator {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }
}

