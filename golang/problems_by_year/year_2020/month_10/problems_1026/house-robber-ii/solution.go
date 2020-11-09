package house_robber_ii

import "math"

// 2020-10-30 07:59:01
// 213.House Robber II
// house-robber-ii

//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have a security system connected, and it will automatically c
//ontact the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers nums representing the amount of money o
//f each house, return the maximum amount of money you can rob tonight without ale
//rting the police.
//
//
// Example 1:
//
//
//Input: nums = [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
//2), because they are adjacent houses.
//
//
// Example 2:
//
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//
//
// Example 3:
//
//
//Input: nums = [0]
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000
//
// Related Topics Dynamic Programming
// 👍 2323 👎 57

//leetcode submit region begin(Prohibit modification and deletion)
func rob(nums []int) int {
	max1 := helper(nums[1:])
	max2 := helper(nums[:len(nums)-1])
	return int(math.Max(float64(max1), float64(max2)))
}

func helper(nums []int) int {
	prevMax := 0
	currMax := 0

	for i := 0; i < len(nums); i++ {
		temp := currMax
		if prevMax+nums[i] > currMax {
			currMax = prevMax + nums[i]
		}
		prevMax = temp
	}
	return currMax
}

func rob_w3(nums []int) int {
	arrLen := len(nums)
	prevMax := 0
	currMax := 0

	oddTotal := 0
	var temp int
	for i := 0; i < arrLen-1; i++ {
		if i%2 == 1 {
			oddTotal += nums[i]
		}
		temp = currMax
		if prevMax+nums[i] > currMax {
			currMax = prevMax + nums[i]
		}
		prevMax = temp
	}

	if arrLen%2 == 0 {
		return int(math.Max(float64(currMax), float64(nums[arrLen-1]+oddTotal)))
	} else {
		return int(math.Max(float64(currMax), float64(nums[arrLen-1]+oddTotal-nums[arrLen-2])))
	}
}

func rob_w2(nums []int) int {
	sLen := len(nums)

	dp := make([][]int, sLen)
	for i := 0; i < sLen; i++ {
		dp[i] = make([]int, 2)
	}

	dp[0][0] = 0
	dp[0][1] = nums[0] // {2,1,1,2}
	for i := 1; i < sLen; i++ {
		dp[i][0] = int(math.Max(float64(dp[i-1][0]), float64(dp[i-1][1])))
		dp[i][1] = nums[i] + dp[i-1][0]
		if i == sLen-1 && i%2 == 0 {
			dp[i][1] -= nums[i-1]
		}
	}
	return int(math.Max(float64(dp[sLen-1][0]), float64(dp[sLen-1][1])))
}

func rob_w1(nums []int) int {
	sLen := len(nums)
	if sLen == 0 {
		return 0
	} else if sLen < 4 {
		max := nums[0]
		for _, v := range nums {
			if v > max {
				max = v
			}
		}
		return max
	}

	dp := make([][]int, sLen+1)
	for i := 0; i <= sLen; i++ {
		dp[i] = make([]int, 2)
	}

	dp[1][0] = 0
	dp[1][1] = nums[0]
	for i := 2; i <= sLen; i++ {
		if i == sLen && i%2 == 1 {
			dp[i][0] = dp[i-1][1]
			dp[i][1] = int(math.Max(float64(dp[i-3][1]+nums[i-1]), float64(dp[i][0])))
		} else {
			dp[i][0] = dp[i-1][1]
			dp[i][1] = int(math.Max(float64(dp[i-2][1]+nums[i-1]), float64(dp[i][0])))
		}
	}
	return dp[sLen][1]
}

//leetcode submit region end(Prohibit modification and deletion)
