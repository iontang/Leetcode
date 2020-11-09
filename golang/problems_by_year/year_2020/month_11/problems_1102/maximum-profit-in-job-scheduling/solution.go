package maximum_profit_in_job_scheduling

// 2020-11-02 21:54:57
// 1235.Maximum Profit in Job Scheduling
// maximum-profit-in-job-scheduling

//We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
//
//You're given the startTime , endTime and profit arrays, you need to output the
//maximum profit you can take such that there are no 2 jobs in the subset with overlapping time range.
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
// [1-3] + [3-10]
// [1-3] + [4-6] + [6-9]: 20+70+60
//Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
//Output: 150
//Explanation: The subset chosen is the first, fourth and fifth job.
//Profit obtained 150 = 20 + 70 + 60.
// [1,2,3,4,6]
// [3,5,10,6,9]
// [20,20,100,70,60]
// 思考：
// 二分查找遍历到当前值的时候，要找到比当前start_time小的最大值再加上profit[i]，并和dp[i-1]比较
//
// Example 3:
//
//
//
//
//Input: startTime = [1,1,1], endTime = [2,3,4], profit =
// 					 [2,3,4]
// 					 [5,6,4]
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
// 👍 737 👎 10

//leetcode submit region begin(Prohibit modification and deletion)
// Profit obtained 150 = 20 + 70 + 60.
// [1,2,3,4,6]
// [3,5,10,6,9]
// [20,20,100,70,60]
// 思考：
// 二分查找遍历到当前值的时候，要找到比当前start_time小的最大值再加上profit[i]，并和dp[i-1]比较
func jobScheduling(startTime []int, endTime []int, profit []int) int {
	n := len(startTime)
	dp := make([]int, n)
	dp = append(dp, 0)
	for i := 0; i < n; i++ {
		println(dp[0])
	}
	return 0
}

//leetcode submit region end(Prohibit modification and deletion)
