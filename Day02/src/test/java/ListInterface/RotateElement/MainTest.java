package ListInterface.RotateElement;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class RotateListTest {

    @Test
    void testArrayListRotate() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        ArrayListRotator<Integer> rotator = new ArrayListRotator<>(list);
        rotator.rotate(2);
        assertEquals(Arrays.asList(30, 40, 50, 10, 20), rotator.getList(), "ArrayList should be rotated by 2 positions");
    }

    @Test
    void testLinkedListRotate() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
        LinkedListRotator<Integer> rotator = new LinkedListRotator<>(list);
        rotator.rotate(2);
        assertEquals(Arrays.asList(30, 40, 50, 10, 20), rotator.getList(), "LinkedList should be rotated by 2 positions");
    }

    @Test
    void testEmptyArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayListRotator<Integer> rotator = new ArrayListRotator<>(list);
        rotator.rotate(3);
        assertTrue(rotator.getList().isEmpty(), "Rotating an empty list should result in an empty list");
    }

    @Test
    void testEmptyLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedListRotator<Integer> rotator = new LinkedListRotator<>(list);
        rotator.rotate(3);
        assertTrue(rotator.getList().isEmpty(), "Rotating an empty linked list should result in an empty list");
    }

    @Test
    void testSingleElementArrayList() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(42));
        ArrayListRotator<Integer> rotator = new ArrayListRotator<>(list);
        rotator.rotate(1);
        assertEquals(Arrays.asList(42), rotator.getList(), "A single-element list should remain unchanged");
    }

    @Test
    void testSingleElementLinkedList() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(42));
        LinkedListRotator<Integer> rotator = new LinkedListRotator<>(list);
        rotator.rotate(1);
        assertEquals(Arrays.asList(42), rotator.getList(), "A single-element linked list should remain unchanged");
    }

    @Test
    void testRotationEqualToSizeArrayList() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        ArrayListRotator<Integer> rotator = new ArrayListRotator<>(list);
        rotator.rotate(5); // Same as full rotation
        assertEquals(Arrays.asList(10, 20, 30, 40, 50), rotator.getList(), "Rotation by list size should return original list");
    }

    @Test
    void testRotationEqualToSizeLinkedList() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
        LinkedListRotator<Integer> rotator = new LinkedListRotator<>(list);
        rotator.rotate(5);
        assertEquals(Arrays.asList(10, 20, 30, 40, 50), rotator.getList(), "Rotation by list size should return original list");
    }
}
