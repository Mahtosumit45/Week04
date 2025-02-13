package MapInterface.WorkFrequencyCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    // Method to read file and return word frequency map
    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        return countWords(content);
    }

    // Process the text and count words
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Normalize text: Convert to lowercase & remove punctuation
        text = text.toLowerCase().replaceAll("[^a-z\\s]", "");

        // Split words based on spaces
        String[] words = text.split("\\s+");

        // Count word frequency
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }
}

