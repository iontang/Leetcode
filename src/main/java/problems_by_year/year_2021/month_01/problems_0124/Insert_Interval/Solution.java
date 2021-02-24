package problems_by_year.year_2021.month_01.problems_0124.Insert_Interval;

import java.util.Arrays;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/1/25 6:40 下午
 */
// 57:
// Insert Interval
// insert-interval

//Given a set of non-overlapping intervals, insert a new interval into the inter
//vals (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their st
//art times.
//
//
// Example 1:
//
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//
//
// Example 2:
//
//
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//
//
// Example 3:
//
//
//Input: intervals = [], newInterval = [5,7]
//Output: [[5,7]]
//
//
// Example 4:
//
//
//Input: intervals = [[1,5]], newInterval = [2,3]
//Output: [[1,5]]
//
//
// Example 5:
//
//
//Input: intervals = [[1,5]], newInterval = [2,7]
//Output: [[1,7]]
//
//
//
// Constraints:
//
//
// 0 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= intervals[i][0] <= intervals[i][1] <= 105
// intervals is sorted by intervals[i][0] in ascending order.
// newInterval.length == 2
// 0 <= newInterval[0] <= newInterval[1] <= 105
//
// Related Topics Array Sort
// 👍 2522 👎 230


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
    // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] newIntervals = new int[n+1][2];
        System.arraycopy(intervals, 0, newIntervals, 0, n);
        newIntervals[n][0] = newInterval[0];
        newIntervals[n][1] = newInterval[1];
        return merge(newIntervals);
    }

    private int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)