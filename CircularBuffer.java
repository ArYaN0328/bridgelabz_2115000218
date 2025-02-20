
import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    // Add element to the buffer (overwrite if full)
    public void add(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % buffer.length;
        if (size < buffer.length) {
            size++;
        } else {
            head = (head + 1) % buffer.length; // Overwrite oldest
        }
    }

    // Get the buffer contents
    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(head + i) % buffer.length]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println("Buffer: " + buffer.getBuffer()); // Output: [1, 2, 3]

        buffer.add(4);
        System.out.println("Buffer after adding 4: " + buffer.getBuffer()); // Output: [2, 3, 4]

        buffer.add(5);
        System.out.println("Buffer after adding 5: " + buffer.getBuffer()); // Output: [3, 4, 5]
    }
}

