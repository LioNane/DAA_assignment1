import algorithms.MergeSort;
import algorithms.QuickSort;
import metrics.Metrics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    private Metrics metrics;
    private Random random;

    @BeforeEach
    void setUp(){
        metrics = new Metrics();
        random = new Random();
    }

    @Test
    @DisplayName("MergeSort: Correctness on 100 random arrays")
    void testCorrectness(){
        for (int i = 0; i < 100; i++) {
            int size = random.nextInt(1000) + 10;
            int[] actual = new int[size];
            for (int j = 0; j < size; j++) {
                actual[j] = random.nextInt(10000);
            }

            int[] expected = actual.clone();
            Arrays.sort(expected);

            MergeSort.mergeSort(actual, metrics);

            assertArrayEquals(expected, actual, "Sort error on iteration: " + i);
        }

    }

    @Test
    @DisplayName("MergeSort: Edge Cases")
    void testEdgeCases(){
        int[] emptyArray = {};
        int[] singleElement = {1};
        int[] allDuplicates = {5, 5, 5, 5, 5};
        int[] alreadySorted = {1, 2, 3, 4, 5};

        assertDoesNotThrow(() -> MergeSort.mergeSort(emptyArray, metrics));
        assertArrayEquals(new int[]{}, emptyArray);

        MergeSort.mergeSort(singleElement, metrics);
        assertArrayEquals(new int[]{1}, singleElement);

        int[] dupClone = allDuplicates.clone();
        MergeSort.mergeSort(dupClone, metrics);
        assertArrayEquals(allDuplicates, dupClone);

        int[] sortedClone = alreadySorted.clone();
        MergeSort.mergeSort(sortedClone, metrics);
        assertArrayEquals(alreadySorted, sortedClone);
    }

}
