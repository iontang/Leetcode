package dp.lintcode.p16_minimum_adjustment_cost;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/19 10:50 下午
 */
public class Solution {

    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        int len = A.size();
        int[][] dp = new int[len][101];

        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i == 0) {
                    dp[0][j] = Math.abs(j - A.get(0));
                    continue;
                }

                int left = Math.max(1, j-target);
                int right = Math.min(100, j+target);
                for (int k = left; k <= right; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(j - A.get(i)));
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            minCost = Math.min(minCost, dp[len-1][i]);
        }
        return minCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> lst = new ArrayList<Integer>() {{
            add(3);
            add(5);
            add(4);
            add(7);
        }};
        solution.MinAdjustmentCost(lst, 2);
    }

}
