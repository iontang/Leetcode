package dp.lintcode.p04_maximal_rectangle;

/**
 * ClassName Solution_A1_dp
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/9 2:02 下午
 */
public class Solution_A1_dp {

    /**
     * [
     [1, 1, 0, 0, 1],
     [0, 1, 0, 0, 1],
     [0, 0, 1, 1, 1],
     [0, 0, 1, 1, 1],
     [0, 0, 0, 0, 1]
     * ]
     **/
    /**
     * Input:
     * 1 1 1 1 0   1 2 3 4
     * 1 1 1 1 1   2 4 6 8
     * 1 1 1 1 1   3 6 9 12
     * 1 0 0 1 0
     * Output: 4
     * @param matrix
     * @return
     */
    public int maximalRectangle_W1(boolean[][] matrix) {
        // write your code here
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        if (rows == 0 && cols ==0) {
            return 0;
        }
        int[][] area = new int[rows][cols];
        area[0][0] = matrix[0][0] ? 1 : 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean temp = matrix[i][j];
                if (temp) {
                    if (i-1 > 0 && j-1 >0) {
                        if (matrix[i-1][j-1]) {

                        }
                    }
                } else {
                    area[i][j] = 0;
                }
            }
        }
        return 0;
    }

}
