package backpack_iv

/**
 * @param nums: an integer array and all positive numbers, no duplicates
 * @param target: An integer
 * @return: An integer
 */
func backPackIV (nums []int, target int) int {
	arrLen := len(nums)
	dp := make([]int, target + 1)
	for i := 0; i < arrLen; i++ {
		for j := nums[i]; j <= target; j++ {
			if j == nums[i] {
				dp[j] = dp[j] + 1
			} else {
				dp[j] = dp[j] + dp[j-nums[i]]
			}

		}
	}
	return dp[target]
}

func backPackIV_A1 (nums []int, target int) int {
	arrLen := len(nums)
	dp := make([]int, target + 1)
	dp[0] = 1
	for i := 0; i < arrLen; i++ {
		for j := nums[i]; j <= target; j++ {
			dp[j] += dp[j-nums[i]]
		}
	}
	return dp[target]
}

