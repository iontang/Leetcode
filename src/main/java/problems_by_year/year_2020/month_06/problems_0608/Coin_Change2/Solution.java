package problems_by_year.year_2020.month_06.problems_0608.Coin_Change2;

import java.util.Arrays;

// 518:
// Coin Change 2
// coin-change-2

//You are given coins of different denominations and a total amount of money. Wr
//ite a function to compute the number of combinations that make up that amount. Y
//ou may assume that you have infinite number of each kind of coin.
//
//
//
//
//
//
// Example 1:
//
//
//Input: amount = 5, coins = [1, 2, 5]
//Output: 4
//Explanation: there are four ways to make up the amount:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
//
//
// Example 2:
//
//
//Input: amount = 3, coins = [2]
//Output: 0
//Explanation: the amount of 3 cannot be made up just with coins of 2.
//
//
// Example 3:
//
//
//Input: amount = 10, coins = [10]
//Output: 1
//
//
//
//
// Note:
//
// You can assume that
//
//
// 0 <= amount <= 5000
// 1 <= coin <= 5000
// the number of coins is less than 500
// the answer is guaranteed to fit into signed 32-bit integer
//
// 👍 2421 👎 69

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
        solution.change(8, new int[]{2,3,8});
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
