package stone_game_vi

import "sort"

// 2020-12-29 20:43:02
// 1686.Stone Game VI
// stone-game-vi

//Alice and Bob take turns playing a game, with Alice starting first.
//
// There are n stones in a pile. On each player's turn, they can remove a stone
//from the pile and receive points based on the stone's value. Alice and Bob may v
//alue the stones differently.
//
// You are given two integer arrays of length n, aliceValues and bobValues. Each
// aliceValues[i] and bobValues[i] represents how Alice and Bob, respectively, val
//ue the ith stone.
//
// The winner is the person with the most points after all the stones are chosen
//. If both players have the same amount of points, the game results in a draw. Bo
//th players will play optimally. Both players know the other's values.
//
// Determine the result of the game, and:
//
//
// If Alice wins, return 1.
// If Bob wins, return -1.
// If the game results in a draw, return 0.
//
//
//
// Example 1:
//
//
//Input: aliceValues = [1,3], bobValues = [2,1]
//Output: 1
//Explanation:
//If Alice takes stone 1 (0-indexed) first, Alice will receive 3 points.
//Bob can only choose stone 0, and will only receive 2 points.
//Alice wins.
//
//
// Example 2:
//
//
//Input: aliceValues = [1,2], bobValues = [3,1]
//Output: 0
//Explanation:
//If Alice takes stone 0, and Bob takes stone 1, they will both have 1 point.
//Draw.
//
//
// Example 3:
//
//
//Input: aliceValues = [2,4,3], bobValues = [1,6,7]
//Output: -1
//Explanation:
//Regardless of how Alice plays, Bob will be able to have more points than Alice
//.
//For example, if Alice takes stone 1, Bob can take stone 2, and Alice takes sto
//ne 0, Alice will have 6 points to Bob's 7.
//Bob wins.
//
//
//
// Constraints:
//
//
// n == aliceValues.length == bobValues.length
// 1 <= n <= 105
// 1 <= aliceValues[i], bobValues[i] <= 100
//
// Related Topics Greedy
// 👍 158 👎 10


//leetcode submit region begin(Prohibit modification and deletion)
func stoneGameVI_w1(aliceValues []int, bobValues []int) int {
	n := len(aliceValues)

	sumMap := make(map[int]int)
	for i := 0; i < n; i++ {
		sumMap[aliceValues[i] + bobValues[i]] = i
	}

	var keys []int
	for k := range sumMap {
		keys = append(keys, k)
	}
	sort.Sort(sort.Reverse(sort.IntSlice(keys)))
	aliceSum, bobSum := 0, 0
	for i, key := range keys {
		if i % 2 == 0 {
			aliceSum += aliceValues[sumMap[key]]
		} else {
			bobSum += bobValues[sumMap[key]]
		}
	}

	if aliceSum > bobSum {
		return 1
	} else if aliceSum < bobSum {
		return -1
	} else {
		return 0
	}
}
//leetcode submit region end(Prohibit modification and deletion)

