package QueueInterface.ReverseQueue;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.*;

class QueueReverserTest {

    @Test
    void testReverseQueueRecursively() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.add(30);
        expectedQueue.add(20);
        expectedQueue.add(10);

        QueueReverser.reverseQueueRecursively(queue);
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testReverseQueueUsingStack() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.add(30);
        expectedQueue.add(20);
        expectedQueue.add(10);

        QueueReverser.reverseQueueUsingStack(queue);
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testReverseQueueWithSingleElement() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);

        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.add(5);

        QueueReverser.reverseQueueRecursively(queue);
        assertEquals(expectedQueue, queue);
    }

    @Test
    void testReverseEmptyQueue() {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> expectedQueue = new LinkedList<>();

        QueueReverser.reverseQueueRecursively(queue);
        assertEquals(expectedQueue, queue);
    }
}

