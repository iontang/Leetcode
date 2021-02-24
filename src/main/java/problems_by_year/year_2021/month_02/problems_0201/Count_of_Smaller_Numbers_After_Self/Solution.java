package problems_by_year.year_2021.month_02.problems_0201.Count_of_Smaller_Numbers_After_Self;

import java.util.*;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/2/1 3:17 下午
 */
// 315:
// Count of Smaller Numbers After Self
// count-of-smaller-numbers-after-self

//You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elem
//ents to the right of nums[i].
//
//
// Example 1:
//
// i < j && nums[i] > nums[j]: cnt++
//
//Input: nums = [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
//
// Example 2:
//
//Input: nums = [-1]
//Output: [0]
//
// Example 3:
//
//Input: nums = [-1,-1]
//Output: [0,0]
//
// Constraints:
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        Solution solution = new Solution();
//        solution.countSmaller(nums);
    }

    // [5,2,6,1]
    /**
     * 测试用例:[2,0,1]
     * 测试结果:[1,0,0]
     * 期望结果:[2,0,0]
     * @param nums
     * @return
     */
    public List<Integer> countSmaller_W1(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length-1; i >= 0; i--) {
            Integer floor = set.floor(nums[i]-1);
            if (floor != null) {
                map.putIfAbsent(nums[i], map.getOrDefault(floor, 0)+1);
            } else {
                map.putIfAbsent(nums[i], map.getOrDefault(floor, 0));
            }
            set.add(nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(map.get(num));
        }
        return res;
    }

}

//leetcode submit region end(Prohibit modification and deletion)

