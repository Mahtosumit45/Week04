package ListInterface.RotateElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

// Main class
public class Main {
    public static void main(String[] args) {
        // Rotate ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);
        System.out.println("Original ArrayList: " + arrayList);

        ArrayListRotator<Integer> arrayListRotator = new ArrayListRotator<>(arrayList);
        arrayListRotator.rotate(2);
        System.out.println("Rotated ArrayList: " + arrayListRotator.getList());

        // Rotate LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        System.out.println("\nOriginal LinkedList: " + linkedList);

        LinkedListRotator<Integer> linkedListRotator = new LinkedListRotator<>(linkedList);
        linkedListRotator.rotate(2);
        System.out.println("Rotated LinkedList: " + linkedListRotator.getList());
    }
}

