package stone_game

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
	return false
}

func stoneGame(piles []int) bool {
	len := len(piles)
	// 当 i<j 时，当前玩家可以选择取走 piles[i] 或 piles[j]，
	// 然后轮到另一个玩家在剩下的石子堆中取走石子。在两种方案中，
	// 当前玩家会选择最优的方案，使得自己的石子数量最大化。
	// 因此可以得到如下状态转移方程： dp[i][j] = maxInt(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1])
	dp := make([][]int, len)
	for i := 0; i < len; i++ {
		dp[i] = make([]int, len)
		dp[i][i] = piles[i]
	}
	// [5,3,4,5]: 4-2+1=3; 0+2-1=1
	for l := 2; l <= len; l++ {
		for i := 0; i < len-l+1; i++ {
			j := i + l -1
			dp[i][j] = maxInt(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1])
		}
	}
	return dp[0][len-1] > 0
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
//leetcode submit region end(Prohibit modification and deletion)

