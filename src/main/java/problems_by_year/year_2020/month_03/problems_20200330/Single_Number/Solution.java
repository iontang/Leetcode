package year.year_2020.month_03.problems_20200330.Single_Number;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public int singleNumber_R1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int total = 0;
        for (int i : nums) {
            total += i;
            set.add(i);
        }

        Iterator<Integer> i = set.iterator();
        int more = 0;
        while (i.hasNext()) {
            more += i.next();
        }
        return (more*2 - total);
    }


    /**
     * 位运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int result = nums[0];
        for (int i=0; i<len; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
