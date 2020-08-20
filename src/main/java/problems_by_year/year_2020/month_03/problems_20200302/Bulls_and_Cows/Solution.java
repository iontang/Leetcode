package problems_by_year.year_2020.month_03.problems_20200302.Bulls_and_Cows;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

    }

    /**
     * Runtime: 13 ms, faster than 15.13% of Java online submissions for Bulls and Cows.
     * Memory Usage: 41.8 MB, less than 5.26% of Java online submissions for Bulls and Cows.
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, LinkedList> map = new HashMap<>();

        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();

        for (int i = 0; i < secretArr.length; i++) {
            if (secretArr[i] == guessArr[i]) {
                ++bulls;
            } else {
                LinkedList<Integer> value = map.getOrDefault(secretArr[i], new LinkedList());
                value.add(i);
                map.put(secretArr[i], value);
            }
        }
        for (int i = 0; i < guessArr.length; i++) {
            if (secretArr[i] != guessArr[i] && map.containsKey(guessArr[i])) {
                LinkedList<Integer> value = map.get(guessArr[i]);
                if (value.size() > 0 && !value.contains(i)) {
                    ++cows;
                    value.poll();
                }
            }
        }
        return  new StringBuffer().append(bulls).append('A').append(cows).append('B').toString();
    }

    /**
     * "1122"
     * "1222" wrong
     * @param secret
     * @param guess
     * @return
     */
    public String getHint_W1(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, LinkedList> map = new HashMap<>();

        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();

        for (int i = 0; i < secretArr.length; i++) {
            LinkedList<Integer> value = map.getOrDefault(secretArr[i], new LinkedList());
            value.add(i);
            map.put(secretArr[i], value);
        }

        for (int i = 0; i < guessArr.length; i++) {
            if (secretArr[i] == guessArr[i]) {
                ++bulls;
                LinkedList<Integer> value = map.get(guessArr[i]);
                value.poll();
            } else if (map.containsKey(guessArr[i])) {
                LinkedList<Integer> value = map.get(guessArr[i]);
                if (value.size() > 0 && !value.contains(i)) {
                    ++cows;
                    value.poll();
                }
            }
        }
        return new StringBuffer().append(bulls).append('A').append(cows).append('B').toString();
    }



    public String getHint_A1(String secret, String guess) {
        int[] secretCharMap = new int[10], guessCharMap = new int[10];
        int bulls = 0, cows = 0;
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else{
                secretCharMap[secret.charAt(i) - '0']++;
                guessCharMap[guess.charAt(i) - '0']++;
            }
        }

        for(int i=0;i<=9;i++){
            cows += Math.min(secretCharMap[i], guessCharMap[i]);
        }

        return new StringBuffer().append(bulls).append('A').append(cows).append('B').toString();
    }

}