package stone_game_ii

import "math"

func stoneGameII(piles []int) int {
	if len(piles) == 0 {
		return 0
	}

	memo := make([][]int, len(piles))
	for i := range memo {
		memo[i] = make([]int, len(piles))
	}

	// the sum from piles[i] to the end
	sums := make([]int, len(piles))
	sums[len(piles)-1] = piles[len(piles)-1]
	for i := len(piles)-2; i >= 0; i-- {
		sums[i] = piles[i] + sums[i+1]
	}

	var helper func(i, M int) int
	helper = func(i, M int) int {
		if i > len(piles) - 1 {
			return 0
		}

		if 2*M >= len(piles) - i {
			return sums[i]
		}

		if memo[i][M] != 0 {
			return memo[i][M]
		}

		// the min value next player can get
		min := math.MaxInt64
		for x := 1; x <= 2*M; x++ {
			tmp := helper(i+x, maxInt(x, M))
			if tmp < min {
				min = tmp
			}
		}

		memo[i][M] = sums[i] - min
		return memo[i][M]
	}

	return helper(0, 1)
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}

	return b
}