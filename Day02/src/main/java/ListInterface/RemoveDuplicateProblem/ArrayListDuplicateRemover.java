package ListInterface.RemoveDuplicateProblem;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Class to remove duplicates from an ArrayList
class ArrayListDuplicateRemover<T> {
    private List<T> list;

    public ArrayListDuplicateRemover(List<T> list) {
        this.list = list;
    }

    public void removeDuplicates() {
        Set<T> seen = new LinkedHashSet<>(list); // Maintains insertion order while removing duplicates
        list.clear();
        list.addAll(seen);
    }

    public List<T> getList() {
        return list;
    }
}
