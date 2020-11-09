package dp.lintcode.p22_minimum_window_subsequence;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/21 9:11 下午
 */
public class Solution {

    /**
     * brute force:
     *
     * @param S: a string
     * @param T: a string
     * @return: the minimum substring of S
     */
    public String minWindow(String S, String T) {
        int n = S.length();
        int m = T.length();
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) != T.charAt(0)) {
                continue;
            }
            int p1 = 0;
            int p2 = 0;
            while (p1 < m && p2 < n - i) {
                if (T.charAt(p1) == S.charAt(p2+i)) {
                    p1++;
                }
                p2++;
            }
            if (p1 == m) {
                if (min > p2) {
                    start  = i;
                    min = p2;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return S.substring(start, start+ min);
    }

    /**
     * 令dp[i][j]表示成功匹配 T串的前j个字符 为 S中前i个字符 的子序列时的匹配起点
     * 动态规划的转移方程(Function)
     * S[i]==T[j] && j == 1: dp[i][j] = i
     * S[i]==T[j] && j != 1: dp[i][j] = dp[i - 1][j - 1]
     * S[i] != T[j]:         dp[i][j] = dp[i - 1][j]
     * @param S
     * @param T
     * @return
     */
    public String minWindow_A1(String S, String T) {
        int n = S.length();
        int m = T.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    if (j == 1) {
                        dp[i][j] = i;
                    } else {
                        dp[i][j] = dp[i-1][j-1];
                    }
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int start = 0, len = n + 1;
        for (int i = 1; i <= n; i++) {
            if (dp[i][m] != 0) {
                if (i - dp[i][m] + 1 < len) {
                    start = dp[i][m] - 1;
                    len = i - dp[i][m] + 1;
                }
            }
        }
        if (len == n + 1) {
            return "";
        }
        return S.substring(start, start+len);
    }

    /**
     * 动态数组的方法：
     * 如何改成
     * @param S
     * @param T
     * @return
     */
    public String minWindow_A2(String S, String T) {
        int n = S.length();
        int m = T.length();
        int[] dp = new int[n+1];

        int start = 0;
        int len = n + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    if (j == 1) {
                        dp[i] = i;
                    } else {
                        dp[i] = dp[i-1];
                    }
                } else {
//                    dp[i] = dp[i-1][j];
                }
            }
//            if (dp[i][m] != 0) {
//                if (i - dp[i][m] + 1 < len) {
//                    start = dp[i][m] - 1;
//                    len = i - dp[i][m] + 1;
//                }
//            }
        }
        if (len == n + 1) {
            return "";
        }
        return S.substring(start, start+len);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.minWindow("abcdebdde", "bde");
//        solution.minWindow("cnhczmccqouqadqtmjjzl", "mm");
        solution.minWindow_A1("abcdebdde", "bde");
    }

}
