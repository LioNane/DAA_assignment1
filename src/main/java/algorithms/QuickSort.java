package algorithms;

import java.util.Random;

import static utils.HelpFunctions.partition;
import static utils.HelpFunctions.swap;

public class QuickSort {

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
}
