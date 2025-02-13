package MapInterface.MergeTwoMaps;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class MapMergerTest {

    @Test
    void testBasicMerge() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> result = MapMerger.mergeMaps(map1, map2);

        assertEquals(1, result.get("A"));
        assertEquals(5, result.get("B"));
        assertEquals(4, result.get("C"));
    }

    @Test
    void testEmptyFirstMap() {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("X", 10);
        map2.put("Y", 20);

        Map<String, Integer> result = MapMerger.mergeMaps(map1, map2);

        assertEquals(10, result.get("X"));
        assertEquals(20, result.get("Y"));
        assertEquals(2, result.size());
    }

    @Test
    void testEmptySecondMap() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 5);
        map1.put("B", 10);
        Map<String, Integer> map2 = new HashMap<>();

        Map<String, Integer> result = MapMerger.mergeMaps(map1, map2);

        assertEquals(5, result.get("A"));
        assertEquals(10, result.get("B"));
        assertEquals(2, result.size());
    }

    @Test
    void testBothMapsEmpty() {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        Map<String, Integer> result = MapMerger.mergeMaps(map1, map2);

        assertTrue(result.isEmpty());
    }

    @Test
    void testMultipleSameKeys() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("X", 7);
        map1.put("Y", 8);
        map1.put("Z", 9);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("X", 3);
        map2.put("Y", 2);
        map2.put("Z", 1);

        Map<String, Integer> result = MapMerger.mergeMaps(map1, map2);

        assertEquals(10, result.get("X"));
        assertEquals(10, result.get("Y"));
        assertEquals(10, result.get("Z"));
    }
}
