package problems_by_year.year_2020.month_08.problems_0824.Prefix_01_Matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName Solution_A1
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/1 3:58 下午
 */
public class Solution_A1 {

    public static void main(String[] args) {
        int[][] res = {{0,0,0,0,0}, {0,1,0,0,0}, {1,1,1,1,1}, {1,1,1,1,1},{1,1,1,1,1}};
        Solution_A1 solution = new Solution_A1();
        solution.updateMatrix(res);
        System.out.println("######");
    }

    /**
     * 理解：把多个0视作一个大0
     * https://leetcode-cn.com/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        // 这个变量相当于往上下左右方向移动
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return matrix;
    }


    public int[][] updateMatrix_A2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int range = matrix.length * matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    int upCell = (i > 0) ? matrix[i - 1][j] : range;
                    int leftCell = (j > 0) ? matrix[i][j - 1] : range;
                    matrix[i][j] = Math.min(upCell, leftCell) + 1;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    int downCell = (i < matrix.length - 1) ? matrix[i + 1][j] : range;
                    int rightCell = (j < matrix[0].length - 1) ? matrix[i][j + 1] : range;
                    matrix[i][j] = Math.min(Math.min(downCell, rightCell) + 1, matrix[i][j]);
                }
            }
        }
        return matrix;

    }

}
