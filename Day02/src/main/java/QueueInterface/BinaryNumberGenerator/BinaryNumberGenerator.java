package QueueInterface.BinaryNumberGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryNumberGenerator {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        if (N <= 0) return result; // Edge case: N should be positive

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String binaryNumber = queue.poll(); // Remove the front element
            result.add(binaryNumber);

            // Generate next binary numbers
            queue.add(binaryNumber + "0");
            queue.add(binaryNumber + "1");
        }
        return result;
    }
}

