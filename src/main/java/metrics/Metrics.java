package metrics;

public class Metrics {
    private long comparisons = 0;
    private int maxDepth = 0;
    private long startTime;
    private long endTime;

    public long getComparisons() {
        return comparisons;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void incrementComparisons(){
        comparisons++;
    }

    public void updateDepth(int currentDepth){
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void startTimer(){
        startTime = System.nanoTime();
    }

    public void stopTimer(){
        endTime = System.nanoTime();
    }

    public long getTimeMs(){
        return (endTime - startTime) / 1000000;
    }
}
