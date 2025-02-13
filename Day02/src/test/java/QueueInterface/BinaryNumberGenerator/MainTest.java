package QueueInterface.BinaryNumberGenerator;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BinaryNumberGeneratorTest {

    @Test
    void testGenerateBinaryNumbers() {
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101");
        assertEquals(expected, BinaryNumberGenerator.generateBinaryNumbers(5));
    }

    @Test
    void testGenerateSingleBinaryNumber() {
        List<String> expected = Arrays.asList("1");
        assertEquals(expected, BinaryNumberGenerator.generateBinaryNumbers(1));
    }

    @Test
    void testGenerateZeroNumbers() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, BinaryNumberGenerator.generateBinaryNumbers(0));
    }

    @Test
    void testGenerateLargeN() {
        List<String> result = BinaryNumberGenerator.generateBinaryNumbers(10);
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101", "110", "111", "1000", "1001", "1010");
        assertEquals(expected, result);
    }
}
