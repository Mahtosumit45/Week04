package ListInterface.ReverseListProblem;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Reverse ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original ArrayList: " + list);

        // Pass the list to the constructor
        ArrayListReverse<Integer> arrayListReverse = new ArrayListReverse<>(list);
        arrayListReverse.reverse();
        System.out.println("Reversed ArrayList: " + arrayListReverse.getList());

        // Reverse LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("\nOriginal LinkedList: " + linkedList);

        // Pass the list to the constructor
        LinkedListReverser<Integer> linkedListReverser = new LinkedListReverser<>(linkedList);
        linkedListReverser.reverse();
        System.out.println("Reversed LinkedList: " + linkedListReverser.getList());
    }
}
