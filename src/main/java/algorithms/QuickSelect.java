package algorithms;

import metrics.Metrics;

import static utils.HelpFunctions.partition;

public class QuickSelect {

    public static int quickSelect(int[] arr, int k, Metrics metrics){
        if (arr == null || arr.length == 0 || k < 0 || k >= arr.length){
            throw new IllegalArgumentException("Invalid array");
        }

        metrics.startTimer();
        return select(arr, 0, arr.length - 1, k, metrics);
    }

    private static int select(int[] arr, int low, int high, int k, Metrics metrics){
        int[] borders;
        while (low <= high){
            borders = partition(arr, low, high, metrics);

            metrics.incrementComparisons();
            if (k < borders[0]){
                high = borders[0] - 1;
            } else if (k > borders[1]) {
                metrics.incrementComparisons();
                low = borders[1] + 1;
            } else {
                metrics.stopTimer();
                return arr[k];
            }
        }
        metrics.stopTimer();
        return 0;
    }
}
