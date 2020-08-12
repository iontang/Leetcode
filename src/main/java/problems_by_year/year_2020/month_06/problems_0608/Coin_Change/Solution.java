package problems_by_year.year_2020.month_06.Coin_Change;

import java.util.Arrays;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/6/7 11:23 下午
 */
public class Solution {

    public static void main(String[] args) {
//        int[] coins = new int[]{186,419,83,408};
        int[] coins = new int[]{1,2,5};
        Solution solution = new Solution();
        solution.coinChange(coins, 11);
        System.out.println();
    }

    /**
     * 先排序，然后从大到小对amount进行减法，错误！
     * 应该使用回溯法，每一次走不通的时候，重头开始。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_W1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = 0;
        int index = coins.length - 1;
        Arrays.sort(coins);
        while (amount > 0 && index >= 0) {
            if (amount - coins[index] >= 0) {
                amount = amount - coins[index];
                count++;
            } else {
                index--;
            }
        }
        return (count > 0 && amount == 0) ? count : -1;
    }

    /**
     * brute method
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_A1(int[] coins, int amount) {
        return helper(0, coins, amount);
    }

    private int helper(int idxCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount/coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = helper(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                        System.out.println(amount + ",res:" + res + " minCost=" + minCost);

                    }
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int m = 1;m < amount + 1;m++){
            dp[m] = Integer.MAX_VALUE;
        }
        for(int num: coins){
            for(int i = num;i < amount + 1;i++){
                if(dp[i - num] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(1 + dp[i - num], dp[i]);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

}
