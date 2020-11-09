package problems_by_year.year_2020.month_09.problems_0907.Maximal_Rectangle;

/**
 * ClassName Solution_A1
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/9 1:51 下午
 */
public class Solution_A1 {

    public static void main(String[] args) {
        Solution_A1 s = new Solution_A1();
        s.maximalRectangle(null);
    }

    /**
     * [
     *   [1, 1, 0, 0, 1],
     *   [0, 1, 0, 0, 1],
     *   [0, 0, 1, 1, 1],
     *   [0, 0, 1, 1, 1],
     *   [0, 0, 0, 0, 1]
     * ]
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //保存以当前数字结尾的连续 1 的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        //遍历每一行
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //更新 width
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                //向上扩展行
                for (int up_row = row; up_row >= 0; up_row--) {
                    int height = row - up_row + 1;
                    //找最小的数作为矩阵的宽：比较的值是上一列width
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    //更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }

}
