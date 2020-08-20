package problems_by_year.year_2020.month_07.problems_0727.Word_Break_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName Solution_A2
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/3 10:27 下午
 */
public class Solution_A2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        int max = 0;
        Set<String> dict = new HashSet<>();
        for (String w : wordDict) {
            dict.add(w);
            max = Math.max(max, w.length());
        }
        List<String> res = new ArrayList<>();
        dfs(s, res, new StringBuilder(), 0, max, dict, new boolean[s.length()+1]);
        return res;
    }

    void dfs(String s, List<String> res, StringBuilder sb, int index, int max, Set<String> dict, boolean[] notvalid) {
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = index + 1; i <= index + max && i <= s.length(); i++) {
            if (!notvalid[i]) {
                if (dict.contains(s.substring(index, i))) {
                    int oldLength = sb.length();
                    int oldSize = res.size();
                    if (oldLength != 0) {
                        sb.append(" ");
                    }
                    sb.append(s.substring(index, i));
                    dfs(s, res, sb, i, max, dict, notvalid);
                    if (oldSize == res.size()) {
                        notvalid[i] = true;
                    }
                    sb.delete(oldLength, sb.length());
                }
            }
        }
    }

}
