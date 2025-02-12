package SetInterface.SymmetricDifference;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class SetOperationsTest {

    @Test
    void testSymmetricDifference() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> expectedSymmetricDifference = new HashSet<>();
        expectedSymmetricDifference.add(1);
        expectedSymmetricDifference.add(2);
        expectedSymmetricDifference.add(4);
        expectedSymmetricDifference.add(5);

        assertEquals(expectedSymmetricDifference, SetOperations.symmetricDifference(set1, set2));
    }

    @Test
    void testSymmetricDifferenceWithEmptySet() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>(); // Empty set

        assertEquals(set1, SetOperations.symmetricDifference(set1, set2));
    }

    @Test
    void testSymmetricDifferenceWithNoCommonElements() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);

        Set<Integer> expectedSymmetricDifference = new HashSet<>();
        expectedSymmetricDifference.add(1);
        expectedSymmetricDifference.add(2);
        expectedSymmetricDifference.add(3);
        expectedSymmetricDifference.add(4);
        expectedSymmetricDifference.add(5);
        expectedSymmetricDifference.add(6);

        assertEquals(expectedSymmetricDifference, SetOperations.symmetricDifference(set1, set2));
    }

    @Test
    void testSymmetricDifferenceOfEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Set<Integer> expectedSymmetricDifference = new HashSet<>();

        assertEquals(expectedSymmetricDifference, SetOperations.symmetricDifference(set1, set2));
    }

    @Test
    void testSymmetricDifferenceWithSameSets() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);

        Set<Integer> expectedSymmetricDifference = new HashSet<>(); // Same sets should give empty symmetric difference

        assertEquals(expectedSymmetricDifference, SetOperations.symmetricDifference(set1, set2));
    }
}
