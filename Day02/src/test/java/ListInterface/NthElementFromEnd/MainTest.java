package ListInterface.NthElementFromEnd;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListNthElementFinderTest {

    @Test
    void testFindNthFromEnd() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        LinkedListNthElementFinder<String> finder = new LinkedListNthElementFinder<>(list);
        assertEquals("D", finder.findNthFromEnd(2), "2nd element from the end should be 'D'");
        assertEquals("E", finder.findNthFromEnd(1), "1st element from the end should be 'E'");
        assertEquals("A", finder.findNthFromEnd(5), "5th element from the end should be 'A'");
    }

    @Test
    void testFindNthFromEndSingleElement() {
        LinkedList<String> list = new LinkedList<>();
        list.add("X");

        LinkedListNthElementFinder<String> finder = new LinkedListNthElementFinder<>(list);
        assertEquals("X", finder.findNthFromEnd(1), "1st element from the end should be 'X' for a single-element list");
    }

    @Test
    void testFindNthFromEndOutOfBounds() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");

        LinkedListNthElementFinder<String> finder = new LinkedListNthElementFinder<>(list);

        Exception exception = assertThrows(NoSuchElementException.class, () -> finder.findNthFromEnd(3));
        assertEquals("N is larger than the linked list size.", exception.getMessage());
    }

    @Test
    void testFindNthFromEndNegativeOrZero() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");

        LinkedListNthElementFinder<String> finder = new LinkedListNthElementFinder<>(list);

        assertThrows(IllegalArgumentException.class, () -> finder.findNthFromEnd(0));
        assertThrows(IllegalArgumentException.class, () -> finder.findNthFromEnd(-1));
    }

    @Test
    void testFindNthFromEndEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        LinkedListNthElementFinder<String> finder = new LinkedListNthElementFinder<>(list);

        Exception exception = assertThrows(NoSuchElementException.class, () -> finder.findNthFromEnd(1));
        assertEquals("N is larger than the linked list size.", exception.getMessage());
    }
}
