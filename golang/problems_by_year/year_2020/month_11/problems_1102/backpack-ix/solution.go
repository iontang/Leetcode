package backpack_ix

import "math"

/**
 * dp[j] = 1 - (1 - dp[j - a])*(1 - b)
 * @param n: Your money
 * @param prices: Cost of each university application
 * @param probability: Probability of getting the University's offer
 * @return: the  highest probability
 */
func backpackIX (n int, prices []int, probability []float64) float64 {
	arrLen := len(prices)
	dp := make([]float64, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = 1.0
	}
	//dp[0] = 1.0
	for i := 0; i < arrLen; i++ {
		for j := n; j >= prices[i]; j-- {
			dp[j] = math.Min(dp[j], (dp[j - prices[i]])*(1-probability[i]))
		}
	}
	return 1-dp[n]
}
