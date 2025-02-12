package SetInterface.TwoSetsAreEqual;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class SetComparatorTest {

    @Test
    void testEqualSets() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        assertTrue(SetComparator.areSetsEqual(set1, set2));
    }

    @Test
    void testDifferentSets() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);

        assertFalse(SetComparator.areSetsEqual(set1, set2));
    }

    @Test
    void testDifferentSizes() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);

        assertFalse(SetComparator.areSetsEqual(set1, set2));
    }

    @Test
    void testEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        assertTrue(SetComparator.areSetsEqual(set1, set2));
    }
}
