package QueueInterface.CircularBufferSimulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class CircularBufferTest {

    @Test
    void testInsertionAndRetrieval() {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        assertArrayEquals(new int[]{1, 2, 3}, buffer.getBufferContents());
    }

    @Test
    void testOverwriteWhenFull() {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4); // Overwrites 1
        assertArrayEquals(new int[]{2, 3, 4}, buffer.getBufferContents());

        buffer.insert(5); // Overwrites 2
        assertArrayEquals(new int[]{3, 4, 5}, buffer.getBufferContents());
    }

    @Test
    void testIsEmptyAndIsFull() {
        CircularBuffer buffer = new CircularBuffer(2);
        assertTrue(buffer.isEmpty());

        buffer.insert(10);
        assertFalse(buffer.isEmpty());
        assertFalse(buffer.isFull());

        buffer.insert(20);
        assertTrue(buffer.isFull());
    }

    @Test
    void testBufferSize() {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(5);
        buffer.insert(10);
        assertEquals(2, buffer.getSize());

        buffer.insert(15);
        assertEquals(3, buffer.getSize());

        buffer.insert(20); // Overwrites oldest element
        assertEquals(3, buffer.getSize());
    }
}
