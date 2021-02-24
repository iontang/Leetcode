package problems_by_year.year_2021.month_01.problems_0124.Contains_Duplicate_III;

import java.util.*;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/1/27 5:29 下午
 */
// 220:
// Contains Duplicate III
// contains-duplicate-iii

//Given an array of integers, find out whether there are two distinct indices i
//and j in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k.
//
//
// Example 1:
    // 1-1 <= t = 0     |nums[j]-nums[i]|
    // 3-0 <= k = 0     |j-i|
// Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true
// Example 2:
    // 1-0 <= t = 1
    // 4-2 <= k = 2
// Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
// Example 3:
// Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false
//
//
// Constraints:
//
//
// 0 <= nums.length <= 2 * 104
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 104
// 0 <= t <= 231 - 1
//
// Related Topics Sort Ordered Map
// 👍 1474 👎 1566


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * Time Limit Exceeded
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate_W1(int[] nums, int k, int t) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (j-i <= k && Math.abs((long)nums[i]-(long)nums[j]) <= t) {
                    return true;
                }
             }
        }
        return false;
    }

    /**
     * TLE should use binary sort.
     *  (j-i <= k && Math.abs((long)nums[i]-(long)nums[j]) <= t)
     *  {1,1,5,5,9,9}
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate_W2(int[] nums, int k, int t) {
        int len = nums.length;
        Map<Integer, List<Integer>> numsMap = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            numsMap.computeIfAbsent(nums[i], kk -> new ArrayList<>()).add(i);
        }
        Arrays.sort(nums);

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (t - nums[mid]> 0 ) {

            }
        }
        return false;
    }


    // nums[j]-t <= num[i] <= nums[j]+t
    //
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < len; i++) {
            Long ceiling = set.ceiling((long)nums[i]-t);
            if (ceiling != null && ceiling <= (long)nums[i]+(long)t ) {
                return true;
            }
            set.add((long)nums[i]);
            if (set.size() == k+1) {
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3);
//        solution.containsNearbyAlmostDuplicate(new int[]{2147483640,2147483641}, 1, 100);
//        solution.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0);
        solution.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

