package partition_equal_subset_sum

// 2020-11-19 22:19:01
// 0
// partition-equal-subset-sum

//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal.
//
//
// Example 1:
//
//
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
//
// Example 2:
//
//
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
// Related Topics Dynamic Programming
// 👍 3368 👎 77


//leetcode submit region begin(Prohibit modification and deletion)
func canPartition(nums []int) bool {
 	arrLen := len(nums)
 	m := sum(nums)
 	// First rule out the case where the array sum is odd.
	if m % 2 == 1 {
		return false
	}
	dp := make([][]bool, arrLen)
	for i := 0; i < arrLen; i++ {
		dp[i] = make([]bool, m+1)
	}
	dp[0][0] = true
	if nums[0] <= m {
		dp[0][nums[0]] = true
	}
	for i := 1; i < arrLen; i++ {
		for j := 0; j <= m; j++ {
			// 不放
			dp[i][j] = dp[i-1][j]
			// 放
			if nums[i] <= j && dp[i-1][j - nums[i]] {
				dp[i][j] = true
			}
		}
	}
	return dp[arrLen-1][m/2]
}

func sum(array []int) int {
	result := 0
	for _, v := range array {
		result += v
	}
	return result
}
//leetcode submit region end(Prohibit modification and deletion)

