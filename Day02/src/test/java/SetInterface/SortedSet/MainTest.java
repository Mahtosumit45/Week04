package SetInterface.SortedSet;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class SetToSortedListTest {

    @Test
    void testConvertToSortedList() {
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> expectedList = Arrays.asList(1, 3, 5, 9);

        assertEquals(expectedList, SetToSortedList.convertToSortedList(numberSet));
    }

    @Test
    void testConvertUsingTreeSet() {
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> expectedList = Arrays.asList(1, 3, 5, 9);

        assertEquals(expectedList, SetToSortedList.convertUsingTreeSet(numberSet));
    }

    @Test
    void testEmptySet() {
        Set<Integer> numberSet = new HashSet<>();
        List<Integer> expectedList = Arrays.asList();

        assertEquals(expectedList, SetToSortedList.convertToSortedList(numberSet));
    }

    @Test
    void testSingleElementSet() {
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(7));
        List<Integer> expectedList = Arrays.asList(7);

        assertEquals(expectedList, SetToSortedList.convertToSortedList(numberSet));
    }

    @Test
    void testDuplicateElements() {
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(4, 2, 4, 1, 2));
        List<Integer> expectedList = Arrays.asList(1, 2, 4);

        assertEquals(expectedList, SetToSortedList.convertToSortedList(numberSet));
    }
}
