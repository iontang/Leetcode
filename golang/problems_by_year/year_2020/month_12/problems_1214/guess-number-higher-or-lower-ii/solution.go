package guess_number_higher_or_lower_ii

import "math"

// 2020-12-14 22:54:13
// 375.Guess Number Higher or Lower II
// guess-number-higher-or-lower-ii

//We are playing the Guessing Game. The game will work as follows:
//
//
// I pick a number between 1 and n.
// You guess a number.
// If you guess the right number, you win the game.
// If you guess the wrong number, then I will tell you whether the number I pick
//ed is higher or lower, and you will continue guessing.
// Every time you guess a wrong number x, you will pay x dollars. If you run out
// of money, you lose the game.
//
//
// Given a particular n, return the minimum amount of money you need to guarante
//e a win regardless of what number I pick.
//
//
// Example 1:
//
//
//Input: n = 10
//Output: 16
//Explanation: The winning strategy is as follows:
//- The range is [1,10]. Guess 7.
//    - If this is my number, your total is $0. Otherwise, you pay $7.
//    - If my number is higher, the range is [8,10]. Guess 9.
//        - If this is my number, your total is $7. Otherwise, you pay $9.
//        - If my number is higher, it must be 10. Guess 10. Your total is $7 +
//$9 = $16.
//        - If my number is lower, it must be 8. Guess 8. Your total is $7 + $9
//= $16.
//    - If my number is lower, the range is [1,6]. Guess 3.
//        - If this is my number, your total is $7. Otherwise, you pay $3.
//        - If my number is higher, the range is [4,6]. Guess 5.
//            - If this is my number, your total is $7 + $3 = $10. Otherwise, yo
//u pay $5.
//            - If my number is higher, it must be 6. Guess 6. Your total is $7
//+ $3 + $5 = $15.
//            - If my number is lower, it must be 4. Guess 4. Your total is $7 +
// $3 + $5 = $15.
//        - If my number is lower, the range is [1,2]. Guess 1.
//            - If this is my number, your total is $7 + $3 = $10. Otherwise, yo
//u pay $1.
//            - If my number is higher, it must be 2. Guess 2. Your total is $7
//+ $3 + $1 = $11.
//The worst case in all these scenarios is that you pay $16. Hence, you only nee
//d $16 to guarantee a win.
//
//
// Example 2:
//
//
//Input: n = 1
//Output: 0
//Explanation: There is only one possible number, so you can guess 1 and not hav
//e to pay anything.
//
//
// Example 3:
//
//
//Input: n = 2
//Output: 1
//Explanation: There are two possible numbers, 1 and 2.
//- Guess 1.
//    - If this is my number, your total is $0. Otherwise, you pay $1.
//    - If my number is higher, it must be 2. Guess 2. Your total is $1.
//The worst case is that you pay $1.
//
//
//
// Constraints:
//
//
// 1 <= n <= 200
//
// Related Topics Dynamic Programming Minimax
// 👍 931 👎 1426


//leetcode submit region begin(Prohibit modification and deletion)
func getMoneyAmount_A1(n int) int {
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, n+1)
	}

	for len := 2; len <= n; len++ {
		for start := 1; start <= n-len+1; start++ {
			j := start + len - 1
			minRes := math.MaxInt64
			for k := start; k < j; k++ {
				res := k + int(math.Max(float64(dp[start][k-1]), float64(dp[k+1][j])))
				minRes = int(math.Min(float64(res), float64(minRes)))
			}
			dp[start][j] = minRes
		}
	}
	return dp[1][n]
}
//leetcode submit region end(Prohibit modification and deletion)

