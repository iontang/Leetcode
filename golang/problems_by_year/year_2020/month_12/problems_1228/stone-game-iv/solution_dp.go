package stone_game_iv

// dp[n] -> dp[n-1] -> dp[n-4] ...
func winnerSquareGame_dp(n int) bool {
	// 表示先手在面对 ii 颗石子时是否处于必胜态（会赢得比赛）
	dp := make([]bool, n+1)
	// 没有石子的时候，alice失败
	dp[0] = false
	for i := 1; i <= n; i++ {
		for j := 1; j*j <= i; j++ {
			// 后手是false，说明先手会赢
			if !dp[i - j*j] {
				dp[i] = true
				break
			}
		}
	}
	return dp[n]
}
