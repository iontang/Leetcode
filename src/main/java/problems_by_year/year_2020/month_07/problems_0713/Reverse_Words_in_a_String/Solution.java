package problems_by_year.year_2020.month_07.problems_0713.Reverse_Words_in_a_String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/15 6:58 下午
 */
public class Solution {

    public static void main(String[] args) {
        String s = "  hello  world!  ";
        String[] arr = s.trim().split("\\s+");
        System.out.println();
        ReentrantLock reentrantLock = new ReentrantLock();

    }

    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        List<String> lst = Arrays.asList(arr);
        Collections.reverse(lst);
        return String.join(" ", lst);
    }


    public String reverseWords_A1(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        for (int i=s.length()-1, j; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                // j is pointing to the end char of the current word
                j = i;
                // this returns the white space preceding the current word
                i = s.lastIndexOf(' ', i);
                ans.append(s, i+1, j+1).append(" ");
            }
        }
        return ans.toString().trim();
    }

}
