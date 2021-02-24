package problems_by_year.year_2021.month_01.problems_0117.Merge_Intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/1/24 2:42 下午
 */
// 56:
// Merge Intervals
// merge-intervals

//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input.
//
//
// Example 1:
//
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// [[1,7],[2,6],[8,10],[15,18]]
//
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
//
// Constraints:
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics Array Sort
// 👍 6265 👎 356


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        int[][] nums = {{2,3},{4,5},{6,7},{8,9},{1,10}};
//        int[][] nums = {{5,5},{1,3},{3,5},{4,6},{1,1},{3,3},{5,6},{3,3},{2,4},{0,0}};
        // [0,0],[1,2],[5,5],[2,4],[3,3],[5,6],[5,6],[4,6],[0,0],[1,2],[0,2],[4,5]
//        int[][] nums = {{0,0},{1,2},{5,5},{2,4},{3,3},{5,6},{5,6},{4,6},{0,0},{1,2},{0,2},{4,5}};
//        int[][] nums = {{1,1},{2,2},{0,0},{2,3},{1,3},{3,5},{2,3},{3,5}};
//        int[][] nums = {{1,7},{2,4},{3,5},{8,10},{15,18}};
        // int[][] nums{{2,4},{3,5},{1,7},{8,10},{15,18}};
        Solution solution = new Solution();
        solution.merge(nums);
    }

    private class ArrComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            Integer e10 = o1[0];
            Integer e20 = o2[0];
            Integer e11 = o1[1];
            Integer e21 = o2[1];
            // 第一个版本只根据第二列比较了
            if (e11 == e21) {
                return e10.compareTo(e20);
            } else {
                return e11.compareTo(e21);
            }
        }

    }

    /**
     * Summary of problems solving ideas:
     * 1、Sort the two-dimensional arrays by second col if they inequality. Otherwise, compare the first col.
     * 2、
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new ArrComparator());
        int n = intervals.length;
        List<Integer[]> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            // {1,3}, {6,9}: 这种数组输出到结果
            if (intervals[i-1][1] < intervals[i][0]) {
                Integer[] newArr = new Integer[2];
                newArr[0] = intervals[i-1][0];
                newArr[1] = intervals[i-1][1];
                res.add(newArr);
            } else if (intervals[i-1][0] <= intervals[i][0]) {
                // {1,3}, {2,9}: 这种情况会一直更新，直到满足第一种情况
                intervals[i][0] = intervals[i-1][0];
            } else if (intervals[i-1][0] > intervals[i][0]) {
                // 不能简单的清空，比如针对如下的内容：
                // {0,2}, {3,3}, {2,4}
                int resLen = res.size();
                for (int j = resLen-1; j>=0 ; j--) { // 倒序遍历
                    Integer[] cur = res.get(j);
                    if (cur[0] > intervals[i][0]) {
                        res.remove(j);
                    } else if (cur[1] >= intervals[i][0]) {
                        intervals[i][0] = cur[0];
                        res.remove(j);
                    }
                }
            }
        }
        Integer[] newArr = new Integer[2];
        newArr[0] = intervals[n-1][0];
        newArr[1] = intervals[n-1][1];
        res.add(newArr);
        int[][] resArr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArr[i][0] = res.get(i)[0];
            resArr[i][1] = res.get(i)[1];
        }
        return resArr;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

