package dp.Best_Time_to_Buy_and_Sell_Stock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int maxProfit = prices[1] - prices[0];
        for (int i = 2;i<prices.length;i++) {
            min = Integer.min(prices[i-1], min);
            maxProfit = Integer.max(maxProfit, prices[i]-min);
        }
        if (maxProfit < 0) return 0;
        return maxProfit;
    }

    public void changeValue(Integer i) {
        i = 2;
    }

    public static void main(String[] args) {
        Integer i = new Integer(1);
        Solution solution = new Solution();
        solution.changeValue(i);
        System.out.println(i);
    }





}
