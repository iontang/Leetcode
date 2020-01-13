package StackAndQueue.FindMedianFromDataStream;

import java.util.PriorityQueue;

public class MfBak {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((w1, w2)->w2-w1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MfBak() {

    }

    public void addNum(int num) {

        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size()>minHeap.size()? maxHeap.peek() : 0.5*(maxHeap.peek() + minHeap.peek());
    }

}
