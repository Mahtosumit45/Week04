package ListInterface.RemoveDuplicateProblem;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void testArrayListRemoveDuplicates() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        ArrayListDuplicateRemover<Integer> remover = new ArrayListDuplicateRemover<>(list);
        remover.removeDuplicates();
        assertEquals(Arrays.asList(3, 1, 2, 4), remover.getList(), "ArrayList should have duplicates removed while preserving order");
    }

    @Test
    void testLinkedListRemoveDuplicates() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        LinkedListDuplicateRemover<Integer> remover = new LinkedListDuplicateRemover<>(list);
        remover.removeDuplicates();
        assertEquals(Arrays.asList(3, 1, 2, 4), remover.getList(), "LinkedList should have duplicates removed while preserving order");
    }

    @Test
    void testArrayListWithNoDuplicates() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayListDuplicateRemover<Integer> remover = new ArrayListDuplicateRemover<>(list);
        remover.removeDuplicates();
        assertEquals(Arrays.asList(1, 2, 3, 4), remover.getList(), "ArrayList without duplicates should remain unchanged");
    }

    @Test
    void testLinkedListWithNoDuplicates() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        LinkedListDuplicateRemover<Integer> remover = new LinkedListDuplicateRemover<>(list);
        remover.removeDuplicates();
        assertEquals(Arrays.asList(1, 2, 3, 4), remover.getList(), "LinkedList without duplicates should remain unchanged");
    }

    @Test
    void testArrayListEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayListDuplicateRemover<Integer> remover = new ArrayListDuplicateRemover<>(list);
        remover.removeDuplicates();
        assertTrue(remover.getList().isEmpty(), "Empty ArrayList should remain empty after duplicate removal");
    }

    @Test
    void testLinkedListEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedListDuplicateRemover<Integer> remover = new LinkedListDuplicateRemover<>(list);
        remover.removeDuplicates();
        assertTrue(remover.getList().isEmpty(), "Empty LinkedList should remain empty after duplicate removal");
    }

    @Test
    void testArrayListAllDuplicates() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
        ArrayListDuplicateRemover<Integer> remover = new ArrayListDuplicateRemover<>(list);
        remover.removeDuplicates();
        assertEquals(Arrays.asList(5), remover.getList(), "ArrayList with all duplicates should return a list with one element");
    }

    @Test
    void testLinkedListAllDuplicates() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(5, 5, 5, 5, 5));
        LinkedListDuplicateRemover<Integer> remover = new LinkedListDuplicateRemover<>(list);
        remover.removeDuplicates();
        assertEquals(Arrays.asList(5), remover.getList(), "LinkedList with all duplicates should return a list with one element");
    }
}
