package SetInterface.SortedSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        sortedList.sort(Integer::compareTo); // Sorts in ascending order
        return sortedList;
    }

    // Alternative, shorter method using TreeSet (which sorts elements automatically)
    public static List<Integer> convertUsingTreeSet(Set<Integer> set) {
        return new ArrayList<>(new TreeSet<>(set)); // Converts HashSet to TreeSet and then to List
    }
}

