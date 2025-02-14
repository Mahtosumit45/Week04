package CountWordsInFile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {
    private static final String TEST_FILE_PATH = "test_text.txt";

    @BeforeEach
    void setUp() throws IOException {
        File testFile = new File(TEST_FILE_PATH);
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("hello world! Hello, Java. Java is fun.\n");
            writer.write("world is big, but Java world is bigger.\n");
        }
    }

    @Test
    void testCountWords() {
        WordCounter wordCounter = new WordCounter(TEST_FILE_PATH);
        Map<String, Integer> wordCount = wordCounter.countWords();

        assertEquals(3, wordCount.get("java"));
        assertEquals(3, wordCount.get("world"));
        assertEquals(3, wordCount.get("is"));
        assertEquals(1, wordCount.get("fun"));
    }

    @Test
    void testGetTopFrequentWords() {
        WordCounter wordCounter = new WordCounter(TEST_FILE_PATH);
        List<Map.Entry<String, Integer>> topWords = wordCounter.getTopFrequentWords(3);

        assertEquals("java", topWords.get(0).getKey());
        assertEquals(3, topWords.get(0).getValue());
    }
}
