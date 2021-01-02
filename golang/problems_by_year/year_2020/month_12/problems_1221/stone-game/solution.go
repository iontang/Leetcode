package stone_game

import "math"

// 2020-12-23 23:47:12
// 877.Stone Game
// stone-game

//Alex and Lee play a game with piles of stones. There are an even number of pil
//es arranged in a row, and each pile has a positive integer number of stones pile
//s[i].
//
// The objective of the game is to end with the most stones. The total number of
// stones is odd, so there are no ties.
//
// Alex and Lee take turns, with Alex starting first. Each turn, a player takes
//the entire pile of stones from either the beginning or the end of the row. This
//continues until there are no more piles left, at which point the person with the
// most stones wins.
//
// Assuming Alex and Lee play optimally, return True if and only if Alex wins th
//e game.
//
//
// Example 1:
//
//
//Input: piles = [5,3,4,5]
//Output: true
//Explanation:
//Alex starts first, and can only take the first 5 or the last 5.
//Say he takes the first 5, so that the row becomes [3, 4, 5].
//If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 poin
//ts.
//If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win wit
//h 9 points.
//This demonstrated that taking the first 5 was a winning move for Alex, so we r
//eturn true.
//
//
//
// Constraints:
//
//
// 2 <= piles.length <= 500
// piles.length is even.
// 1 <= piles[i] <= 500
// sum(piles) is odd.
//
// Related Topics Math Dynamic Programming Minimax
// 👍 937 👎 1196


//leetcode submit region begin(Prohibit modification and deletion)
// 通过遍历数组一个个对比的方式是错误的
func stoneGame_W1(piles []int) bool {
	len := len(piles)
	start := 0
	end := len-1
	//total := 0
	//num := 1
	for start < end {
		//if piles[start] >
	}
}

func stoneGame(piles []int) bool {
	len := len(piles)
	dp := make([][]int, len)
	for i := 0; i < len; i++ {
		dp[i] = make([]int, len)
		dp[i][i] = piles[i]
	}
	for l := 2; l <= len; l++ {
		for i := 0; i < len-l+1; i++ {
			j := i + l -1
			dp[i][j] = int(math.Max(float64(piles[i]-dp[i+1][j]), float64(piles[j]-dp[i][j-1])))
		}
	}
	return dp[0][len-1] > 0
}
//leetcode submit region end(Prohibit modification and deletion)

