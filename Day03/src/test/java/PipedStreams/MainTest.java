package PipedStreams;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class PipedStreamTest {

    @Test
    void testPipedStreamCommunication() throws IOException, InterruptedException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        ReaderThread reader = new ReaderThread(pis);
        WriterThread writer = new WriterThread(pos);

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        assertEquals("Hello from WriterThread!", reader.getReceivedData());
    }
}
