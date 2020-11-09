package problems_by_year.year_2020.month_10.problems_1005.Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/5 2:28 下午
 */
// 300:
// Longest Increasing Subsequence
// longest-increasing-subsequence

//Given an unsorted array of integers, find the length of longest increasing sub
//sequence.
//
// Example:
//
//
//Input: [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
//length is 4.
//
// Note:
//
//
// There may be more than one LIS combination, it is only necessary for you to r
//eturn the length.
// Your algorithm should run in O(n2) complexity.
//
//
// Follow up: Could you improve it to O(n log n) time complexity?
// Related Topics Binary Search Dynamic Programming
// 👍 5538 👎 124


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLIS_W1(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    public int lengthOfLIS_W1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] > nums[i]) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public int lengthOfLIS_W2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i];
            }
        }
        return dp[n - 1];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) {
            int maxDp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxDp = Math.max(maxDp, dp[j]);
                }
            }
            dp[i] = maxDp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 两个二分搜索的答案：
     * @param nums
     * @return
     */
    public int lengthOfLIS_A1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int lengthOfLIS_A2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        List<Integer> list = new ArrayList();
        for(int i=0; i<nums.length; i++){
            if(list.isEmpty() || nums[i] > list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int low = 0;
                int high = list.size()-1;
                while(low < high){
                    int mid = low + (high-low)/2;
                    if(nums[i] > list.get(mid)){
                        low = mid+1;
                    }else{
                        high=mid;
                    }
                }
                list.set(high,nums[i]);
            }
        }
        return list.size();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

