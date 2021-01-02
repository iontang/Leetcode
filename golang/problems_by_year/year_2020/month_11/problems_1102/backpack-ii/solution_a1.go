package backpack_ii

import "math"

// Use only one two-dimensional array
func backPackII_A1 (m int, A []int, V []int) int {
	arrLen := len(A)
	dp := make([][]int, arrLen)
	for i := 0; i < arrLen; i++ {
		dp[i] = make([]int, m+1)
	}

	if A[0] <= m {
		dp[0][A[0]] = V[0]
	}

	for i := 1; i < arrLen; i++ {
		// 不放
		for j := 0; j <= m; j++ {
			if dp[i-1][j] >= 0 {
				dp[i][j] = dp[i-1][j]
			}
		}
		// 放
		for j := 0; j <= m-A[i]; j++ {
			if dp[i-1][j] >= 0 {
				// It will be overwrite at the same position, so must compare dp[i][j+A[i]] & dp[i-1][j] + V[i]
				//dp[i][j+A[i]] = dp[i-1][j] + V[i]
				dp[i][j+A[i]] = int(math.Max(float64(dp[i][j+A[i]]), float64(dp[i-1][j] + V[i])))
			}
		}
	}
	maxValue := 0
	for i := 0; i <= m; i++ {
		if dp[arrLen-1][i] > maxValue {
			maxValue = dp[arrLen-1][i]
		}
	}
	return maxValue
}

// 另一种代码实现方式：
func backPackII_A1V1 (m int, A []int, V []int) int {
	arrLen := len(A)
	dp := make([][]int, arrLen+1)
	for i := 0; i <= arrLen; i++ {
		dp[i] = make([]int, m+1)
	}
	for i := 1; i <= arrLen; i++ {
		for j := 1; j <= m; j++ {
			// 不放
			dp[i][j] = dp[i-1][j]
			// 放
			if A[i-1] <= j {
				// It will be overwrite at the same position, so must compare dp[i][j+A[i]] & dp[i-1][j] + V[i]
				//dp[i][j+A[i]] = dp[i-1][j] + V[i]
				dp[i][j] = int(math.Max(float64(dp[i][j]), float64(dp[i-1][j - A[i-1]] + V[i-1])))
			}
		}
	}
	return dp[arrLen][m]
}
