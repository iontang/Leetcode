package problems_by_year.year_2020.month_06.problems_0608.Coin_Change2;

import java.util.Arrays;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/6/14 12:00 下午
 * https://leetcode.com/problems/coin-change-2/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.change(5, new int[]{1,2,5});
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount+1; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    private int cnt;

    /**
     * 这种递归方法无法去掉重复
     * @param amount
     * @param coins
     * @return
     */
    public int change_W1(int amount, int[] coins) {
        helper(amount, coins);
        return cnt;
    }
    private void helper(int amount, int[] coins) {
        if (amount <= 0) {
            if (amount == 0) {
                cnt++;
            }
            return ;
        }
        for (int i = 0; i < coins.length; i++) {
            int diff = amount - coins[i];
            helper( diff, coins);
        }
    }

}
