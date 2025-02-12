package SetInterface.Subsets;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class SetUtilsTest {

    @Test
    void testSubset() {
        Set<Integer> subset = new HashSet<>();
        subset.add(2);
        subset.add(3);

        Set<Integer> superset = new HashSet<>();
        superset.add(1);
        superset.add(2);
        superset.add(3);
        superset.add(4);

        assertTrue(SetUtils.isSubset(subset, superset));
    }

    @Test
    void testNotSubset() {
        Set<Integer> subset = new HashSet<>();
        subset.add(5);
        subset.add(6);

        Set<Integer> superset = new HashSet<>();
        superset.add(1);
        superset.add(2);
        superset.add(3);
        superset.add(4);

        assertFalse(SetUtils.isSubset(subset, superset));
    }

    @Test
    void testEmptySetSubset() {
        Set<Integer> subset = new HashSet<>();
        Set<Integer> superset = new HashSet<>();
        superset.add(1);
        superset.add(2);

        assertTrue(SetUtils.isSubset(subset, superset)); // Empty set is a subset of any set
    }

    @Test
    void testSameSets() {
        Set<Integer> subset = new HashSet<>();
        subset.add(1);
        subset.add(2);
        subset.add(3);

        Set<Integer> superset = new HashSet<>(subset); // Same elements

        assertTrue(SetUtils.isSubset(subset, superset));
    }

    @Test
    void testSupersetEmpty() {
        Set<Integer> subset = new HashSet<>();
        subset.add(1);
        subset.add(2);

        Set<Integer> superset = new HashSet<>(); // Empty superset

        assertFalse(SetUtils.isSubset(subset, superset));
    }
}
