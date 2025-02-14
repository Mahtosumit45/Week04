package ReadLargeFileLineByLine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LargeFileReader {
    private final File file;

    public LargeFileReader(String filePath) {
        this.file = new File(filePath);
    }

    public List<String> readLinesContainingError() {
        List<String> errorLines = new ArrayList<>();

        if (!file.exists()) {
            System.err.println("File not found: " + file.getAbsolutePath());
            return errorLines;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    errorLines.add(line);
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return errorLines;
    }
}
