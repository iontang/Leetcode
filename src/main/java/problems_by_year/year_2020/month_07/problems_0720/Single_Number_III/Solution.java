package problems_by_year.year_2020.month_07.problems_0720.Single_Number_III;

import java.util.Arrays;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/23 11:36 下午
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(6));
        System.out.println(3^5);
        // 1，1，2，3，5，5
        int[] nums = new int[]{1,2,1,3,2,5};
        Solution solution = new Solution();
//        solution.singleNumber(nums);
        solution.singleNumber_A1(nums);
    }

    /**
     * 如何进行异或之后对最终结果进行反向还原
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int secIdx = 1;
        int first = nums[0];
        int resIdx = 0;
        while (secIdx < nums.length && resIdx < 2) {
            if (first != nums[secIdx]) {
                res[resIdx] = first;
                resIdx++;
                first = nums[secIdx];
            } else {
                if (secIdx + 1 < nums.length) {
                    first = nums[++secIdx];
                }
            }
            secIdx++;

        }
        if (resIdx == 1) {
            res[resIdx] = nums[nums.length-1];
        }
        return res;
    }

    public int[] singleNumber_A1(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        System.out.println("bitmask:" + bitmask + ", bit:"+Integer.toBinaryString(bitmask));
        System.out.println("-bitmask:" + (-bitmask) + ", bit:" + Integer.toBinaryString(-bitmask));
        // rightmost 1-bit diff between x and y
        // -bitmask 等价于 (~bitmask + 1)，即：取反再加上1。
        // 如果bitmask是                           00000000000000000000000000000110
        // 那么(~bitmask+1)是                      11111111111111111111111111111010
        // bitmask & (-bitmask): 与操作得到结果是    00000000000000000000000000000010
        int diff = bitmask & (-bitmask);
        System.out.println("diff:" + diff + ", bit:"+Integer.toBinaryString(diff));

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) {
            // 10 & 11
            // 010 & 101
            if ((num & diff) != 0) {
                x ^= num;
            }
        }
        return new int[]{x, bitmask^x};

    }
}
