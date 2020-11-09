package divideandconquer;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * 这道题目有巧解的方法：使用快排的思想
 *
 */


public class KthLargestElementInAnArray {

    /**
     * Arrays.sort(nums, Collections.reverseOrder()) 无法对一个int数组进行降序排序，解决的办法有：
     * 1、利用java 8的新特性，先把int[]数组转化为Integer数组
     * 2、不需要倒序排，正序排列好以后，取 n-k位上的值
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Integer[] numsNew = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsNew, Collections.reverseOrder());
        return numsNew[k-1];
//        final int N = nums.length;
//        Arrays.sort(nums);
//        return nums[N - k];

    }


    /**
     * 利用java 数据结构 PriorityQueue
     */
    public int findKthLargest_A1(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i : nums) {
            priorityQueue.add(i);
            if (priorityQueue.size()>k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }


    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        kthLargestElementInAnArray.findKthLargest(nums, 4);
    }

}
