import java.util.Random;

public class QuickSort {
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(int[] dataset){
        if (dataset == null || dataset.length <= 1){
            return;
        }

        quickSort(dataset, 0, dataset.length - 1);
    }

    private static void quickSort(int[] dataset, int low, int high){
        while (low < high){
            int[] borders = partition(dataset, low, high);

            int leftSize = borders[0] - low;
            int rightSize = high - borders[1];

            if(leftSize < rightSize){
                quickSort(dataset, low, borders[0] - 1);
                low = borders[1] + 1;
            } else {
                quickSort(dataset, borders[1] + 1, high);
                high = borders[0] - 1;
            }
        }
    }

    private static int[] partition(int[] dataset, int low, int high){
        Random random = new Random();

        int random_index = random.nextInt(high - low + 1) + low;
        swap(dataset, high, random_index);
        int pivot = dataset[high];

        int ltp = low;
        int ep = low;
        int htp = high;

        int[] borders = new int[2];

        while(ep <= htp){
            if(dataset[ep] < pivot){
                swap(dataset, ltp, ep);
                ltp++;
                ep++;
            } else if (dataset[ep] > pivot) {
                swap(dataset, htp, ep);
                htp--;
            } else {
                ep++;
            }
        }

        borders[0] = ltp;
        borders[1] = htp;

        return borders;
    }
}
