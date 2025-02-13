package QueueInterface.ReverseQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        QueueReverser.reverseQueueRecursively(queue);
        System.out.println("Reversed Queue (Recursively): " + queue);

        queue.clear(); // Resetting queue for next test
        queue.add(10);
        queue.add(20);
        queue.add(30);

        QueueReverser.reverseQueueUsingStack(queue);
        System.out.println("Reversed Queue (Using Stack): " + queue);
    }
}

