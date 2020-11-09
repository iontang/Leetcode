package problems_by_year.year_2020.month_10.problems_1012.Edit_Distance;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/15 10:20 下午
 */
public class Solution {

    /**
     * sea
     * eat
     * output: 2
     *
     * intention
     * execution
     * output: 5
     *
     * horse
     * ros
     * output: 3
     *
     * ros
     * horse:
     * output:3
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance_W1(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // 声明长度为len+1，匹配型动态规划的特点
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                // 因为i、j是从1开始的，当前子字符的最后一个字符的时候，需要减1
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        if (len1 > len2) {
            return len1 - dp[word1.length()][word2.length()];
        } else {
            int i = 0, j = 0;
            int commonLen = 0;
            while (i < len1 && j < len2) {
                if (word1.charAt(i) == word2.charAt(i)) {
                    commonLen++;
                }
                i++;
                j++;
            }
            return len2 - commonLen;
        }
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        // 第一行
        for (int j = 1; j <= len2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= len1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

}
