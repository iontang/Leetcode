package problems_by_year.year_2020.month_04.problems_20200427.Counting_Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them seperately.
 *
 * Example 1:
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Example 2:
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 *
 * Example 3:
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 *
 * Example 4:
 * Input: arr = [1,1,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 */

public class Solution {

    public static void main(String[] args) {

    }


    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j]+1)) {
                cnt += 1;
            }
        }
        return cnt;
    }

}


