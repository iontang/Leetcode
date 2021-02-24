package stone_game_v

// 2020-12-29 21:01:42
// 1563.Stone Game V
// stone-game-v

//There are several stones arranged in a row, and each stone has an associated v
//alue which is an integer given in the array stoneValue.
//
// In each round of the game, Alice divides the row into two non-empty rows (i.e
//. left row and right row), then Bob calculates the value of each row which is th
//e sum of the values of all the stones in this row. Bob throws away the row which
// has the maximum value, and Alice's score increases by the value of the remainin
//g row. If the value of the two rows are equal, Bob lets Alice decide which row w
//ill be thrown away. The next round starts with the remaining row.
//
// The game ends when there is only one stone remaining. Alice's is initially ze
//ro.
//
// Return the maximum score that Alice can obtain.
//
//
// Example 1:
//
//
//Input: stoneValue = [6,2,3,4,5,5]
//Output: 18
//Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5]. Th
//e left row has the value 11 and the right row has value 14. Bob throws away the
//right row and Alice's score is now 11.
//In the second round Alice divides the row to [6], [2,3]. This time Bob throws
//away the left row and Alice's score becomes 16 (11 + 5).
//The last round Alice has only one choice to divide the row which is [2], [3].
//Bob throws away the right row and Alice's score is now 18 (16 + 2). The game end
//s because only one stone is remaining in the row.
//
//
// Example 2:
//
//
//Input: stoneValue = [7,7,7,7,7,7,7]
//Output: 28
//
//
// Example 3:
//
//
//Input: stoneValue = [4]
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= stoneValue.length <= 500
// 1 <= stoneValue[i] <= 10^6
//
// Related Topics Dynamic Programming
// 👍 162 👎 43


//leetcode submit region begin(Prohibit modification and deletion)
// java answer: https://leetcode-cn.com/problems/stone-game-v/solution/chang-gui-de-qu-jian-dpjian-dan-yi-dong-java-by-mr/
func stoneGameV(stoneValue []int) int {
	n := len(stoneValue)
	dp := make([][]int, n+1)
	preSum := make([]int, n+1)
	for i := 1; i <= n; i++ {
		preSum[i] = preSum[i-1] + stoneValue[i-1]
		dp[i] = make([]int, n+1)
	}

	for len := 1; len <= n; len++ {
		// 这里可以写成另外一种表达：
		//for i := 1; i <= n-len+1; i++ {
		for i := 1; i+len-1 <= n; i++ {
			j := i+len-1
			for k := i; k < j; k++ {
				leftSum := preSum[k] - preSum[i-1]
				rightSum := preSum[j] - preSum[k]
				if leftSum > rightSum {
					dp[i][j] = maxInt(dp[i][j], rightSum+dp[k+1][j])
				} else if leftSum < rightSum {
					dp[i][j] = maxInt(dp[i][j], leftSum + dp[i][k])
				} else {
					dp[i][j] = maxInt(dp[i][j], leftSum + maxInt(dp[i][k], dp[k+1][j]))
				}
			}
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

