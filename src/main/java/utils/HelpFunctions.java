package utils;

import metrics.Metrics;

import java.util.Random;

public class HelpFunctions {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] partition(int[] dataset, int low, int high, Metrics metrics){
        Random random = new Random();

        int random_index = random.nextInt(high - low + 1) + low;
        swap(dataset, high, random_index);
        int pivot = dataset[high];

        int ltp = low;
        int ep = low;
        int htp = high;

        int[] borders = new int[2];

        while(ep <= htp){

            metrics.incrementComparisons();
            if(dataset[ep] < pivot){
                swap(dataset, ltp, ep);
                ltp++;
                ep++;
            } else if (dataset[ep] > pivot) {
                metrics.incrementComparisons();
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
