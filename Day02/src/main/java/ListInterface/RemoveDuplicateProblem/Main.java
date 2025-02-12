package ListInterface.RemoveDuplicateProblem;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Main class
public class Main {
    public static void main(String[] args) {
        // Remove duplicates from ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println("Original ArrayList: " + arrayList);

        ArrayListDuplicateRemover<Integer> arrayListRemover = new ArrayListDuplicateRemover<>(arrayList);
        arrayListRemover.removeDuplicates();
        System.out.println("ArrayList after removing duplicates: " + arrayListRemover.getList());

        // Remove duplicates from LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println("\nOriginal LinkedList: " + linkedList);

        LinkedListDuplicateRemover<Integer> linkedListRemover = new LinkedListDuplicateRemover<>(linkedList);
        linkedListRemover.removeDuplicates();
        System.out.println("LinkedList after removing duplicates: " + linkedListRemover.getList());
    }
}

