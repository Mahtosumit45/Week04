package SetInterface.SymmetricDifference;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> symmetricDifference = SetOperations.symmetricDifference(set1, set2);

        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}

