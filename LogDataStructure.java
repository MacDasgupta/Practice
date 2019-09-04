package DailyCodingProblem;


//Implementing a circular buffer suffices the requirement. It takes O(1) to record and get last ith.
public class LogDataStructure {
    private int maxSize;
    private int[] circularBuffer;
    private int currIdx;

    public LogDataStructure(int n) {
        this.maxSize = n;
        this.circularBuffer = new int[n];
        this.currIdx = 0;
    }

    public void record(int orderId) {
        circularBuffer[currIdx] = orderId;
        currIdx = (currIdx + 1) % maxSize;
    }

    public int getLast(int i) {
        return circularBuffer[(currIdx - i + maxSize) % maxSize];
    }
}