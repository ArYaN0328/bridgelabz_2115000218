
import java.util.List;

public class ListManager {
    public static void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    public static void removeElement(List<Integer> list, int element) {
        if (list != null) {
            list.remove(Integer.valueOf(element)); // Removes by value, not index
        }
    }

    public static int getSize(List<Integer> list) {
        return (list != null) ? list.size() : 0;
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        ListManager.addElement(list, 5);
        assertTrue(list.contains(5));
        assertEquals(1, list.size());

        ListManager.addElement(list, 10);
        assertTrue(list.contains(10));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveElement() {
        list.add(5);
        list.add(10);

        ListManager.removeElement(list, 5);
        assertFalse(list.contains(5));
        assertEquals(1, list.size());

        ListManager.removeElement(list, 20); // Removing a non-existing element
        assertEquals(1, list.size());
    }

    @Test
    void testGetSize() {
        assertEquals(0, ListManager.getSize(list));

        list.add(1);
        list.add(2);
        assertEquals(2, ListManager.getSize(list));

        list.remove(Integer.valueOf(1));
        assertEquals(1, ListManager.getSize(list));
    }

    @Test
    void testNullList() {
        assertDoesNotThrow(() -> ListManager.addElement(null, 5));
        assertDoesNotThrow(() -> ListManager.removeElement(null, 5));
        assertEquals(0, ListManager.getSize(null));
    }
}




