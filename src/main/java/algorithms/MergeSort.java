package algorithms;

import static utils.InsertionSort.insertionSort;

public class MergeSort {

    public static void mergeSort(int[] dataset){
        if (dataset == null || dataset.length <= 1){
            return;
        }

        int[] buffer = new int[dataset.length];

        mergeSort(dataset,buffer,0, dataset.length-1);
    }

    private static void mergeSort(int[] dataset, int[] buffer, int left, int right){
        if (right - left + 1 <= 15){
            insertionSort(dataset, left, right);
        return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(dataset, buffer, left, mid);
        mergeSort(dataset, buffer, mid + 1, right);

        merge(dataset, buffer, left, mid, right);
    }

    private static void merge(int[] dataset, int[] buffer, int left, int mid, int right){
        if (right + 1 - left >= 0) System.arraycopy(dataset, left, buffer, left, right + 1 - left);

        int left_buffer = left;
        int right_buffer = mid + 1;
        int dataset_index = left;

        while (left_buffer <= mid && right_buffer < right + 1){
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
