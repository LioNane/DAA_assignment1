import algorithms.MergeSort;
import algorithms.QuickSelect;
import algorithms.QuickSort;
import metrics.Metrics;

private static final int[] SIZES = {1000, 10000, 100000, 1000000};
private static final String[] INPUT_TYPES = {"random", "sorted", "duplicates"};
private static final int RUNS = 5;
private static final String CSV_FILE = "results.csv";

private int[] generateArray(String type, int n){


    return new int[0];
}

private long calculateMedian(long[] times){


    return 0;
}

void main() {
    try(PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))){
        writer.println("algorithm,input,n,time_ms,comparisons,max_depth");
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
                            }
                            case "QuickSort": {
                                QuickSort.quickSort(dataset, metrics);
                            }
                            case "QuickSelect": {
                                int k = new Random().nextInt(n);
                                QuickSelect.quickSelect(dataset, k, metrics);
                            }
                            default:
                                break;
                        }

                        times[i] = metrics.getTimeMs();
                        lastComparisons = metrics.getComparisons();
                        lastMaxDepth = metrics.getMaxDepth();
                    }

                    long medianTime = calculateMedian(times);

                    writer.printf("%s,%s,%d,%d,%d$n",
                            algorithm, inputType, n, medianTime, lastComparisons, lastMaxDepth);
                }

            }
        }
        System.out.println("Benchmark finished, results saved in " + CSV_FILE);
    } catch (IOException e) {
        System.err.println("File writer error: " + e.getMessage());
    }
}