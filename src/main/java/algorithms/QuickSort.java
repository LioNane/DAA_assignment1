package algorithms;


import metrics.Metrics;

import static utils.HelpFunctions.partition;

public class QuickSort {

    public static void quickSort(int[] dataset, Metrics metrics){
        if (dataset == null || dataset.length <= 1){
            return;
        }

        metrics.startTimer();
        sort(dataset, 0, dataset.length - 1, 1, metrics);
        metrics.stopTimer();
    }

    private static void sort(int[] dataset, int low, int high, int currentDepth, Metrics metrics){

        metrics.updateDepth(currentDepth);

        while (low < high){
            int[] borders = partition(dataset, low, high, metrics);

            int leftSize = borders[0] - low;
            int rightSize = high - borders[1];

            metrics.incrementComparisons();

            if(leftSize < rightSize){
                sort(dataset, low, borders[0] - 1, currentDepth + 1, metrics);
                low = borders[1] + 1;
            } else {
                sort(dataset, borders[1] + 1, high, currentDepth + 1, metrics);
                high = borders[0] - 1;
            }
        }
    }
}
