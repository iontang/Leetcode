package problems_by_year.year_2020.month_07.problems_0727.Word_Break;


import java.util.*;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/31 5:13 上午
 */
public class Solution {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList() {{
            addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        }};
        Solution solution = new Solution();
        solution.wordBreak_A2("catsanddog", wordDict);
    }

    /**
     * dp
     */
    public boolean wordBreak(String s, List<String> wordDict) {
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
     * bfs
     * this is method that I first time want to realize.
     * TLE
     * 解决TLE的方法，添加一个访问过的visit
     */
    public boolean wordBreak_A2(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList() {{add(0);}};
        Map<Integer, Boolean> visited = new HashMap<>();
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            if (index == s.length()) {
                return true;
            }
            // 记录已经处理过的相同位置的记录
            if (visited.getOrDefault(index, Boolean.FALSE)) {
                continue;
            }
            visited.put(index, Boolean.TRUE);
            for (int end = index; end < s.length(); end++) {
                if (wordDict.contains(s.substring(index, end+1))) {
                    queue.add(end+1);
                }
            }
        }
        return false;
    }

    /**
     * dfs
     * 遍历wordDict处理
     */
    public boolean wordBreak_A1(String s, List<String> wordDict) {
        return help(0, s, wordDict);
    }
    /** store the calculated result by map. */
    private Map<Integer, Boolean> memory = new HashMap<>();
    private boolean help(int fromInx, String s, List<String> wordDict) {
        if (memory.containsKey(Integer.valueOf(fromInx))) {
            return memory.get(Integer.valueOf(fromInx));
        }
        if (fromInx == s.length()) {
            memory.put(Integer.valueOf(fromInx), Boolean.TRUE);
            return true;
        }
        int n = s.length();
        for (String word : wordDict) {
            if (word.length() <= n-fromInx
                    && wordDict.contains(s.substring(fromInx, fromInx + word.length()))
                    && help(fromInx + word.length(), s, wordDict)) {
                memory.put(Integer.valueOf(fromInx), Boolean.TRUE);
                return true;
            }
        }
        memory.put(Integer.valueOf(fromInx), Boolean.FALSE);
        return false;
    }

}
