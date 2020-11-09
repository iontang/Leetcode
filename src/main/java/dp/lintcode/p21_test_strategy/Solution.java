package dp.lintcode.p21_test_strategy;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/20 9:27 下午
 */
public class Solution {

    public static void main(String[] args) {
    }

    /**
     * 你有三种不同的策略可以选择：
     * <p>
     * 直接跳过这道题目，不花费时间，本题得 0 分。
     * 只做这道题目一部分，花费 p[i] 分钟的时间，本题可以得到 part[i] 分。
     * 做完整道题目，花费 f[i] 分钟的时间，本题可以得到 full[i] 分。
     * 依次给定 4 个数组：p，part，f，full，请你计算出你最多能得到多少分。
     * <p>
     * 样例
     * 样例1：
     * 输入样例：p=[20,50,100,5], part=[20,30,60,3], f=[100,80,110,10], full=[60,55,88,6]
     * 输出样例：94
     * 样例解释：在所有做题选择中，选择完成整道第 3 题和整道第 4 题的得分最高。整道第 3 题耗时 110 分钟得到 88 分，整道第 4 题耗时 10 分钟得到 6 分，总共耗时 120 分钟得到 94 分。
     * <p>
     * 样例2：
     * 输入样例：p=[60,60], part=[30,30], f=[100,120], full=[40,60]
     * 输出样例：60
     * 样例解释：2 道题目都做一部分和做完整道第 2 题，都能在耗时 120 分钟下得到最高的 60 分。
     *
     * @param p:    The time you choose to do part of the problem.
     * @param part: The points you choose to do part of the problem.
     * @param f:    The time you choose to do the whole problem.
     * @param full: The points you choose to do the whole problem.
     * @return: Return the maximum number of points you can get.
     * <p>
     * 输入
     * 查看差别
     * [47,54,106,68,9,30,94,42,104,48]
     * [88,25,99,73,27,68,87,54,71,82]
     * [97,60,113,74,43,72,94,106,114,100]
     * [94,54,99,81,65,94,96,84,93,86]
     * 输出
     * 99
     * 期望答案
     * 221
     */
    public int exam_A1(int[] p, int[] part, int[] f, int[] full) {
        int len = p.length;
        int[] dp = new int[len];
        int minute = f[0];
        dp[0] = full[0];
        for (int i = 1; i < len; i++) {
            if (minute + f[i] <= 120) {
                dp[i] = dp[i - 1] + full[i];
                minute += f[i];
            } else if (minute + p[i] <= 120) {
                dp[i] = dp[i - 1] + part[i];
                minute += p[i];
            } else {
                if (dp[i - 1] < full[i]) {
                    dp[i] = full[i];
                    minute = f[i];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len - 1];
    }

    private static int MAX_TIME = 120;
    public int exam(int[] p, int[] part, int[] f, int[] full) {
        int n = p.length;
        // 做前i道题，在考试j分钟得到的分数
        int[][] dp = new int[n + 1][MAX_TIME + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= MAX_TIME; j++) {
                dp[i][j] = dp[i - 1][j];
                // 第i题只做一部分
                if (j < p[i - 1]) {
                    continue;
                }
                // j-p[i-1]的结果永远在0～120之间
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - p[i - 1]] + part[i - 1]);
                // 考虑将第i题全做完
                if (j < f[i]) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - f[i - 1]] + full[i - 1]);
            }
        }
        return dp[n][MAX_TIME];
    }

}