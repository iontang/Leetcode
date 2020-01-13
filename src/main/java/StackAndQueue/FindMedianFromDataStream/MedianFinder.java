package StackAndQueue.FindMedianFromDataStream;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MedianFinder {

    public static void main(String[] args) {
        // 1 2 3 4
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((w1,w2)->w2-w1);
        maxHeap.add(4);
        maxHeap.add(1);
        maxHeap.add(7);
        maxHeap.add(10);


    }

//    List<Integer> list  = new LinkedList<Integer>();
    /** initialize your data structure here. */
    // Time limit exceeded if use list.
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((w1,w2)->w2-w1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {


    }

    public void addNum(int num) {

        if (maxHeap.peek() != null && num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else if (minHeap.peek() != null && num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            if (maxHeap.peek() == null) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size()-minHeap.size()>1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap == null && minHeap == null)
            return 0.0;
        if (maxHeap.size()>minHeap.size()) {
            return maxHeap.peek();
        } else {
//            double minV = (minHeap.peek() == null ? 0.0 : minHeap.peek());
            return ( double) (maxHeap.peek() + minHeap.peek()) /2;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


}
