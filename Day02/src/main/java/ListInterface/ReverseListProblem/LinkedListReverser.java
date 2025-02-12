package ListInterface.ReverseListProblem;

import java.util.LinkedList;

public class LinkedListReverser<T> {
    private LinkedList<T> list;

    public LinkedListReverser(LinkedList<T> list) {
        this.list = list;
    }
    public void reverse() {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public LinkedList<T> getList(){
        return list;
    }
}
