package ListInterface.RotateElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

// Class to rotate a LinkedList
class LinkedListRotator<T> {
    private LinkedList<T> list;

    public LinkedListRotator(LinkedList<T> list) {
        this.list = list;
    }

    public void rotate(int positions) {
        int n = list.size();
        if (n == 0 || positions % n == 0) return;
        positions = positions % n;

        for (int i = 0; i < positions; i++) {
            T temp = list.removeFirst();
            list.addLast(temp);
        }
    }

    public LinkedList<T> getList() {
        return list;
    }
}
