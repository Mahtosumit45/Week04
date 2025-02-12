package ListInterface.NthElementFromEnd;

import java.util.LinkedList;
import java.util.NoSuchElementException;

// Main class for testing
public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        System.out.println("Original LinkedList: " + linkedList);

        LinkedListNthElementFinder<String> finder = new LinkedListNthElementFinder<>(linkedList);
        int n = 2;
        System.out.println(n + "th element from the end: " + finder.findNthFromEnd(n));
    }
}

