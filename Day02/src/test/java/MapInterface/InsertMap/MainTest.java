package MapInterface.InsertMap;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MapInverterTest {

    @Test
    void testBasicInversion() {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        Map<Integer, List<String>> result = MapInverter.invertMap(input);

        assertEquals(Arrays.asList("A", "C"), result.get(1));
        assertEquals(Arrays.asList("B"), result.get(2));
    }

    @Test
    void testSingleEntryMap() {
        Map<String, Integer> input = new HashMap<>();
        input.put("X", 100);

        Map<Integer, List<String>> result = MapInverter.invertMap(input);

        assertEquals(Arrays.asList("X"), result.get(100));
        assertEquals(1, result.size());
    }

    @Test
    void testEmptyMap() {
        Map<String, Integer> input = new HashMap<>();

        Map<Integer, List<String>> result = MapInverter.invertMap(input);

        assertTrue(result.isEmpty());
    }

    @Test
    void testMultipleKeysSameValue() {
        Map<String, Integer> input = new HashMap<>();
        input.put("Alpha", 5);
        input.put("Beta", 5);
        input.put("Gamma", 5);

        Map<Integer, List<String>> result = MapInverter.invertMap(input);

        assertEquals(Arrays.asList("Gamma","Alpha", "Beta"), result.get(5));
        assertEquals(1, result.size());
    }

    @Test
    void testDifferentTypes() {
        Map<Integer, String> input = new HashMap<>();
        input.put(10, "Apple");
        input.put(20, "Banana");
        input.put(30, "Apple");

        Map<String, List<Integer>> result = MapInverter.invertMap(input);

        assertEquals(Arrays.asList(10, 30), result.get("Apple"));
        assertEquals(Arrays.asList(20), result.get("Banana"));
    }
}
