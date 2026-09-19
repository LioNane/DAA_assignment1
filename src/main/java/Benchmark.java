import algorithms.MergeSort;
import algorithms.QuickSelect;
import algorithms.QuickSort;
import metrics.Metrics;

import static utils.HelpFunctions.swap;


private static final int[] SIZES = {1000, 10000, 100000, 1000000};
private static final String[] INPUT_TYPES = {"random", "sorted", "duplicates"};
private static final int RUNS = 5;
private static final String CSV_FILE = "results.csv";

private int[] generateArray(String type, int n){
    int[] arr = new int[n];
    Random random = new Random();

    switch (type){
        case "random":
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }

            for (int i = n - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                swap(arr, i, j);
            }
            break;
        case "sorted":
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt();
            }
            Arrays.sort(arr);
            break;
        case "duplicates":
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt(10);
            }
            break;
    }
    return arr;
}

private long calculateMedian(long[] times){
    Arrays.sort(times);
    return times[times.length/2];
}

void main() {
    try(PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))){
        writer.println("algorithm,input,n,time_ns,comparisons,max_depth");
        for (String algorithm: new String[]{"MergeSort", "QuickSort", "QuickSelect"}){
            for (String inputType: INPUT_TYPES){
                for (int n: SIZES){
                    long[] times = new long[RUNS];
                    long lastComparisons = 0;
                    int lastMaxDepth = 0;

                    for (int i = 0; i < RUNS; i++) {
                        int[] dataset = generateArray(inputType, n);
                        Metrics metrics = new Metrics();

                        switch (algorithm){
                            case "MergeSort": {
                                MergeSort.mergeSort(dataset, metrics);
                                break;
                            }
                            case "QuickSort": {
                                QuickSort.quickSort(dataset, metrics);
                                break;
                            }
                            case "QuickSelect": {
                                int k = new Random().nextInt(n);
                                QuickSelect.quickSelect(dataset, k, metrics);
                                break;
                            }
                            default:
                                break;
                        }

                        times[i] = metrics.getTimeNs();
                        lastComparisons = metrics.getComparisons();
                        lastMaxDepth = metrics.getMaxDepth();
                    }

                    long medianTime = calculateMedian(times);

                    writer.printf("%s,%s,%d,%d,%d,%d%n",
                            algorithm, inputType, n, medianTime, lastComparisons, lastMaxDepth);
                }

            }
        }
        System.out.println("Benchmark finished, results saved in " + CSV_FILE);
    } catch (IOException e) {
        System.err.println("File writer error: " + e.getMessage());
    }
}