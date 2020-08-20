package problems_by_year.year_2020.month_04.problems_20200406.Group_Anagrams;


import java.util.*;


public class Solution {

    public static void main(String[] args) {
        char[] ss = "ate".toCharArray();
        Arrays.sort(ss);
        System.out.println(String.valueOf(ss));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            List<String> lst = map.getOrDefault(key, new ArrayList<>());
            lst.add(s);
            map.put(key, lst);
        }
        return new ArrayList<>(map.values());
    }
}
