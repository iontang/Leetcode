package year.year_2020.month_03.problems_20200302.Summary_Ranges;

import java.util.LinkedList;
import java.util.List;
public class Solution {

    // [-2147483648,-2147483647,2147483647]
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE - Integer.MIN_VALUE );
    }
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new LinkedList<>();
        List<String> result = new LinkedList<>();
        int start = nums[0];
        int i = 1;
        int cnt = 1;
        while (i < nums.length) {
            if (Math.abs(nums[i] - nums[i-1]) > 1) { // 不加绝对值，[-2147483648,-2147483647,2147483647] 出错
                if (cnt == 1) {
                    result.add(String.valueOf(start));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(start);
                    sb.append("->");
                    sb.append(nums[i-1]);
                    result.add(new String(sb));
                }
                cnt = 1;
                start = nums[i++];
            } else {
                ++cnt;
                ++i;
            }
        }
        if (start == nums[nums.length-1]) {
            result.add(String.valueOf(start));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            sb.append("->");
            sb.append(nums[nums.length-1]);
            result.add(new String(sb));
        }
        return result;
    }

    public List<String> summaryRanges_W1(int[] nums) {
        if (nums.length == 0) return new LinkedList<>();
        List<String> result = new LinkedList<>();
        int start = nums[0];
        int i = 1;
        int cnt = 1;
        while (i < nums.length) {
            if (nums[i] - nums[i-1] > 1) { // 不加绝对值，[-2147483648,-2147483647,2147483647] 出错
                if (cnt == 1) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + nums[i-1]);
                }
                cnt = 1;
                start = nums[i++];

            } else {
                ++cnt;
                ++i;
            }
        }
        if (start == nums[nums.length-1]) {
            result.add(start+"");
        } else {
            result.add(start + "->" + nums[nums.length-1]);
        }
        return result;
    }


}
