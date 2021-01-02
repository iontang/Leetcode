package backpack_ii

import "math"

func backPackII_A2_W1 (m int, A []int, V []int) int {
	arrLen := len(A)
	dp := make([]int, m+1)
	// Initialize instead of the variable i to loop from 0
	if A[0] <= m {
		dp[A[0]] = V[0]
	}
	for i := 1; i < arrLen; i++ {
		// A[i] -> m：顺序遍历
		for j := A[i]; j <= m; j++ {
			dp[j] = int(math.Max(float64(dp[j]), float64(dp[j-A[i]] + V[i])))
		}
	}
	return dp[m]
}

func backPackII_A2 (m int, A []int, V []int) int {
	arrLen := len(A)
	// All initial values of dp array are 0.
	dp := make([]int, m+1)
	for i := 0; i < arrLen; i++ {
		// m -> A[i]：逆序遍历
		for j := m; j >= A[i]; j-- {
			dp[j] = int(math.Max(float64(dp[j]), float64(dp[j-A[i]] + V[i])))
		}
	}
	return dp[m]
}