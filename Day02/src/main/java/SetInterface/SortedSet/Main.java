package SetInterface.SortedSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(5);
        numberSet.add(3);
        numberSet.add(9);
        numberSet.add(1);

        List<Integer> sortedList = SetToSortedList.convertToSortedList(numberSet);

        System.out.println("Sorted List: " + sortedList);
    }
}

