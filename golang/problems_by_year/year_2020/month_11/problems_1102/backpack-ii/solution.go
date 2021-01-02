package backpack_ii

import "math"

/**
 * Use two two-dimensional arrays
 * @param m: An integer m denotes the size of a backpack
 * @param A: Given n items with size A[i]
 * @param V: Given n items with value V[i]
 * @return: The maximum value
 */
func backPackII (m int, A []int, V []int) int {
	arrLen := len(A)
	states := make([][]bool, arrLen)
	dp := make([][]int, arrLen)
	for i := 0; i < arrLen; i++ {
		states[i] = make([]bool, m+1)
		dp[i] = make([]int, m+1)
	}

	states[0][0] = true
	if A[0] <= m {
		states[0][A[0]] = true
		dp[0][A[0]] = V[0]
	}

	for i := 1; i < arrLen; i++ {
		for j := 0; j <= m; j++ {
			if states[i-1][j] {
				states[i][j] = states[i-1][j]
				dp[i][j] = dp[i-1][j]
			}
		}
		for j := 0; j <= m-A[i]; j++ {
			if states[i-1][j] {
				states[i][j+A[i]] = true
				//dp[i][j+A[i]] = int(math.Max(float64(dp[i-1][j]), float64([])))
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