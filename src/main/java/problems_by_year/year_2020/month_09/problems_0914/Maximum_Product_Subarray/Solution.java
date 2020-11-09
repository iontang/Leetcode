package problems_by_year.year_2020.month_09.problems_0914.Maximum_Product_Subarray;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/15 11:33 上午
 */
// 152:
// Maximum Product Subarray
// maximum-product-subarray

//Given an integer array nums, find the contiguous subarray within an array (con
//taining at least one number) which has the largest product.
//
// Example 1:
//
//
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
//
//
// Example 2:
//
//
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// Related Topics Array Dynamic Programming
// 👍 5015 👎 174


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxProduct_W1(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i : nums) {
            if (i > 0) {
                sum += i;
            } else {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        return max;
    }


    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]*nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxNonNegativeSubArray(int[] A) {
        int max = 0;
        int sum = 0;
        boolean isAll = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                sum += A[i];
                isAll =false;
            } else if (A[i] <0 && i < A.length-1) {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        return isAll ? -1 : Math.max(max, sum);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

