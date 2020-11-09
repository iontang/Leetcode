package dp.lintcode.p20_modern_ludo_i;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/18 11:05 下午
 */
public class Solution {

    /**
     * 输入: length = 15 和 connections = [[2, 8],[6, 9]]
     * output: 3
     *
     * 输入: length = 10 和 connections = [[2, 10]]
     * output: 2
     *
     * @param length: the length of board
     * @param connections: the connections of the positions
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        int[] connected = new int[length+1];
        int[] dp = new int[length+1];
        for (int i = 1; i <= length; i++) {
            connected[i] = i;
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;
        for (int i = 0; i < connections.length; i++) {
            connected[connections[i][0]] = connections[i][1];
        }

        for (int i = 2; i <= length; i++) {
            if (i - 6 < 1) {
                dp[i] = 1;
            } else {
                for (int j = 1; j <= 6; j++) {
                    dp[i] = Math.min(dp[i], dp[i-j] + 1);
                }
            }
            dp[connected[i]] = Math.min(dp[connected[i]], dp[i]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.modernLudo(15, new int[][]{{7,9}, {8,14}});
        System.out.println(res);
    }

}
