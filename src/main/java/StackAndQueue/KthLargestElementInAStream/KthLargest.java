package StackAndQueue.KthLargestElementInAStream;

import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    Integer topK = null;

    public KthLargest(int k, int[] nums) {
        this.topK = k;
        for (int i : nums) {
            add(i);
        }
    }

    // the problem allow same value in array.
    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > topK) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {2,7,3,5};
        KthLargest obj = new KthLargest(3, nums);
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


