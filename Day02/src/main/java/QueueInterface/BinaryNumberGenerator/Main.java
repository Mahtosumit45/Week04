package QueueInterface.BinaryNumberGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int N = 5; // Change this value to generate more numbers
        List<String> binaryNumbers = BinaryNumberGenerator.generateBinaryNumbers(N);
        System.out.println("First " + N + " Binary Numbers: " + binaryNumbers);
    }
}

