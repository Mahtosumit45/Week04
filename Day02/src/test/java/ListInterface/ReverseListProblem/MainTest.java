package ListInterface.ReverseListProblem;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class ReverseListTest {

    @Test
    void testArrayListReverse() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayListReverse<Integer> reverser = new ArrayListReverse<>(list);
        reverser.reverse();
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), reverser.getList(), "ArrayList should be reversed");
    }

    @Test
    void testLinkedListReverse() {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedListReverser<Integer> reverser = new LinkedListReverser<>(linkedList);
        reverser.reverse();
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), reverser.getList(), "LinkedList should be reversed");
    }

    @Test
    void testEmptyArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayListReverse<Integer> reverser = new ArrayListReverse<>(list);
        reverser.reverse();
        assertTrue(reverser.getList().isEmpty(), "Reversing an empty list should result in an empty list");
    }

    @Test
    void testEmptyLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedListReverser<Integer> reverser = new LinkedListReverser<>(list);
        reverser.reverse();
        assertTrue(reverser.getList().isEmpty(), "Reversing an empty linked list should result in an empty list");
    }

    @Test
    void testSingleElementArrayList() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(42));
        ArrayListReverse<Integer> reverser = new ArrayListReverse<>(list);
        reverser.reverse();
        assertEquals(Arrays.asList(42), reverser.getList(), "A single-element list should remain unchanged");
    }

    @Test
    void testSingleElementLinkedList() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(42));
        LinkedListReverser<Integer> reverser = new LinkedListReverser<>(list);
        reverser.reverse();
        assertEquals(Arrays.asList(42), reverser.getList(), "A single-element linked list should remain unchanged");
    }
}
