package problems_by_year.year_2020.month_09.problems_0914.Maximum_Subarray;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/15 10:22 上午
 */
// 53:
// Maximum Subarray
// maximum-subarray

//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum.
//
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle.
//
//
// Example 1:
//
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//
//
// Example 2:
//
//
//Input: nums = [1]
//Output: 1
//
//
// Example 3:
//
//
//Input: nums = [0]
//Output: 0
//
//
// Example 4:
//
//
//Input: nums = [-1]
//Output: -1
//
//
// Example 5:
//
//
//Input: nums = [-2147483647]
//Output: -2147483647
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 104
// -231 <= nums[i] <= 231 - 1
//
// Related Topics Array Divide and Conquer Dynamic Programming
// 👍 8907 👎 419


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        solution.maxSubArray(nums);
    }


    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray_A2(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int maxSubArray_A1(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int sumSoFar = 0;

        for(int i = 0; i != nums.length; i++) {
            sumSoFar = sumSoFar + nums[i];
            if(sumSoFar > maxSoFar) {
                maxSoFar = sumSoFar;
            }
            if(sumSoFar < 0) {
                sumSoFar = 0;
            }
        }

        return maxSoFar;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

