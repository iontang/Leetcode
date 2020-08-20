package problems_by_year.year_2020.month_05.problems_0511.Valid_Square;

import java.util.Arrays;

/**
 * @author ion
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.validSquare(new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, 0});
    }

    private double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (double)(p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p={p1,p2,p3,p4};
        // 横坐标相等，比较纵坐标
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0])   && dist(p[0],p[3])==dist(p[1],p[2]);
    }

}
