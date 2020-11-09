package problems_by_year.year_2020.month_09.problems_0921.Longest_Common_Subsequence;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/27 6:18 下午
 */
// 1143:
// Longest Common Subsequence
// longest-common-subsequence

//Given two strings text1 and text2, return the length of their longest common s
//ubsequence.
//
// A subsequence of a string is a new string generated from the original string
//with some characters(can be none) deleted without changing the relative order of
// the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is
// not). A common subsequence of two strings is a subsequence that is common to bo
//th strings.
//
//
//
// If there is no common subsequence, return 0.
//
//
// Example 1:
//
//
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//
//
// Example 2:
//
//
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//
//
// Example 3:
//
//
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
//
//
//
// Constraints:
//
//
// 1 <= text1.length <= 1000
// 1 <= text2.length <= 1000
// The input strings consist of lowercase English characters only.
//
// Related Topics Dynamic Programming
// 👍 1914 👎 25


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     *
     * "afabcde"
     * "aafe"
     * except output: 3
     *
     *
     * Input
     * "oxcpqrsvwf"
     * "shmtulqrypy"
     * Output:   1
     * Expected: 2
     * 解释：遍历text2的时候，代码每次只会从相等的字符后一位索引开始，比如s后面的v开始，输出结果是1，
     *      但是这个样例最长子序列是qr
     */
    public int longestCommonSubsequence_W1(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int max = 0;
        int equalInx = 0;
        for (int i = 0; i < len2; i++) {
            int p2 = i;
            int p1 = equalInx;
            while (p1 < len1) {
                if (text1.charAt(p1) == text2.charAt(p2)) {
                    max++;
                    equalInx = p1+1;
                    break;
                }
                p1++;
            }
        }
        return max;
    }

    /**
     * "ylqpejqbalahwr"
     *        g
     * "yrkzavgdmdgtqpg"
     *        g      pg
     *            g
     * 解释：g和p中间的g会使得text1的p会被过滤掉
     */
    public int longestCommonSubsequence_W2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int max = 0;
        int equalInx = 0;
        int p1 = 0;
        for (int i = 0; i < len2; i++) {
            int cnt = 0;
            equalInx = 0;
            for (int j = i; j < len2; j++) {
                p1 = equalInx;
                while (p1 < len1) {
                    if (text1.charAt(p1) == text2.charAt(j)) {
                        cnt++;
                        equalInx = p1+1;
                        break;
                    }
                    p1++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    /**
     * brute force
     * @return
     *
     * "afabcde"
     * "aafe"
     */
    public int longestCommonSubsequence_A1(String text1, String text2) {
        return count(text1, text2, text1.length()-1, text2.length()-1);
    }
    public int count(String text1, String text2, int len1, int len2) {
        if(len1 < 0 || len2 < 0)
            return 0;
        if(text1.charAt(len1) == text2.charAt(len2))
            return 1 + count(text1.substring(0,len1), text2.substring(0,len2), len1-1, len2-1);
        else
            return Math.max(count(text1.substring(0, len1), text2, len1-1, len2), count(text1, text2.substring(0,len2), len1, len2-1));
    }


    /**
     * dp solution
     * 不通过的样例：
     * "pmjghexybyrgzczy"
     * "hafcdqbgncrcbihkd"
     *
     * @return
     */
    public int longestCommonSubsequence_W3(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len2][len1];
        boolean[] text1Flag = new boolean[len1];
        int max = 0;
        for (int i = 0; i < len2; i++) {
            boolean flag2 = false;
            for (int j = 0; j < len1; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[i-1][j];
                }
                if (j > 0) {
                    left = dp[i][j-1];
                }
                int curr = 0;
                if (text2.charAt(i) == text1.charAt(j) && !text1Flag[j] && !flag2) {
                    curr = 1;
                    text1Flag[j] = true;
                    flag2 = true;
                }
                dp[i][j] = Math.max(up, left) + curr;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // 声明长度为len+1，匹配型动态规划的特点
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {
                // 因为i、j是从1开始的，当前子字符的最后一个字符的时候，需要减1
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

