package dp.Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {


    // This answer is greedy algrithm.
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int tmp = prices[1] - prices[0];
        int maxProfit = ( tmp > 0 ? tmp:0 );
        for (int i=2;i<prices.length;i++) {
            minPrice = Integer.min(minPrice, prices[i-1]);
            maxProfit =  Integer.max(maxProfit, maxProfit + (prices[i] - prices[i-1]));
        }
        return maxProfit;

    }

    public int maxProfit_A1(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

}
