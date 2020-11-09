package string.FirstUniqueCharacter_in_a_String;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.firstUniqChar("leeto");
        solution.firstUniqChar_A1("leab");
    }

    public int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap();
        for (char i : c) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }


    public int firstUniqChar_A1(String s) {

        char[] chArr = s.toCharArray();
        int[] alp = new int[26];
        for(int i=0; i < chArr.length; i++){
            System.out.println(alp[chArr[i] - 'a']);
            alp[chArr[i] - 'a'] = alp[chArr[i] - 'a'] + 1;
        }
        for(int i=0; i < chArr.length; i++){
            if(alp[chArr[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
