package problems_by_year.year_2020.month_11.problems_1102.Maximum_Profit_in_Job_Scheduling;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/11/3 10:56 下午
 */
// 1235:
// Maximum Profit in Job Scheduling
// maximum-profit-in-job-scheduling

//We have n jobs, where every job is scheduled to be done from startTime[i] to e
//ndTime[i], obtaining a profit of profit[i].
//
// You're given the startTime , endTime and profit arrays, you need to output th
//e maximum profit you can take such that there are no 2 jobs in the subset with o
//verlapping time range.
//
// If you choose a job that ends at time X you will be able to start another job
// that starts at time X.
//
//
// Example 1:
//
//
//
//
//Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//Output: 120
//Explanation: The subset chosen is the first and fourth job.
//Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
//
//
// Example 2:
//
//
//
//
//
//Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
//Output: 150
//Explanation: The subset chosen is the first, fourth and fifth job.
//Profit obtained 150 = 20 + 70 + 60.
//
//
// Example 3:
//
//
//
//
//Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//Output: 6
//
//
//
// Constraints:
//
//
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
// 1 <= startTime[i] < endTime[i] <= 10^9
// 1 <= profit[i] <= 10^4
//
// Related Topics Binary Search Dynamic Programming Sort
// 👍 741 👎 10

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60});
    }

    // Time O(NlogN) for sorting
    // Time O(NlogN) for binary search for each job
    // Space O(N)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        // 根据endTime排序
        Arrays.sort(jobs, (a, b)->a[1] - b[1]);
        // TreeMap是有序Map
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            // floorEntry是获取 <=job[0]的最大值，时间复杂度是：O(NlogN)
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
