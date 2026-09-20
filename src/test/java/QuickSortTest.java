import algorithms.MergeSort;
import algorithms.QuickSort;
import metrics.Metrics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    private Metrics metrics;
    private Random random;

    @BeforeEach
    void setUp(){
        metrics = new Metrics();
        random = new Random();
    }

    @Test
    @DisplayName("QuickSort: Correctness on 100 random arrays")
    void testCorrectness(){
        for (int i = 0; i < 100; i++) {
            int size = random.nextInt(1000) + 10;
            int[] actual = new int[size];
            for (int j = 0; j < size; j++) {
                actual[j] = random.nextInt(10000);
            }

            int[] expected = actual.clone();
            Arrays.sort(expected);

            QuickSort.quickSort(actual, metrics);

            assertArrayEquals(expected, actual, "Sort error on iteration: " + i);
        }

    }

    @Test
    @DisplayName("QuickSort: Edge Cases")
    void testEdgeCases(){
        int[] emptyArray = {};
        int[] singleElement = {1};
        int[] allDuplicates = {5, 5, 5, 5, 5};
        int[] alreadySorted = {1, 2, 3, 4, 5};

        assertDoesNotThrow(() -> QuickSort.quickSort(emptyArray, metrics));
        assertArrayEquals(new int[]{}, emptyArray);

        QuickSort.quickSort(singleElement, metrics);
        assertArrayEquals(new int[]{1}, singleElement);

        int[] dupClone = allDuplicates.clone();
        QuickSort.quickSort(dupClone, metrics);
        assertArrayEquals(allDuplicates, dupClone);

        int[] sortedClone = alreadySorted.clone();
        QuickSort.quickSort(sortedClone, metrics);
        assertArrayEquals(alreadySorted, sortedClone);
    }

    @Test
    @DisplayName("QuickSort: Check maxDepth")
    void testRecursionDepth(){
        int n = 100000;
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArray[i] = i;
        }

        QuickSort.quickSort(sortedArray, metrics);

        double maxAllowedDepth = 2 * (Math.log(n) / Math.log(2));

        assertTrue(metrics.getMaxDepth() <= maxAllowedDepth,
                "Recursion depth " + metrics.getMaxDepth() + " exceeds limit " + maxAllowedDepth);
    }
}
