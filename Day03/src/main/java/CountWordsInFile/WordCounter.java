package CountWordsInFile;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {
    private final File file;

    public WordCounter(String filePath) {
        this.file = new File(filePath);
    }

    public Map<String, Integer> countWords() {
        Map<String, Integer> wordCount = new HashMap<>();

        if (!file.exists()) {
            System.err.println("File not found: " + file.getAbsolutePath());
            return wordCount;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return wordCount;
    }

    public List<Map.Entry<String, Integer>> getTopFrequentWords(int topN) {
        Map<String, Integer> wordCount = countWords();
        return wordCount.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort by frequency
                .limit(topN)
                .collect(Collectors.toList());
    }
}

