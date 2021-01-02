package stone_game_ii

import "math"

// 2020-12-29 21:00:48
// 1140.Stone Game II
// stone-game-ii

//Alice and Bob continue their games with piles of stones. There are a number of
// piles arranged in a row, and each pile has a positive integer number of stones
//piles[i]. The objective of the game is to end with the most stones.
//
// Alice and Bob take turns, with Alice starting first. Initially, M = 1.
//
// On each player's turn, that player can take all the stones in the first X rem
//aining piles, where 1 <= X <= 2M. Then, we set M = max(M, X).
//
// The game continues until all the stones have been taken.
//
// Assuming Alice and Bob play optimally, return the maximum number of stones Al
//ice can get.
//
//
// Example 1:
//
//
//Input: piles = [2,7,9,4,4]
//Output: 10
//Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, t
//hen Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If A
//lice takes two piles at the beginning, then Bob can take all three piles left. I
//n this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larg
//er.
//
//
// Example 2:
//
//
//Input: piles = [1,2,3,4,5,100]
// M=1 X=[1,2] X=1 A 1
// M=1 X=[1,2] X=1 B 2
// M=1 X=[1,2] X=1 A 1+3
// M=1 X=[1,2] X=2 B 2+4+5
// M=2 X=[1,4] X=1 A 1+3+100: 每次只能从左到右

//Output: 104
//
//
//
// Constraints:
//
//
// 1 <= piles.length <= 100
// 1 <= piles[i] <= 104
//
// Related Topics Dynamic Programming
// 👍 666 👎 160


//leetcode submit region begin(Prohibit modification and deletion)
func stoneGameII_A1(piles []int) int {
	len, sum := len(piles), 0
	dp := make([][]int, len)
	for i := 0; i < len; i++ {
		dp[i] = make([]int, len+1)
	}
	for i := len-1; i >= 0; i-- {
		sum += piles[i]
		for M := 1; M <= len; M++ {
			if i + 2*M >= len {
				dp[i][M] = sum
			} else { //
				for x := 1; x <= 2*M; x++ {
					dp[i][M] = int(math.Max(float64(dp[i][M]), float64(sum-dp[i+x][int(math.Max(float64(M), float64(x)))])))
				}
			}
		}
	}
	return dp[0][1]
}
//leetcode submit region end(Prohibit modification and deletion)
