package problems_by_year.year_2020.month_10.problems_1005.Longest_Palindromic_Substring;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/8 12:34 下午
 */
// 5:
// Longest Palindromic Substring
// longest-palindromic-substring

//Given a string s, return the longest palindromic substring in s.
//
//
// Example 1:
//
//
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: s = "cbbd"
//Output: "bb"
//
//
// Example 3:
//
//
//Input: s = "a"
//Output: "a"
//
//
// Example 4:
//
//
//Input: s = "ac"
//Output: "a"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consist of only digits and English letters (lower-case and/or upper-case),
//
//
// Related Topics String Dynamic Programming
// 👍 8194 👎 579


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestPalindrome_A1("ac");
    }

    public String longestPalindrome_W1(String s) {
        int len = s.length();
        char[] oriArr = s.toCharArray();
        char[] reversedArr = new char[len];
        for (int i = 0; i < len; i++) {
            reversedArr[i] = oriArr[len - i - 1];
        }
        StringBuilder sb = new StringBuilder();
        String res = "";
        for (int i = 0; i < len; i++) {
            if (oriArr[i] == reversedArr[i]) {
                sb.append(oriArr[i]);
            } else {
                if (res.length() < sb.toString().length()) {
                    res = sb.toString();
                }
                sb.setLength(0);
            }
        }
        if (res.length() < sb.toString().length()) {
            res = sb.toString();
        }
        return res;
    }

    // Input: s = "babad"
    public String longestPalindrome_A1(String s) {
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
//leetcode submit region end(Prohibit modification and deletion)
