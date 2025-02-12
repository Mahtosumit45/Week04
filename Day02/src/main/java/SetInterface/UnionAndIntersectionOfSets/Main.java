package SetInterface.UnionAndIntersectionOfSets;

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

        Set<Integer> unionResult = SetOperations.union(set1, set2);
        Set<Integer> intersectionResult = SetOperations.intersection(set1, set2);

        System.out.println("Union: " + unionResult);
        System.out.println("Intersection: " + intersectionResult);
    }
}

