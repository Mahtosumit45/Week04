package ListInterface.RotateElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

// Class to rotate an ArrayList
class ArrayListRotator<T> {
    private ArrayList<T> list;

    public ArrayListRotator(ArrayList<T> list) {
        this.list = list;
    }

    public void rotate(int positions) {
        int n = list.size();
        if (n == 0 || positions % n == 0) return; // No need to rotate if empty or full cycle
        positions = positions % n; // Handle rotations greater than list size
        Collections.rotate(list, -positions); // Using built-in rotate method
    }

    public ArrayList<T> getList() {
        return list;
    }
}

