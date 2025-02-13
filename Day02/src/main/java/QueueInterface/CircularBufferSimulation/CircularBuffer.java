package QueueInterface.CircularBufferSimulation;
import java.util.Arrays;

public class CircularBuffer {
    private final int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Insert element into the buffer
    public void insert(int value) {
        rear = (rear + 1) % capacity; // Move rear forward
        buffer[rear] = value;

        if (size < capacity) {
            size++; // Increase size if not full
        } else {
            front = (front + 1) % capacity; // Overwrite oldest element
        }
    }

    // Get current elements in the buffer as an array
    public int[] getBufferContents() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(front + i) % capacity];
        }
        return result;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}

