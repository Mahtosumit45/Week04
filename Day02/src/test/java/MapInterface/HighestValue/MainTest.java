package MapInterface.HighestValue;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class MaxValueKeyFinderTest {

    @Test
    void testBasicCase() {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 10);
        input.put("B", 20);
        input.put("C", 15);

        String result = MaxValueKeyFinder.findMaxKey(input);
        assertEquals("B", result);
    }

    @Test
    void testSingleEntry() {
        Map<String, Integer> input = new HashMap<>();
        input.put("X", 100);

        String result = MaxValueKeyFinder.findMaxKey(input);
        assertEquals("X", result);
    }

    @Test
    void testEmptyMap() {
        Map<String, Integer> input = new HashMap<>();
        String result = MaxValueKeyFinder.findMaxKey(input);
        assertNull(result);
    }

    @Test
    void testNegativeValues() {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", -10);
        input.put("B", -20);
        input.put("C", -5);

        String result = MaxValueKeyFinder.findMaxKey(input);
        assertEquals("C", result);
    }

    @Test
    void testDuplicateMaxValues() {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 50);
        input.put("B", 50);
        input.put("C", 30);

        String result = MaxValueKeyFinder.findMaxKey(input);
        assertTrue(result.equals("A") || result.equals("B")); // Either A or B is valid
    }
}
