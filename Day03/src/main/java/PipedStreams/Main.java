package PipedStreams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error in PipedStreamDemo: " + e.getMessage());
        }
    }
}


