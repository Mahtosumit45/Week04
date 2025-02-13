package MapInterface.WorkFrequencyCounter;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/sumitkumarmahto/Desktop/Amount Paid.txt"; // Path to text file

        try {
            Map<String, Integer> wordFrequency = WordFrequencyCounter.countWordFrequency(filePath);
            System.out.println("Word Frequencies: " + wordFrequency);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

