package problems_by_year.year_2020.month_05.problems_0518.Sort_Characters_By_Frequency;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.frequencySort_A1("tree");

    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer cnt = map.getOrDefault(c, 0);
            map.put(c, cnt+1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> {
            char[] chars = new char[x.getValue()];
            Arrays.fill(chars, x.getKey());
            stringBuilder.append(chars);
        });
        return stringBuilder.toString();
    }

    public String frequencySort_A1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(c);

        return sb.toString();
    }
}
