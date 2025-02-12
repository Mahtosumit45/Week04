package ListInterface.FrequencyCountProblem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Input list of strings
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        System.out.println("Input List: " + words);

        // Create an instance of FrequencyCounter
        FrequencyCounter frequencyCounter = new FrequencyCounter();

        // Get the frequency map
        Map<String, Integer> result = frequencyCounter.countFrequency(words);

        // Print the frequency map
        System.out.println("Frequency Map: " + result);
    }
}

