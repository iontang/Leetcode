package divideandconquer;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * 312. Burst Balloons : https://leetcode.com/problems/burst-balloons/description/
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i.
 * After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5[15]      +  3*5*8[120]    +  1*3*8[24]      + 1*8*1[8]   = 167
 *
 * 题意：在一个数组中，任意取三个数连乘，再删除中间那个数，接着，剩下的数做同样的操作，把所有操作的结果相加。
 *
 * 对比 215. Kth Largest Element in an Array 这道题目
 *
 */

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) return 0;
        if (len == 1) return nums[0];
        if (len == 2) { // 小于三个元素的
            return nums[0]*nums[1] + nums[1];
        }

        Arrays.sort(nums); // 算法中，先排序再处理的做法不对，[3,1,5,8] 最大值为167，但是先排序再处理的结果是160
        int result = 0;
        for (int i =len-2;i>0;i--) {
            result = result + nums[i-1] * nums[i] * nums[len-1];

        } // [3,1,5,8] [1,3,5,8]  120; 【1,3,8】24; [1,8] 8, [8] 8
        return result + nums[len-1]*nums[0] + nums[len-1];
    }



    // 具体的实现是： 在一个数组中找到最大的三个数的第一个数的下标【在一个数组中找到第K大的元素】，从这个数开始操作
    // 1、{6,5,7,4,8,9,2,3} ———— 对于这个数组，处理到{6,5,7,9,2,3}之后，如何处理
    // 2、{5,7,4,8,9,2}
    public static void main(String[] args) {
        int[] nums = {6,5,7,4,8,9,2,3};
        int len = nums.length-2;

        PriorityQueue priorityQueue = new PriorityQueue();
        for (int i =0 ;i<nums.length;i++) {
            priorityQueue.add(nums[i]);
            if (priorityQueue.size()>3) {
                priorityQueue.poll();
            }
        }
        System.out.println(priorityQueue.peek());


    }



}
