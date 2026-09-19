package utils;

import metrics.Metrics;

public class InsertionSort {
    public static void insertionSort(int[] dataset, int left, int right, Metrics metrics){

        int elem;
        int j;
        for (int i = left + 1; i <= right; i++) {
            elem = dataset[i];
            j = i - 1;

            while (j >= left){
                metrics.incrementComparisons();

                if (dataset[j] > elem){
                    dataset[j + 1] = dataset[j];
                    j--;
                }
                else {
                    break;
                }
            }

            dataset[j + 1] = elem;
        }
    }
}
