package dp.lintcode.p01_house_robber;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/5 4:19 下午
 */
public class Solution {


    /**
     * https://www.lintcode.com/problem/house-robber/description
     * 约束条件：相邻的数组不能同时相加
     * [5, 2, 1, 3]
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        // long[] dp = new long[A.length];
        // dp[0] = A[0];
        // 前一个最大数
        long t1 = 0;
        // 当前最大数
        long t2 = A[0];
        long temp;
        for (int i = 1; i < A.length; i++) {
            temp = t2;
            t2 = Math.max(t2, A[i]+t1);
            t1 = temp;
        }
        // return dp[A.length-1];
        return t2;
        // write your code here
    }

    public long houseRobber_A1(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        long[][] dp = new long[n][2];
        dp[0][0] = 0;
        dp[0][1] = A[0];
        for (int i = 1; i < n; i++) {
            // 如果不抢第i个，直接取前i-1个位置dp较大值
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            // 如果抢第i个,从i-2个位置dp的值转移，
            // 此处dp[i-1][0] = Math.max(dp[i-2][0], dp[i-2][1]);
            dp[i][1] = A[i] + dp[i-1][0];
        }
        long result = Math.max(dp[n-1][0], dp[n-1][1]);
        return result;
    }



    public static void main(String[] args) {
        int[] A = {5, 2, 1, 3,1,4};
        //
        Solution solution = new Solution();
        solution.houseRobber_A1(A);
    }
}
