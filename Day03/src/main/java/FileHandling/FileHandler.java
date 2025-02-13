package FileHandling;

import java.io.*;

public class FileHandler {
    public boolean copyFile(String sourcePath, String destinationPath) {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist: " + sourcePath);
            return false;
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            return true; // File copied successfully
        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
            return false;
        }
    }
}

