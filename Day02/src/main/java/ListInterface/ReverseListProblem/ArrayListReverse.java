package ListInterface.ReverseListProblem;

import java.util.ArrayList;

public class ArrayListReverse<T>{
    private ArrayList<T> list;
    public ArrayListReverse(ArrayList<T> list) {
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
    public ArrayList<T> getList() {
        return list;
    }
}
