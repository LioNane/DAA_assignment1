public class QuickSort {
    public static void quickSort(int[] dataset){
        if (dataset == null || dataset.length <= 1){
            return;
        }

        quickSort(dataset, 0, dataset.length - 1);
    }

    private static void quickSort(int[] dataset, int low, int high){

    }

    private static int[] partition(int[] dataset, int low, int high){

    }
}
