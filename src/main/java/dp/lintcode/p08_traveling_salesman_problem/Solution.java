package dp.lintcode.p08_traveling_salesman_problem;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/14 9:59 上午
 */
public class Solution {

    /**
     * @param n: an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
    public int minCost(int n, int[][] roads) {
        int stateSize = 1 << n;
        int[][] f = new int[stateSize][n+1];
        for (int i = 0; i < stateSize; i++) {
            for (int j = 0; j < n+1; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        f[1][1] = 0;
        for (int state = 0; state < stateSize; state++) {
            for (int i = 2; i < n+1; i++) {
                if ((state & (1 << (i-1))) == 0) {
                    continue;
                }
                int prevState = state ^ (1 << (i-1));
                for (int j = 1; j < n+1; j++) {
                    f[state][i] = Math.min(f[state][i], f[prevState][j] + roads[j][i]);
                }
            }
        }
        int minimalCost = Integer.MAX_VALUE;
        for (int i = 0; i < n+1; i++) {
            minimalCost = Math.min(minimalCost, f[stateSize-1][i]);
        }
        return minimalCost;
    }

}
