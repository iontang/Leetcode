package dp.lintcode.p24_dyeing_problem;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/27 7:43 上午
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 2, 3:
     * total = 2
     * 面值： [1,2,3]
     * 求方案数：
     * 限定条件：相邻位置不能放置相同方案
     * @param n: the number of sectors
     * @param m: the number of colors
     * @return: The total number of plans.
     */
    private static long MOD = 1000000007;
    public int getCount(int n, int m) {
        long[] dp = new long[n+3];

        dp[1] = m % MOD;
        dp[2] = (long) m * (m-1) % MOD;
        dp[3] = (long) m * (m-1) * (m-2) % MOD;
        for (int i = 0; i <= n; i++) {
            dp[i] += dp[i-1] * (m-2);
            dp[i] += dp[i-2] * (m-1);
            dp[i] %= MOD;
        }
        return (int) dp[n];
    }

}
