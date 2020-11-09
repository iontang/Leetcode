package problems_by_year.year_2020.month_10.problems_1005.Longest_Palindromic_Subsequence;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/10 9:55 上午
 */
// 516:
// Longest Palindromic Subsequence
// longest-palindromic-subsequence

//Given a string s, find the longest palindromic subsequence's length in s. You
//may assume that the maximum length of s is 1000.
//
// Example 1:
//Input:
//
//
//"bbbab"
//
//Output:
//
//
//4
//
//One possible longest palindromic subsequence is "bbbb".
//
//
//
// Example 2:
//Input:
//
//
//"cbbd"
//
//Output:
//
//
//2
//
//One possible longest palindromic subsequence is "bb".
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consists only of lowercase English letters.
//
// Related Topics Dynamic Programming
// 👍 2386 👎 197


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * "bbbabbba"
     * Output Expected: 7
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
