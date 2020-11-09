package dp.lintcode.p11_maximum_subarray_difference;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/14 4:47 下午
 */
public class Solution {


    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        int n = nums.length;
        int max = 0;
        int left = 0;
        int right = n-1;
        while (left < right) {
            max = Math.max(max, Math.abs(nums[left] - nums[right]));
        }

        return 0;
    }

}
