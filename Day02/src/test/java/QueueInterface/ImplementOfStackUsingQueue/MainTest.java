package QueueInterface.ImplementOfStackUsingQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackUsingQueuesTest {

    @Test
    void testPushAndTop() {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(5);
        stack.push(10);
        assertEquals(10, stack.top()); // Top should be 10
    }

    @Test
    void testPop() {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop()); // Last pushed element should be removed first
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty()); // Stack should be empty now
    }

    @Test
    void testPopOnEmptyStack() {
        StackUsingQueues stack = new StackUsingQueues();
        assertEquals(-1, stack.pop()); // Should return -1 when empty
    }

    @Test
    void testTopOnEmptyStack() {
        StackUsingQueues stack = new StackUsingQueues();
        assertEquals(-1, stack.top()); // Should return -1 when empty
    }
}
