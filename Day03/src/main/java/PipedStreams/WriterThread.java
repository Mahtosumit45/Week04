package PipedStreams;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriterThread extends Thread {
    private PipedOutputStream outputStream;

    public WriterThread(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        String message = "Hello from WriterThread!";
        try {
            System.out.println("Writer: Writing data...");
            outputStream.write(message.getBytes());
            outputStream.close(); // Close after writing
        } catch (IOException e) {
            System.err.println("WriterThread Error: " + e.getMessage());
        }
    }
}
