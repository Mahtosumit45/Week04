package ReadLargeFileLineByLine;

public class Main {
    public static void main(String[] args) {
        String filePath ="/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/largefile.txt";

        LargeFileReader fileReader = new LargeFileReader(filePath);
        fileReader.readLinesContainingError();
    }
}

