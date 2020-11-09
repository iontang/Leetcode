package dp.lintcode.p05_minimum_rest_days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/11 12:01 上午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] companyArr = {1,1,0,0};
        Integer[] gymArr = {0,1,1,0};

        solution.minimumRestDays(Arrays.asList(companyArr), Arrays.asList(gymArr));
    }

    /**
     * [1,1,0,0]
     * [0,1,1,0]
     * [1,3,2,0]
     * [1,2,2,2] or [1,1,1,0]
     * d[i][0]：工作
     * d[i][1]：锻炼
     * d[i][2]：休息
     * https://www.lintcode.com/problem/minimum-rest-days/description
     * @param company: Company business
     * @param gym: Gym business
     * @return: Find the shortest rest day
     */
    public int minimumRestDays(List<Integer> company, List<Integer> gym) {
        int n = company.size();
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
//        令dp[i][j]表示第i天去干某件事情的最小休息天数。
//        工作：dp[i][0] = min(dp[i - 1][1], dp[i - 1][2])
//        锻炼：dp[i][1] = min(dp[i - 1][0], dp[i - 1][2])
//        休息：dp[i][2] = min(dp[i - 1][0], min(dp[i - 1][1], dp[i - 1][2])) + 1
        dp[0][0] = dp[0][1] = 0;
        if (company.get(0) == 0) {
            dp[0][0] = 1;
        }
        if (gym.get(0) == 0) {
            dp[0][1] = 1;
        }
        dp[0][2] = 1;
        //  [1,1,0,0]
        //  [0,1,1,0]
        for (int i = 1; i < n; i++) {
            if (company.get(i) == 1) {
                // 工作
               dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]);
            }
            if (gym.get(i) == 1) {
                // 锻炼
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]);
            }
            dp[i][2] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + 1;
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }

}
