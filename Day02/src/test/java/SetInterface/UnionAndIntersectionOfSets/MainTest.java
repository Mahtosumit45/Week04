package SetInterface.UnionAndIntersectionOfSets;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class SetOperationsTest {

    @Test
    void testUnion() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> expectedUnion = new HashSet<>();
        expectedUnion.add(1);
        expectedUnion.add(2);
        expectedUnion.add(3);
        expectedUnion.add(4);
        expectedUnion.add(5);

        assertEquals(expectedUnion, SetOperations.union(set1, set2));
    }

    @Test
    void testIntersection() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> expectedIntersection = new HashSet<>();
        expectedIntersection.add(3);

        assertEquals(expectedIntersection, SetOperations.intersection(set1, set2));
    }

    @Test
    void testUnionWithEmptySet() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>(); // Empty set

        assertEquals(set1, SetOperations.union(set1, set2));
    }

    @Test
    void testIntersectionWithNoCommonElements() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);

        Set<Integer> expectedIntersection = new HashSet<>(); // No common elements

        assertEquals(expectedIntersection, SetOperations.intersection(set1, set2));
    }

    @Test
    void testUnionOfEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Set<Integer> expectedUnion = new HashSet<>();

        assertEquals(expectedUnion, SetOperations.union(set1, set2));
    }

    @Test
    void testIntersectionOfEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Set<Integer> expectedIntersection = new HashSet<>();

        assertEquals(expectedIntersection, SetOperations.intersection(set1, set2));
    }
}
