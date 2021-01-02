package backpack_iii

import "math"

// One-Dimensional Arrays
func backPackIII_A2 (m int, A []int, V []int) int {
	arrLen := len(A)
	// All initial values of dp array are 0.
	dp := make([]int, m+1)
	for i := 0; i < arrLen; i++ {
		// A[i] -> m：顺序遍历
		for j := A[i]; j <= m; j++ {
			dp[j] = int(math.Max(float64(dp[j]), float64(dp[j-A[i]] + V[i])))
		}
	}
	return dp[m]
}
