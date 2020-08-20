package problems_by_year.year_2020.month_07.problems_0727.Word_Break_II;


import java.util.*;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/30 11:52 下午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = new ArrayList() {{
           addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        }};
        String s = "catsanddog";
//        List<String> wordDict = new ArrayList() {{
//            addAll(Arrays.asList("apple","pen","applepen","pine","pineapple"));
//        }};
//        String s = "pineapplepenapple";
        solution.wordBreak(s, wordDict);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        return null;
    }

    public boolean canBread(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()+1];
        Arrays.fill(dp, Boolean.FALSE);
        dp[0] = Boolean.TRUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                if (dp[i].equals(Boolean.TRUE) && wordDict.contains(s.substring(i, j))) {
                    dp[j] = Boolean.TRUE;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * Time Limit Exceeded
     * 通过动态规划的方法，
     *
     * 解决办法是利用上一提，先判断该输入是否符合条件，
     */
    public List<String> wordBreak_W2(String s, List<String> wordDict) {
        // 没有这段，会Time Limit Exceeded
        if (!canBread(s, wordDict)) {
            return new ArrayList<>();
        }

        Map<Integer, List<String>> map = new HashMap<>();
        Boolean[] dp = new Boolean[s.length()+1];
        Arrays.fill(dp, Boolean.FALSE);
        dp[0] = Boolean.TRUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                if (dp[i].equals(Boolean.TRUE) && wordDict.contains(s.substring(i, j))) {
                    String sub = s.substring(i, j);
                    // 在上一次的基础上追加数据。
                    List<String> curr = map.get(Integer.valueOf(i));
                    if (curr != null) {
                        for (String ss : curr) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(ss).append(" ").append(sub);
                            map.computeIfAbsent(Integer.valueOf(j), k -> new ArrayList<>()).add(sb.toString());
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(sub);
                        map.computeIfAbsent(Integer.valueOf(j), k -> new ArrayList<>()).add(sb.toString());
                    }
                    dp[j] = Boolean.TRUE;
                }
            }
        }
        return map.getOrDefault(Integer.valueOf(s.length()), new ArrayList<>());
    }

    /**
     * dfs
     * 遍历wordDict处理
     */
    public List<String> wordBreak_W1(String s, List<String> wordDict) {
        int sLen = s.length();
        List<String> res = new ArrayList<>();
        StringBuilder sb = null;
        help(0, s, wordDict, sLen, res, sb, "");
        return res;
    }
    private boolean help(int fromInx, String s, List<String> wordDict,
                         int sLen, List<String> res, StringBuilder sb, String lastWord) {
        if (lastWord != "" && fromInx != sLen) {
            sb.append(lastWord).append(" ");
        }
        if (fromInx == sLen) {
            sb.append(lastWord);
            if (!res.contains(sb.toString())) {
                res.add(sb.toString());
            }
            return true;
        }
        for (String word : wordDict) {
            if (fromInx == 0) {
                sb = new StringBuilder();
            }
            // 每次根据word的长度截取s的子串，这个做法是错误的。
            // 比如：pineapplepenapple
            String subWord = s.substring(fromInx, fromInx + word.length());
            if (word.length() <= sLen-fromInx
                    && wordDict.contains(subWord)
                    && help(fromInx + word.length(), s, wordDict, sLen, res, sb, subWord)) {
                if (fromInx != 0) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

}
