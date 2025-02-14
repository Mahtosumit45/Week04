package CountWordsInFile;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/sample_text.txt"; // Path to input file

        WordCounter wordCounter = new WordCounter(filePath);
        List<Map.Entry<String, Integer>> topWords = wordCounter.getTopFrequentWords(5);

        System.out.println("Top 5 Most Frequent Words:");
        for (Map.Entry<String, Integer> entry : topWords) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

