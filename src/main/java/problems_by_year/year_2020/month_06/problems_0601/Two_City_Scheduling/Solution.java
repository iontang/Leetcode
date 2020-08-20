package problems_by_year.year_2020.month_06.problems_0601.Two_City_Scheduling;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/6/3 11:34 下午
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] costs = new int[][]{{10,20}, {30, 40}, {400, 50}, {50, 200}};

//        int[][] costs = new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        int[][] costs = new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}};
        Solution solution = new Solution();
        solution.twoCitySchedCost(costs);
    }

    /**
     * [[10,20],
     *  [30,40],
     *  [400,50],
     *  [50,200]]
     *  10+30+ 50+200
     *  10+ 40+50 +50
     *  如上：单单选择A城市最小，最终是无法得到最小得。即局部小小不能保证全局最小。
     *  思路：
     *  数组按照差值进行排序，然后再按照差值从大到小进行选择。
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (Math.abs(b[0]-b[1]) - Math.abs(a[0]-a[1]) ));
        int aCount = costs.length / 2;
        int bCount = costs.length / 2;
        int row = 0;
        int minValue = 0;
        while (aCount > 0 || bCount > 0) {
            int[] cost = costs[row];
            if ((cost[0] > cost[1] && bCount >0) || aCount == 0) {
                minValue += cost[1];
                bCount--;
            } else {
                minValue += cost[0];
                aCount--;
            }
            row++;
        }
        return minValue;
    }

}
