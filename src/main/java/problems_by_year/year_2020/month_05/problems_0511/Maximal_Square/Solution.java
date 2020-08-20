package problems_by_year.year_2020.month_05.problems_0511.Maximal_Square;

public class Solution {

    /**
     * Input:
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * Output: 4
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[] maxArea = new int[row+col];
//        int max = Math.max();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int area = calArea(matrix, Math.min(row-i, col-j), i, j);
            }
        }
        return 0;
    }
    // 这种写法其实是用暴力搜索法。
    private int calArea(char[][] matrix, int len, int i, int j) {
        if (matrix[i][j] == 0) {
            return 0;
        }
        int max = 1;
        for (int n = i; n < (i + len); n++) {
            for (int m = j; m < (j + len); m++) {
            }
        }
        return 0;
    }


    public int maximalSquare_A1(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    // 此处是and的语句，所以在遍历的时候一定会是一个正方形。
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        // 横坐标从保持i+sqlen不变，遍历纵坐标
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            sqlen++;
                        }
                    }
                    if (maxsqlen < sqlen) {
                        // 找到最大的正方形长度，然后结尾相乘
                        maxsqlen = sqlen;
                    }
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

}
