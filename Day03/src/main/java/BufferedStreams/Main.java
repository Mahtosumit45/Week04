package BufferedStreams;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        String sourceFile = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/largefile.txt";  // Replace with actual file path
        String destBuffered = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/opy_buffered.txt";
        String destUnbuffered = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/copy_unbuffered.txt";

        try {
            // Measure Buffered Copy Performance
            long startBuffered = System.nanoTime();
            FileCopyUtility.copyFileWithBuffer(sourceFile, destBuffered);
            long endBuffered = System.nanoTime();
            System.out.println("Buffered Copy Time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

            // Measure Unbuffered Copy Performance
            long startUnbuffered = System.nanoTime();
            FileCopyUtility.copyFileWithoutBuffer(sourceFile, destUnbuffered);
            long endUnbuffered = System.nanoTime();
            System.out.println("Unbuffered Copy Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.err.println("File operation failed: " + e.getMessage());
        }
    }
}

