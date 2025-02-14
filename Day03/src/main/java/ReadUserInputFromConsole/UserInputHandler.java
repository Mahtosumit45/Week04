package ReadUserInputFromConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputHandler {
    private BufferedReader reader;

    public UserInputHandler() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readInput(String prompt) throws IOException {
        System.out.print(prompt);
        return reader.readLine();
    }
}

