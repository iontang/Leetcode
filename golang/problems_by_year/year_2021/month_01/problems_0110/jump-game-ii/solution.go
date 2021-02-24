package jump_game_ii

import "math"

// 2021-01-16 17:13:55
// 45.Jump Game II
// jump-game-ii

//Given an array of non-negative integers nums, you are initially positioned at
//the first index of the array.
//
// Each element in the array represents your maximum jump length at that positio
//n.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// You can assume that you can always reach the last index.
//
//
// Example 1:
//
//
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
//step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
//Input: nums = [2,3,0,1,4]
//Output: 2
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics Array Greedy
// 👍 3515 👎 163
// [1,1,1,1]
//  0 1 2 3 // min step
//  1 2 3 4 // curMax

//  1 2 3 4 // reachMax
//  0 1 2 3 // index

// [2,1,1,1]
//  0 1 1 2 // min step
//  2 2 2 3 // curMax

//  1 2 3 4 // reachMax
//  0 1 2 3 // index

//leetcode submit region begin(Prohibit modification and deletion)
// [2,3,1,1,4]
//  0 1 1 2 2 // min step
//  2 4 4 4 8 // curMax

//  2 2 2 4 4 // reachMax
//  0 1 2 3 4 // index

// j: [0,2]
//

// [2,2,1,1,4]
//  0 1 1 2 3
func jump_W1(nums []int) int {
	n := len(nums)
	if n == 1 {
		return 0
	}
	// dp[i]表示到达i时使用的最小步数
	dp := make([]int, n)
	dp[0] = 0
	curMax := nums[0]
	reachMax := 0
	for i := 1; i < n; i++ {
		if curMax < nums[i] + i  {
			curMax = nums[i] + i
		}

		if reachMax >= i {
			dp[i] = dp[i-1]
		} else {
			reachMax = curMax
			dp[i] = dp[i-1] + 1
		}
	}
	return dp[n-1]
}

// 时间复杂度：O(n^2) 能用动态规划算法的都可以用贪心算法：
func jump(nums []int) int {
	n := len(nums)
	dp := make([]int, n)
	for i := 1; i < n; i++ {
		dp[i] = math.MaxInt32
	}
	for i := 1; i < n; i++ {
		for j := 0; j < i; j++ {
			if j+nums[j] >= i {
				dp[i] = minInt(dp[i], dp[j] + 1)
			}
		}
	}
	return dp[n-1]
}

func minInt(a, b int) int {
	if a > b {
		return b
	}
	return a
}

// 时间复杂度：O(n)
func jump_A1(nums []int) int {
	n := len(nums)
	step := 0
	end := 0
	curMax := 0
	for i := 0; i < n-1; i++ {
		if curMax < nums[i] + i  {
			curMax = nums[i] + i
		}
		if i == end {
			end = curMax
			step++
		}
	}
	return step
}


//leetcode submit region end(Prohibit modification and deletion)
