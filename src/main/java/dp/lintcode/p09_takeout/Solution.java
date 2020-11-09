package dp.lintcode.p09_takeout;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/14 10:56 上午
 */
public class Solution {

    public static void main(String[] args) {
        int kinds = 5, amount = 20;
        // 最少需要几种，才能符合满减。
        int[] prices = {18,19,17,6,7};
        int[] dp = new int[kinds];
        int minimalFoods = Integer.MAX_VALUE;

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b2 | b1);

        Solution solution = new Solution();
        int res = solution.minimumPrice_A2(kinds, amount, prices);
        System.out.println(res);
        // dp[i] = Math.max
    }

    public int minimumPrice_A2(int n, int X, int[] price) {
        int totalPrice = 0;
        for (int i = 0; i < n; i++) {
            totalPrice += price[i];
        }
        // 转化为容量是totalPrice的01背包
        // dp[i]为True表示可以选择总价恰好为i的物品；
        boolean[] dp = new boolean[totalPrice+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = totalPrice; j >= price[i]; j--) {
                dp[j] |= dp[j - price[i]];
            }
        }
        // 找到 >=X 的最小价格
        for (int i = X; i <= totalPrice; i++) {
            if (dp[i]) {
                return i;
            }
        }
        return -1;
    }

    public int minimumPrice(int n, int X, int[] price) {
        //设置变量记录总和
        int nums=0;
        //将数组中的元素进行加和判断满足条件吗
        for(int num : price){
            nums += num;
        }
        //判断如果总和达不到要求
        if(nums<X){
            return -1;
        }
        //背包容量
        int v = nums - X;
        int[][] dp = new int[n + 1][v+1];
        int res = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= v; j++){
                if(j >= price[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j - price[i-1]] + price[i-1],
                            dp[i-1][j]);
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return v - dp[n][v] + X;
    }

    /**
     * 把它理解为“反向的”01背包问题，即：
     * 若所有菜品总价为T，优惠券为满X减?元，则可以转化为容量为T-X的01背包问题，本题的特殊之处在于每一件物品的体积等于其价值也就是每样菜品的价格，
     * 也就是说，在超过X元的情况下选择价格总和最低的菜品等价于，在不超过T-X的情况下尽可能选择价值总和最高的物品
     * 找到>=X的最小价格 等价于 找到<T-X的最大价格
     * 下面算法便是求：
     * 超过X元的情况下选择价格总和最低的菜品
     * @param n
     * @param X
     * @param price
     * @return
     */
    public int minimumPrice_A1(int n, int X, int[] price) {
        int totalPrice = 0;
        for (int i = 0; i < n; i++) {
            totalPrice += price[i];
        }
        int v = totalPrice - X;
        int[] dp = new int[v+1];
        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= price[i-1]; j--) {
                int pre = dp[j-price[i-1]] + price[i-1];
                dp[j] = Math.max(pre, dp[j]);
            }
        }
        // 超过优惠券价格的最低消费。
        return totalPrice-dp[v];
    }

}
