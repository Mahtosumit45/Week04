package MapInterface.WorkFrequencyCounter;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyCounterTest {

    @Test
    void testSimpleSentence() {
        String text = "Hello world, hello Java!";
        Map<String, Integer> result = WordFrequencyCounter.countWords(text);
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
        assertEquals(1, result.get("java"));
    }

    @Test
    void testPunctuationHandling() {
        String text = "Coding is fun. Coding, coding, fun!";
        Map<String, Integer> result = WordFrequencyCounter.countWords(text);
        assertEquals(3, result.get("coding"));
        assertEquals(2, result.get("fun"));
        assertEquals(1, result.get("is"));
    }

    @Test
    void testCaseInsensitive() {
        String text = "Java JAVA java";
        Map<String, Integer> result = WordFrequencyCounter.countWords(text);
        assertEquals(3, result.get("java"));
    }

    @Test
    void testEmptyString() {
        String text = "";
        Map<String, Integer> result = WordFrequencyCounter.countWords(text);
        assertTrue(result.isEmpty());
    }

    @Test
    void testOnlyPunctuation() {
        String text = "!@#$%^&*()";
        Map<String, Integer> result = WordFrequencyCounter.countWords(text);
        assertTrue(result.isEmpty());
    }
}
