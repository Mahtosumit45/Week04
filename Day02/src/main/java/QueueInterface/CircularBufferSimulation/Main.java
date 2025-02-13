package QueueInterface.CircularBufferSimulation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("Buffer: " + Arrays.toString(buffer.getBufferContents())); // [1, 2, 3]

        buffer.insert(4); // Overwrites 1
        System.out.println("Buffer after inserting 4: " + Arrays.toString(buffer.getBufferContents())); // [2, 3, 4]

        buffer.insert(5); // Overwrites 2
        System.out.println("Buffer after inserting 5: " + Arrays.toString(buffer.getBufferContents())); // [3, 4, 5]
    }
}

