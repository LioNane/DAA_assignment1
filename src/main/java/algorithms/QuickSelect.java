package algorithms;

import static utils.HelpFunctions.partition;

public class QuickSelect {

    public static int quickSelect(int[] arr, int k){
        if (arr == null || arr.length == 0 || k < 0 || k >= arr.length){
            throw new IllegalArgumentException("Invalid array");
        }

        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int low, int high, int k){
        int[] borders;
        while (low <= high){
            borders = partition(arr, low, high);
            if (k < borders[0]){
                high = borders[0] - 1;
            } else if (k > borders[1]) {
                low = borders[1] + 1;
            } else {
                return arr[k];
            }
        }
        return 0;
    }
}
