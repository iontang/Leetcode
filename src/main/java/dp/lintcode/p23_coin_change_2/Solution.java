package dp.lintcode.p23_coin_change_2;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/25 9:11 下午
 */
public class Solution {

    /**
     * back tracking have to remove the duplicate element:
     *
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
    private int res = 0;
    public int change_W1(int amount, int[] coins) {
        helper(0, amount, coins);
        return res;
    }

    public void helper(int cnt, int amount, int[] coins) {
        if (cnt >= amount) {
            if (cnt == amount) {
                res++;
            }
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            helper(cnt + coins[i], amount, coins);
        }
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.change_W1(8, new int[]{2, 3, 8});
    }

}
