package dp.lintcode.p17_champagne_tower;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/12 10:55 下午
 */
public class Solution {

    /**
     * @param poured: an integer
     * @param query_row: an integer
     * @param query_glass: an integer
     * @return: return a double
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        int maxRow = 100;
        double[][] dp = new double[maxRow+1][maxRow+1];
        dp[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            // j < 0 & j > i 的情况不可能
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(0, (dp[i-1][j]-1)/2);
                } else if (i == j) {
                    dp[i][j] = Math.max(0, (dp[i-1][j-1]-1)/2);
                } else {
                    dp[i][j] = Math.max(0, (dp[i-1][j]-1)/2) + Math.max(0, (dp[i-1][j-1]-1)/2);
                }
            }
        }
        return Math.min(dp[query_row][query_glass], 1.0);
    }
}
