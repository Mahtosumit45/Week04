package ReadUserInputFromConsole;

import java.io.FileWriter;
import java.io.IOException;

public class UserDataWriter {
    private String filePath;

    public UserDataWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(String name, int age, String language) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
        }
    }
}

