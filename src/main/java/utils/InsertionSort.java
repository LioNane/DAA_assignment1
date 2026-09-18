package utils;

public class InsertionSort {
    public static void insertionSort(int[] dataset, int left, int right){
        int buf = 0;
        int elem = 0;
        int j = 0;
        for (int i = left + 1; i <= right; i++) {
            elem = dataset[i];
            j = i - 1;

            while (j >= left && dataset[j] > elem){
                dataset[j + 1] = dataset[j];
                j -= 1;
            }

            dataset[j + 1] = elem;
        }
    }
}
