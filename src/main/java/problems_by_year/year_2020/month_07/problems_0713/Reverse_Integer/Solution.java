package problems_by_year.year_2020.month_07.problems_0713.Reverse_Integer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.Vector;

/**
 * ClassName Solutio
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/14 11:05 下午
 */
public class Solution {

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(Integer.MAX_VALUE);
        Solution solution = new Solution();
        System.out.println(solution.reverse(x));
    }

    /**
     * Example 1:
     * Input: 123
     * Output: 321
     *
     * Example 2:
     * Input: -123
     * Output: -321
     *
     * Example 3:
     * Input: 120
     * Output: 21
     * @param x
     * @return
     */
    public int reverse(int x) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (Math.abs(x) > 0) {
            int mod = x % 10;
            x /= 10;
            stack.push(mod);
        }
        int pow = 0;
        long res = 0;
        while (!stack.isEmpty()) {
            res += (stack.pop() * Math.pow(10, pow));
            pow++;
            if (res > Integer.MAX_VALUE) {
                return 0;
            } else if (res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) res;
    }

    public int reverse_A1(int x) {
        int res = 0;
        while(x != 0){
            int temp = res;
            res = res * 10 + x % 10;
            x = x / 10;
            if(temp!=res/10){ return 0;}
        }
        return res;
    }


}
