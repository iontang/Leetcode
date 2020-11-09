package dp.lintcode.p18_longest_palindromic_substring;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/15 9:51 下午
 */
public class Solution {

    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }

        // 按列循环而非按行循环是关键。
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    isPalindrome[i][j] = false;
                } else {
                    if (j - i < 3) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i+1][j-1];
                    }
                }

                if (isPalindrome[i][j] && j-i+1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, maxLen + start);
    }

}
