package PipedStreams;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReaderThread extends Thread {
    private PipedInputStream inputStream;
    private String receivedData;

    public ReaderThread(PipedInputStream inputStream) {
        this.inputStream = inputStream;
        this.receivedData = "";
    }

    @Override
    public void run() {
        try {
            System.out.println("Reader: Reading data...");
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            if (bytesRead > 0) {
                receivedData = new String(buffer, 0, bytesRead);
                System.out.println("Reader Received: " + receivedData);
            }
            inputStream.close();
        } catch (IOException e) {
            System.err.println("ReaderThread Error: " + e.getMessage());
        }
    }

    public String getReceivedData() {
        return receivedData;
    }
}

