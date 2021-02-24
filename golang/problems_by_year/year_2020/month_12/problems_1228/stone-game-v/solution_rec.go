package stone_game_v

func stoneGameV_rec(stoneValue []int) int {
	prefixSums := make([]int, len(stoneValue))
	prefixSums[0] = stoneValue[0]
	for i := 1; i < len(stoneValue); i++ {
		prefixSums[i] = prefixSums[i-1] + stoneValue[i]
	}
	memo := make([][]int, len(stoneValue))
	for i := 0; i < len(memo); i++ {
		memo[i] = make([]int, len(stoneValue))
	}
	return getMaxSum(0, len(stoneValue)-1, prefixSums, memo)

}

func getMaxSum(start int, end int, sums []int, memo [][]int) int {
	if start == end {
		return 0
	}
	if memo[start][end] != 0 {
		return memo[start][end]
	}
	maxScore := 0
	for i := start; i < end; i++ {
		leftSum := sums[i]
		if start > 0 {
			leftSum -= sums[start-1]
		}
		rightSum := sums[end] - sums[i]
		if leftSum <= rightSum {
			maxScore = max(maxScore, leftSum+getMaxSum(start, i, sums, memo))
		}
		if rightSum <= leftSum {
			maxScore = max(maxScore, rightSum+getMaxSum(i+1, end, sums, memo))
		}
	}
	memo[start][end] = maxScore
	return maxScore
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
