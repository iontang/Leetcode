package problems_by_year.year_2020.month_05.problems_0511.Single_Element_in_a_Sorted_Array;


public class Solution {

    /**
     * 题目要求 O(logn),
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

    /**
     * 序号 0 1 2 3 4 5 6
     * 数组 X X X X X X X
     * 此时left = 0, right = 6, mid = left + parseInt((right - left) / 2) = 3
     * mid两端都是奇数个值
     * 当nums[mid] == nums[mid+1]时，右侧此时就会剩下偶数个值，因此只出现一次的数字不会出现在右侧
     * 反之，nums[mid] == nums[mid-1]时，左侧就会剩下偶数个值，因此只出现一次的数字不会出现在左侧
     *
     * 序号 0 1 2 3 4
     * 数组 X X X X X
     * 此时left = 0, right = 4, mid = left + parseInt((right - left) / 2) = 2
     * mid两端都是偶数个值
     * 当nums[mid] == nums[mid+1]时，右侧此时剩下奇数个值，因此只出现一次的数一定会在右侧
     * 反之，nums[mid] == nums[mid-1]时，左侧剩下奇数个值，因此只出现一次的数一定会在左侧
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate_R1(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if ( (mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid -1])) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    /**
     * https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/100759/Java-Binary-Search-O(log(n))-Shorter-Than-Others
     * @param nums
     * @return
     */
    public int singleNonDuplicate_A1(int[] nums) {
        // binary search
        int n=nums.length;
        int lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m] != nums[2*m+1]) {
                hi = m;
            }
            else {
                lo = m+1;
            }
        }
        return nums[2*lo];
    }


}
