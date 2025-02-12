package ListInterface.FrequencyCountProblem;

import java.util.*;

public class FrequencyCounter {
    // Method to count frequency of elements in a list
    public Map<String, Integer> countFrequency(List<String> words) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        return frequencyMap;
    }
}

