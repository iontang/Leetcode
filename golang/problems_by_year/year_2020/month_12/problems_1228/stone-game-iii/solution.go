package stone_game_iii

import "math"

// 2020-12-29 21:00:56
// 1406.Stone Game III
// stone-game-iii

//Alice and Bob continue their games with piles of stones. There are several sto
//nes arranged in a row, and each stone has an associated value which is an intege
//r given in the array stoneValue.
//
// Alice and Bob take turns, with Alice starting first. On each player's turn, t
//hat player can take 1, 2 or 3 stones from the first remaining stones in the row.
//
//
// The score of each player is the sum of values of the stones taken. The score
//of each player is 0 initially.
//
// The objective of the game is to end with the highest score, and the winner is
// the player with the highest score and there could be a tie. The game continues
//until all the stones have been taken.
//
// Assume Alice and Bob play optimally.
//
// Return "Alice" if Alice will win, "Bob" if Bob will win or "Tie" if they end
//the game with the same score.
//
//
// Example 1:
//
//
//Input: values = [1,2,3,7]
//Output: "Bob"
//Explanation: Alice will always lose. Her best move will be to take three piles
// and the score become 6. Now the score of Bob is 7 and Bob wins.
//
//
// Example 2:
//
//
//Input: values = [1,2,3,-9]
//Output: "Alice"
//Explanation: Alice must choose all the three piles at the first move to win an
//d leave Bob with negative score.
//If Alice chooses one pile her score will be 1 and the next move Bob's score be
//comes 5. The next move Alice will take the pile with value = -9 and lose.
//If Alice chooses two piles her score will be 3 and the next move Bob's score b
//ecomes 3. The next move Alice will take the pile with value = -9 and also lose.
//Remember that both play optimally so here Alice will choose the scenario that
//makes her win.
//
//
// Example 3:
//
//
//Input: values = [1,2,3,6]
//Output: "Tie"
//Explanation: Alice cannot win this game. She can end the game in a draw if she
// decided to choose all the first three piles, otherwise she will lose.
//
//
// Example 4:
//
//
//Input: values = [1,2,3,-1,-2,-3,7]
//Output: "Alice"
//
//
// Example 5:
//
//
//Input: values = [-1,-2,-3]
//Output: "Tie"
//
//
//
// Constraints:
//
//
// 1 <= values.length <= 50000
// -1000 <= values[i] <= 1000
// Related Topics Dynamic Programming
// 👍 442 👎 5


//leetcode submit region begin(Prohibit modification and deletion)
//{x,x,x,x,x,x}
//{x} {x,x,x,x,x} k=1: sum[1]   - dp[2]
//				  k=2: sum[1:2] - dp[3]
//				  k=3: sum[1:3] - dp[4]
func stoneGameIII(stoneValue []int) string {
	n := len(stoneValue)
	// dp[i]表示已经有i堆石头被拿走的情况下，当前玩家在后续的操作中最多总共能拿到多少分？
	// dp 代表的不是人，而代表的是那个最优策略。
	dp := make([]int, n+1)
	for i := 1; i <= len(stoneValue); i++ {
		dp[i-1] = math.MinInt64
	}
	dp[n] = 0
	sum := 0
	for i := n-1; i >= 0; i-- {
		sum += stoneValue[i]
		for k := i; k < i+3 && k < n; k++ {
			dp[i] = maxInt(dp[i], sum - dp[k+1])
		}
	}
	Alice := dp[0]
	Bob := sum - dp[0]
	if Alice > Bob {
		return "Alice"
	}
	if Alice < Bob {
		return "Bob"
	}
	return "Tie"
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

//class Solution {
//public String stoneGameIII(int[] stoneValue) {
//int n=stoneValue.length;
//int[] dp=new int[n+1];
//
//dp[n]=0;
//int sum=0;
//for(int i=n-1;i>=0;i--){
////由于有负值分数，这里注意一下
//dp[i]=Integer.MIN_VALUE;
//sum+=stoneValue[i];
//for(int j=i;j<i+3 && j<n;j++){
//dp[i]=Math.max(dp[i],sum-dp[j+1]);
//}
//}
//int alice=dp[0];
//int bob=sum-dp[0];
//if(alice==bob) return "Tie";
//if(alice>bob) return "Alice";
//return "Bob";
//}
//}

//leetcode submit region end(Prohibit modification and deletion)

