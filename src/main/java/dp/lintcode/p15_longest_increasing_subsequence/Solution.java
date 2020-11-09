package dp.lintcode.p15_longest_increasing_subsequence;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/5 2:23 下午
 */
public class Solution {

    public int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) {
            int maxDp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxDp = Math.max(maxDp, dp[j]);
                }
            }
            dp[i] = maxDp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
