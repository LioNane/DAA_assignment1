package algorithms;

import java.util.Random;

import static utils.HelpFunctions.swap;

public class QuickSelect {

    public static int quickSelect(int[] arr, int k){
        if (arr == null || arr.length <= 1 || !(k > 0) && !(k < arr.length - 1)){
            throw new IllegalArgumentException("Invalid array");
        }

        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int low, int high, int k){
        return 0;
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
