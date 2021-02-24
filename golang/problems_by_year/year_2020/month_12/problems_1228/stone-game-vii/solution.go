package stone_game_vii

// 2020-12-29 20:43:20
// 1690.Stone Game VII
// stone-game-vii

//Alice and Bob take turns playing a game, with Alice starting first.
//
// There are n stones arranged in a row. On each player's turn, they can remove
//either the leftmost stone or the rightmost stone from the row and receive points
// equal to the sum of the remaining stones' values in the row. The winner is the
//one with the higher score when there are no stones left to remove.
//
// Bob found that he will always lose this game (poor Bob, he always loses), so
//he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.
//
// Given an array of integers stones where stones[i] represents the value of the
// ith stone from the left, return the difference in Alice and Bob's score if they
// both play optimally.
//
//
// Example 1:
//
//
//Input: stones = [5,3,1,4,2]
//Output: 6
//Explanation:
//- Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, sto
//nes = [5,3,1,4].
//- Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [
//3,1,4].
//- Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,
//4].
//- Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
//- Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
//The score difference is 18 - 12 = 6.
// 5,3,1,4: 13
// 5,3,1:   5+3+1=9
// 5,3:     13+8
// 5:		9+5
// 21-14 = 7
// Example 2:
//
//
//Input: stones = [7,90,5,1,100,10,10,2]
//Output: 122
//
//
// Constraints:
//
//
// n == stones.length
// 2 <= n <= 1000
// 1 <= stones[i] <= 1000
//
// Related Topics Dynamic Programming
// 👍 146 👎 62


//leetcode submit region begin(Prohibit modification and deletion)
// This problem want to sum the remain elements, and the first problem 'stone game' sum the picked element,
// which is different.
// Alice maximize the diff, and Bob minimize the diff.
func stoneGameVII(stones []int) int {
	// dp[i][j]: the maximum difference in Alice and Bob's score when playing in [i:j]
	n := len(stones)
	dp := make([][]int, n+1)
	preSum := make([]int, n+1)
	for i := 1; i <= n; i++ {
		preSum[i] = preSum[i-1] + stones[i-1]
		dp[i] = make([]int, n+1)
	}

	// 和第一题不同的地方在于前缀和
	for len := 2; len <= n; len++ {
		for i := 1; i+len-1 <= n; i++ {
			j := i+len-1
			dp[i][j] = maxInt(preSum[j] - preSum[i] - dp[i+1][j], preSum[j-1] - preSum[i-1] -dp[i][j-1])
		}
	}
	return dp[1][n]
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
//leetcode submit region end(Prohibit modification and deletion)

