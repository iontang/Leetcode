package house_robber

// 2020-10-29 23:04:34
// 198.House Robber
// house-robber

//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into
//on the same night.
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
//
//
// Example 2:
//
//
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
// Related Topics Dynamic Programming
// 👍 5903 👎 172

//leetcode submit region begin(Prohibit modification and deletion)
func rob(nums []int) int {
	sLen := len(nums)
	if sLen == 0 {
		return 0
	}
	dp := make([][]int, sLen+1)
	for i := 0; i <= sLen; i++ {
		dp[i] = make([]int, 2)
	}
	dp[1][0] = 0
	dp[1][1] = nums[0] // rob([]int{1,2,3,1})
	// [2,7,9,3,1]
	for i := 2; i <= sLen; i++ {

	}

	return dp[sLen][1]
}

func rob_a1(nums []int) int {
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

//leetcode submit region end(Prohibit modification and deletion)
