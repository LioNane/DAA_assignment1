import algorithms.QuickSelect;
import algorithms.QuickSort;
import metrics.Metrics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSelectTest {

    private Metrics metrics;
    private Random random;

    @BeforeEach
    void setUp(){
        metrics = new Metrics();
        random = new Random();
    }

    @Test
    @DisplayName("QuickSelect: Correctness on 100 random arrays")
    void testCorrectness(){
        for (int i = 0; i < 100; i++) {
            int size = random.nextInt(1000) + 10;
            int[] dataset = new int[size];
            for (int j = 0; j < size; j++) {
                dataset[j] = random.nextInt(10000);
            }

            int[] sortedCopy = dataset.clone();
            Arrays.sort(sortedCopy);

            int k = random.nextInt(size);
            int result = QuickSelect.quickSelect(dataset, k, metrics);

            assertEquals(sortedCopy[k], result, "Invalid k-nth element on iteration: " + i);
        }

    }

    @Test
    @DisplayName("QuickSelect: Validation Test")
    void testInvalidInput(){
        int[] emptyArray = {};
        int[] validArray = {1, 2, 3, 4, 5};

        Exception emptyException = assertThrows(IllegalArgumentException.class,
                () -> QuickSelect.quickSelect(emptyArray, 0, metrics));
        assertNotNull(emptyException.getMessage());

        Exception negativeException = assertThrows(IllegalArgumentException.class,
                () -> QuickSelect.quickSelect(emptyArray, -1, metrics));
        assertNotNull(negativeException.getMessage());

        Exception outOfBoundsKException = assertThrows(IllegalArgumentException.class,
                () -> QuickSelect.quickSelect(emptyArray, 10, metrics));
        assertNotNull(outOfBoundsKException.getMessage());
    }
}
