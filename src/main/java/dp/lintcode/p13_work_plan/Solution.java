package dp.lintcode.p13_work_plan;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/18 8:24 上午
 */
public class Solution {
    /**
     * @param low:  the simple task
     * @param high: the complex task
     * @return: the most value
     */
    public int workPlan(int[] low, int[] high) {
        // Write your code here.
        int n = low.length;
        int[][] dp = new int[n][2];
        dp[0][0] = low[0];
        // 如果是复杂任务，前一周一定是需要休息的。
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = low[i] + Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (i != 1) {
                dp[i][1] = high[i] + Math.max(dp[i - 2][0], dp[i - 2][1]);
            } else {
                dp[i][1] = high[i];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int workPlan_A1(int[] low, int[] high) {
        int n = low.length;
        int[] dp = new int[n];
        if (n == 0) {
            return 0;
        }
        dp[0] = low[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[i] = Math.max(dp[i - 1] + low[i], high[i]);
            } else {
                dp[i] = Math.max(dp[i - 1] + low[i], dp[i - 2] + high[i]);
            }
        }
        return dp[n - 1];
    }

}

