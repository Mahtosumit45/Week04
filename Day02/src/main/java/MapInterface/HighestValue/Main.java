package MapInterface.HighestValue;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        String maxKey = MaxValueKeyFinder.findMaxKey(inputMap);
        System.out.println("Key with max value: " + maxKey);
    }
}

