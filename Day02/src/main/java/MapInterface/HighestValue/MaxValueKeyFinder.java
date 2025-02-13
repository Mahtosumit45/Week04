package MapInterface.HighestValue;

import java.util.Map;

public class MaxValueKeyFinder {

    // Method to find the key with the maximum value
    public static String findMaxKey(Map<String, Integer> inputMap) {
        if (inputMap == null || inputMap.isEmpty()) {
            return null; // Handle empty map case
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}

