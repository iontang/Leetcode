package problems_by_year.year_2020.month_04.problems_20200420.Contiguous_Array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
     *
     * Example 1:
     * Input: [0,1]
     * Output: 2
     * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     * Example 2:
     * Input: [0,1,0]
     * Output: 2
     * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     * Note: The length of the given binary array will not exceed 50,000.
     * 1,1,0,0,1,1,1,0,
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        // 比如就拿例子1来说，nums = [0, 1]，当遍历0的时候，sum = -1，此时建立 -1 -> 0 的映射，
        // 当遍历到1的时候，此时sum = 0 了，若 HashMap 中没有初始化一个 0 -> -1 的映射，此时会建立 0 -> 1 的映射，
        // 而不是去更新这个满足题意的子数组的长度，所以要这么初始化，参见代码如下：
        Map<Integer, Integer> sumIndexMax = new HashMap<>();
        sumIndexMax.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = (nums[i] == 0) ? -1 : 1;
            sum += value;
            if (sumIndexMax.containsKey(sum)) {
                res = Math.max(res, i-sumIndexMax.get(sum));
            } else {
                sumIndexMax.put(sum, i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int pre=0, last =0;
        System.out.println(last);
        System.out.println(pre);
    }




}
