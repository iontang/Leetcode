package problems_by_year.year_2020.month_07.problems_0727.Word_Break_II;

import java.util.*;

/**
 * ClassName Solution_A1
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/3 10:24 下午
 */
public class Solution_A1 {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList() {{
            addAll(Arrays.asList("apple","pen","applepen","pine","pineapple"));
        }};
        String s = "pineapplepenapple";
        Solution_A1 solution_a1 = new Solution_A1();
        solution_a1.wordBreak(s, wordDict);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> input = new HashSet<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String word : wordDict) {
            input.add(word);
        }
        List<String> result = new ArrayList<String>();
        return wordBreak(s, result, input, map);
    }

    List<String> wordBreak (String word, List<String> result1, Set input, Map<String, List<String>> map){
        List <String> result = new ArrayList<>();
        int len = word.length();
        if (len == 0) {
            return result;
        }
        if(map.containsKey(word)) {
            return map.get(word);
        }
        for (int i=1 ; i<=len ; i ++) {
            String nextWord = word.substring(0,i);
            if (input.contains(nextWord)) {
                String newWord;
                if(i<len) {
                    newWord = word.substring(i, len);
                } else {
                    result.add(nextWord);
                    break;
                }
                List<String> result2 = wordBreak(newWord, result1, input, map);
                for (String temp: result2) {
                    String s =  nextWord + " " + temp;
                    result.add(s);
                }
            }
        }
        map.put(word, result);
        return result;
    }

}
