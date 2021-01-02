package backpack_v

/**
 * @param nums: an integer array and all positive numbers
 * @param target: An integer
 * @return: An integer
 */
func backPackV (nums []int, target int) int {
	arrLen := len(nums)
	dp := make([]int, target+1)
	dp[0] = 1
	for i := 0; i < arrLen; i++ {
		for j := target; j >=nums[i] ; j-- {
			dp[j] += dp[j-nums[i]]
		}
	}
	return dp[target]
}