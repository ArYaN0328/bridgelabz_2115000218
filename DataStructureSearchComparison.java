
import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000}; // Different dataset sizes

        for (int size : datasetSizes) {
            System.out.println("\nDataset Size (N): " + size);

            int[] array = generateArray(size);
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int num : array) {
                hashSet.add(num);
                treeSet.add(num);
            }

            int target = array[size / 2]; // Search for a middle element

            measureTime("Array Search (O(N))", () -> arraySearch(array, target));
            measureTime("HashSet Search (O(1))", () -> hashSet.contains(target));
            measureTime("TreeSet Search (O(log N))", () -> treeSet.contains(target));
        }
    }

    // Utility to measure execution time
    private static void measureTime(String method, Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        System.out.println(method + " took " + elapsedTime + " ms");
    }

    // Generate an array with random integers
    private static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10); // Ensure diverse values
        }
        return array;
    }

    // Linear search in an array (O(N))
    private static boolean arraySearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}

