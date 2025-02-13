package MapInterface.InsertMap;

import java.util.*;

public class MapInverter {

    // Method to invert a map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Add the key to the list of values
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return invertedMap;
    }
}

