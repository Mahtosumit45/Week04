package QueueInterface.ImplementOfStackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push an element onto the stack
    public void push(int x) {
        q1.add(x);
    }

    // Pop the top element (returns -1 if empty)
    public int pop() {
        if (q1.isEmpty()) return -1;

        // Move all elements except last to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int topElement = q1.poll(); // Last element in q1

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Get the top element without removing it
    public int top() {
        if (q1.isEmpty()) return -1;

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int topElement = q1.poll();
        q2.add(topElement); // Put it back

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

