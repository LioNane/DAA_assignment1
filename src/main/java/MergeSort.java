public class MergeSort {

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void mergeSort(int[] dataset){
        if (dataset == null || dataset.length < 1){
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
        for (int i = left; i <= right ; i++) {
            buffer[i] = dataset[i];
        }

        int left_buffer = left;
        int right_buffer = mid + 1;
        int dataset_index = left;

        while (left_buffer < mid && right_buffer < right + 1){
            if (buffer[left_buffer] < buffer[right_buffer]){
                dataset[dataset_index] = buffer[left_buffer];
                left_buffer++;
            } else if (buffer[right_buffer] < buffer[left_buffer]) {
                dataset[dataset_index] = buffer[left_buffer];
                right_buffer++;
            }
            dataset_index++;
        }
        while (left_buffer < mid){
            dataset[dataset_index] = buffer[left_buffer];
            left_buffer++;
            dataset_index++;
        }
        while (right_buffer < mid){
            dataset[dataset_index] = buffer[right_buffer];
            right_buffer++;
            dataset_index++;
        }
    }

    private static void insertionSort(int[] dataset, int left, int right){
        int buf = 0;
        int elem = 0;
        int j = 0;
        for (int i = left + 1; i < right; i++) {
            elem = dataset[i];
            j = i - 1;

            while (j >= 0 && dataset[j] > elem){
                dataset[j + 1] = dataset[j];
                j -= 1;
            }

            dataset[j + 1] = elem;
        }
    }
}
