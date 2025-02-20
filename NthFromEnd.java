import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2; // Find the 2nd element from the end

        System.out.println("LinkedList: " + list);
        String result = findNthFromEnd(list, N);
        System.out.println(N + "th element from the end: " + result);
    }

    public static String findNthFromEnd(LinkedList<String> list, int N) {
        // Edge case: If list is empty or N is invalid
        if (list == null || N <= 0) {
            throw new IllegalArgumentException("Invalid input: List is empty or N is out of range.");
        }

        // Use two iterators (slow and fast)
        ListIterator<String> fast = list.listIterator();
        ListIterator<String> slow = list.listIterator();

        // Move the fast pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                throw new IllegalArgumentException("N is larger than the list size.");
            }
        }

        // Move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // The slow pointer is now at the Nth element from the end
        return slow.next();
    }
}