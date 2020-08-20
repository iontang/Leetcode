package problems_by_year.year_2020.month_07.problems_0713.Reverse_Bits;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/13 11:17 下午
 */
public class Solution {

    public static void main(String[] args) {
        int i = 15;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        i = i>>1;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        System.out.println(i %2);
        System.out.println(i & 1);
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        return 0;
    }
}
