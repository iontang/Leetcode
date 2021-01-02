package burst_balloons

import "math"

// 2020-12-11 22:07:07
// 312.Burst Balloons
// burst-balloons

//Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
// on it represented by array nums. You are asked to burst all the balloons. If th
//e you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Her
//e left and right are adjacent indices of i. After the burst, the left and right
//then becomes adjacent.
//
// Find the maximum coins you can collect by bursting the balloons wisely.
//
// Note:
//
//
// You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can n
//ot burst them.
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//
//
// Example:
//
//
//Input: [3,1,5,8]
//Output: 167
//Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// Related Topics Divide and Conquer Dynamic Programming
// 👍 2945 👎 77


//leetcode submit region begin(Prohibit modification and deletion)
func maxCoins_A1(nums []int) int {
	arrLen := len(nums)
	tempNums := make([]int, arrLen+2)
	tempNums[0],tempNums[arrLen+1] = 1,1
	for i := 0; i < arrLen; i++ {
		tempNums[i+1] = nums[i]
	}
	arrLen += 2
	dp := make([][]int, arrLen)
	for i := 0; i < arrLen; i++ {
		dp[i] = make([]int, arrLen)
	}
	//for i := 0; i < arrLen-1; i++ {
	//	dp[i][i+1] = 0
	//}
	for len := 3; len <= arrLen ; len++ {
		for i := 0; i <= arrLen-len; i++ {
			j := i + len - 1
			//dp[i][j] = math.MinInt8
			for k := i+1; k < j; k++ {
				dp[i][j] = int(math.Max(float64(dp[i][j]), float64(dp[i][k]+dp[k][j]+tempNums[i]*tempNums[k]*tempNums[j])))
			}
		}
	}
	return dp[0][arrLen-1]
}

func maxCoins_A2(nums []int) int {
	arrLen := len(nums)
	tempNums := make([]int, arrLen+2)
	tempNums[0],tempNums[arrLen+1] = 1,1
	for i := 0; i < arrLen; i++ {
		tempNums[i+1] = nums[i]
	}
	arrLen = len(tempNums)
	dp := make([][]int, arrLen)
	for i := 0; i < arrLen; i++ {
		dp[i] = make([]int, arrLen)
	}
	for len := 2; len < arrLen ; len++ { // 步长：
		for i := 0; i < arrLen-len; i++ {
			j := i + len
			for k := i+1; k < j; k++ {
				dp[i][j] = int(math.Max(float64(dp[i][j]), float64(dp[i][k]+dp[k][j]+tempNums[i]*tempNums[k]*tempNums[j])))
			}
		}
	}
	return dp[0][arrLen-1]
}
//leetcode submit region end(Prohibit modification and deletion)

