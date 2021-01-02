package target_sum

// 2020-11-30 23:02:09
// 494.Target Sum
// target-sum

//You are given a list of non-negative integers, a1, a2, ..., an, and a target,
//S. Now you have 2 symbols + and -. For each integer, you should choose one from
//+ and - as its new symbol.
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
//get S.
//
// Example 1:
//
//
//Input: nums is [1, 1, 1, 1, 1], S is 3.
//Output: 5
//Explanation:
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.
// -5 ~ 5
//
//
// Constraints:
//
//
// The length of the given array is positive and will not exceed 20.
// The sum of elements in the given array will not exceed 1000.
// Your output answer is guaranteed to be fitted in a 32-bit integer.
//
// Related Topics Dynamic Programming Depth-first Search
// 👍 3324 👎 137


//leetcode submit region begin(Prohibit modification and deletion)
// coin-change2
func findTargetSumWays_W1(nums []int, S int) int {
	arrLen := len(nums)
	dp := make([]int, S+1)
	dp[0] = 1
	for i := 0; i < arrLen; i++ {
		for j := S; j >= nums[i]; j-- {
			dp[j] = dp[j] + dp[j-nums[i]]
		}
	}
	return dp[S]
}

// 和coin-change2不同的是，这里不是选或者不选，而是加（选）或者减（）
// x - y = S
// x + y = sum(nums)
// x = (S + sum(nums)) / 2
func findTargetSumWays(nums []int, S int) int {
	arrLen := len(nums)
	arrSum := 0
	for i := 0; i < arrLen; i++ {
		arrSum += nums[i]
	}
	m := (S + arrSum) / 2
	if m % 2 != 0 {
		return 0
	}
	dp := make([]int, m+1)
	dp[0] = 1
	for i := 0; i < arrLen; i++ {
		for j := m; j >= nums[i]; j-- {
			dp[j] = dp[j] + dp[j-nums[i]]
		}
	}
	return dp[m]
}
//leetcode submit region end(Prohibit modification and deletion)

