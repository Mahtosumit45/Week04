package ListInterface.FrequencyCountProblem;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class FrequencyCounterTest {

    @Test
    public void testCountFrequency() {
        // Create instance of FrequencyCounter
        FrequencyCounter frequencyCounter = new FrequencyCounter();

        // Sample input list
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        // Expected output
        Map<String, Integer> expected = new HashMap<>();
        expected.put("apple", 3);
        expected.put("banana", 2);
        expected.put("orange", 1);

        // Call method and assert equality
        Map<String, Integer> result = frequencyCounter.countFrequency(words);
        assertEquals(expected, result, "Frequency count should match expected values");
    }

    @Test
    public void testCountFrequencyWithEmptyList() {
        FrequencyCounter frequencyCounter = new FrequencyCounter();
        List<String> words = new ArrayList<>();  // Empty list

        // Expected output: empty map
        Map<String, Integer> expected = new HashMap<>();
        Map<String, Integer> result = frequencyCounter.countFrequency(words);
        assertEquals(expected, result, "Empty list should return an empty map");
    }

    @Test
    public void testCountFrequencyWithSingleElement() {
        FrequencyCounter frequencyCounter = new FrequencyCounter();
        List<String> words = Arrays.asList("apple");

        // Expected output: {"apple"=1}
        Map<String, Integer> expected = new HashMap<>();
        expected.put("apple", 1);

        Map<String, Integer> result = frequencyCounter.countFrequency(words);
        assertEquals(expected, result, "Single element list should return correct frequency");
    }

    @Test
    public void testCountFrequencyWithDuplicates() {
        FrequencyCounter frequencyCounter = new FrequencyCounter();
        List<String> words = Arrays.asList("test", "test", "test");

        // Expected output: {"test"=3}
        Map<String, Integer> expected = new HashMap<>();
        expected.put("test", 3);

        Map<String, Integer> result = frequencyCounter.countFrequency(words);
        assertEquals(expected, result, "Duplicate elements should be counted correctly");
    }
}

