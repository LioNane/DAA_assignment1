package algorithms;

import metrics.Metrics;

import static utils.InsertionSort.insertionSort;

public class MergeSort {

    public static void mergeSort(int[] dataset, Metrics metrics){
        if (dataset == null || dataset.length <= 1){
            return;
        }

        metrics.startTimer();
        int[] buffer = new int[dataset.length];

        split(dataset,buffer, 0, dataset.length-1, 1, metrics);
        metrics.stopTimer();
    }

    private static void split(int[] dataset, int[] buffer, int left, int right, int currentDepth, Metrics metrics){
        if (right - left + 1 <= 15){
            insertionSort(dataset, left, right, metrics);
        return;
        }

        int mid = left + (right - left) / 2;

        split(dataset, buffer, left, mid, currentDepth + 1, metrics);
        split(dataset, buffer, mid + 1, right, currentDepth + 1, metrics);

        merge(dataset, buffer, left, mid, right, metrics);
    }

    private static void merge(int[] dataset, int[] buffer, int left, int mid, int right, Metrics metrics){
        if (right + 1 - left >= 0) System.arraycopy(dataset, left, buffer, left, right + 1 - left);

        int left_buffer = left;
        int right_buffer = mid + 1;
        int dataset_index = left;

        while (left_buffer <= mid && right_buffer < right + 1){

            metrics.incrementComparisons();

            if (buffer[left_buffer] <= buffer[right_buffer]){
                dataset[dataset_index] = buffer[left_buffer];
                left_buffer++;
            } else{
                dataset[dataset_index] = buffer[right_buffer];
                right_buffer++;
            }
            dataset_index++;
        }
        while (left_buffer <= mid){
            dataset[dataset_index] = buffer[left_buffer];
            left_buffer++;
            dataset_index++;
        }
    }

}
