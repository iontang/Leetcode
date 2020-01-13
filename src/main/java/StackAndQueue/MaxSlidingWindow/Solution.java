package StackAndQueue.MaxSlidingWindow;

import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(nums,3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((w1, w2)-> w2-w1);
        int[] result = new int[nums.length-k +1];

        for (int i=0;i<k;i++) {
            priorityQueue.offer(nums[i]);
        }
        result[0] = priorityQueue.peek();
        for (int i=k;i<nums.length;i++) {
            priorityQueue.remove(nums[i-k]);
            priorityQueue.offer(nums[i]);
            result[i-k+1] = priorityQueue.peek();
        }
        return result;
    }
}