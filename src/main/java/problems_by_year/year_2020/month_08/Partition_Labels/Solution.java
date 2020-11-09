package problems_by_year.year_2020.month_08.Partition_Labels;

// 763:
// Partition Labels
// partition-labels

//A string S of lowercase English letters is given. We want to partition this st
//ring into as many parts as possible so that each letter appears in at most one p
//art, and return a list of integers representing the size of these parts.
//
//
//
// Example 1:
//
//
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it split
//s S into less parts.
//
//
//
//
// Note:
//
//
// S will have length in range [1, 500].
// S will consist of lowercase English letters ('a' to 'z') only.
//
//
//
// Related Topics Two Pointers Greedy
// 👍 2634 👎 121


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/23 10:21 下午
 */
class Solution {

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        solution.partitionLabels_A1(S);

    }

    /**
     * ababcbacadefegdehijhklij
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        int cnt = 0;
        int start = 0;
        int len = S.length();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (S.substring(start, i).indexOf(c) == -1 &&
                    S.substring(i+1, len).indexOf(c) != -1) {
                // 第一次出现且后面还会出现
                ++cnt;
            } else if (S.substring(start, i).indexOf(c) != -1
                    && S.substring(i+1, len).indexOf(c) == -1) {
                // 前面出现过且最后一次出现
                --cnt;
            }
            if (cnt <= 0) {
                res.add(i+1-start);
                start = i+1;
            }
        }
        return res;
    }


    /**
     * ababcbacadefegdehijhklij
     * @param S
     * @return
     */
    public List<Integer> partitionLabels_A1(String S) {
        List<Integer> res = new ArrayList<>();
        int[] maxInxDict = new int[26];
        char[] cS = S.toCharArray();
        for(int i = 0; i < cS.length;i++){
            // 如果字符相同，下标是最大的值
            maxInxDict[cS[i] - 'a'] = i;
        }
        int partition = 0, last = 0;
        for(int i = 0; i < cS.length; i++){
            // 当前字符的最大下标
            int currLastIdx = maxInxDict[cS[i] - 'a'];
            if (currLastIdx > partition) {
                partition = currLastIdx;
            }
            if(i == partition){
                res.add(partition - last + 1);
                last = i + 1;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
