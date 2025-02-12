package ListInterface.RemoveDuplicateProblem;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Class to remove duplicates from a LinkedList
class LinkedListDuplicateRemover<T> {
    private LinkedList<T> list;

    public LinkedListDuplicateRemover(LinkedList<T> list) {
        this.list = list;
    }

    public void removeDuplicates() {
        Set<T> seen = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(seen);
    }

    public LinkedList<T> getList() {
        return list;
    }
}

