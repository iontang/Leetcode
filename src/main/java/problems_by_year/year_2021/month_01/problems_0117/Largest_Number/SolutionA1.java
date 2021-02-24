package problems_by_year.year_2021.month_01.problems_0117.Largest_Number;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * ClassName SolutionA1
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/1/20 4:16 下午
 */
public class SolutionA1 {

    public static void main(String[] args) {
        SolutionA1 solutionA1 = new SolutionA1();
        int[] nums = {3,30,34,5,9};
        solutionA1.largestNumber(nums);
    }

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order1.compareTo(order2);
        }
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] asStrs = new String[len];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrs, new LargerNumberComparator());
        if (asStrs[len-1].equals("0")) {
            return "0";
        }
        String result = "";
        for (int i = len-1; i > -1; i--) {
            result += asStrs[i];
        }
        return result;
    }

}
