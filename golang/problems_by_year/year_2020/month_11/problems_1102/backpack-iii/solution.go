package backpack_iii

import "math"

/**
 * 完全背包问题，物品可重复使用：
 * @param m: An integer m denotes the size of a backpack
 * @param A: Given n items with size A[i]
 * @param V: Given n items with value V[i]
 * @return: The maximum value
 */
func backPackIII (m int, A []int, V []int) int {
	arrLen := len(A)
	dp := make([][]int, arrLen+1)
	for i := 0; i <= arrLen; i++ {
		dp[i] = make([]int, m+1)
	}
	for i := 1; i <= arrLen; i++ {
		for j := 1; j <= m; j++ {
			// 不取
			dp[i][j] = dp[i-1][j]
			// 取
			// 取该物品，但是是在考虑过或者取过该物品的基础之上(dp[i][...])取
			// 0-1背包则是在还没有考虑过该物品的基础之上(dp[i - 1][...])取
			if A[i-1] <= j {
				// 和0-1背包不同的地方：
				// dp[i-1][j - A[i-1]] + V[i-1]) vs dp[i][j - A[i-1]] + V[i-1])
				dp[i][j] = int(math.Max(float64(dp[i][j]), float64(dp[i][j - A[i-1]] + V[i-1])))
			}
		}
	}
	return 0
}