package ListInterface.NthElementFromEnd;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class LinkedListNthElementFinder<T> {
    private LinkedList<T> list;

    public LinkedListNthElementFinder(LinkedList<T> list) {
        this.list = list;
    }

    public T findNthFromEnd(int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input: List cannot be null and N must be greater than 0.");
        }

        var fast = list.listIterator();
        var slow = list.listIterator();

        // Move the fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new NoSuchElementException("N is larger than the linked list size.");
            }
            fast.next();
        }

        // Move both pointers one step at a time until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }
}

