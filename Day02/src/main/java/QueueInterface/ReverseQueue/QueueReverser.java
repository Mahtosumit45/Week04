package QueueInterface.ReverseQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    // Method 1: Using Recursion
    public static <T> void reverseQueueRecursively(Queue<T> queue) {
        if (queue.isEmpty()) {
            return;
        }
        T front = queue.poll(); // Remove front element
        reverseQueueRecursively(queue); // Reverse the remaining queue
        queue.add(front); // Add the removed element to the end
    }

    // Method 2: Using a Stack
    public static <T> void reverseQueueUsingStack(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll()); // Remove and push elements onto stack
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop()); // Pop elements back into queue
        }
    }
}

