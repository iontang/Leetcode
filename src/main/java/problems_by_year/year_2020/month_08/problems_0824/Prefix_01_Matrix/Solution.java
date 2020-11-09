package problems_by_year.year_2020.month_08.problems_0824.Prefix_01_Matrix;

// 542:
// 01 Matrix
// 01-matrix

//Given a matrix consists of 0 and 1, find the distance of the nearest 0 for eac
//h cell.
//
// The distance between two adjacent cells is 1.
//
//
//
// Example 1:
//
//
//Input:
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//Output:
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//
// Example 2:
//
//
//Input:
//[[0,0,0],                        [[0,0,0],                [[0,0,0],
// [0,1,0],         -->             [0,-1,0],                [0,1,0],
// [1,1,1]]                         [-1,-1,-1]]              [1,2,1]]
//
//Output:
//[[0,0,0],
// [0,1,0],
// [1,2,1]]
//
//Input:
//[[0,0,0],
// [0,1,0],
// [1,1,1],
// [1,1,1]]
//
//Output:
//[[0,0,0],
// [0,1,0],
// [1,2,1]
// [2,3,2]]
//
// Note:
//
//
// The number of elements of the given matrix will not exceed 10,000.
// There are at least one 0 in the given matrix.
// The cells are adjacent in only four directions: up, down, left and right.
//
// Related Topics Depth-first Search Breadth-first Search
// 👍 1617 👎 109


import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/28 11:58 上午
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * [[0,0,0,0,0],
     *  [0,1,0,0,0],
     *  [1,1,1,1,1],
     *  [1,1,1,1,1],
     *  [1,1,1,1,1]]
     *  每次只把下一层的数据加入到队列中，不多不少，怎么实现？避免把已经遍历过的数据加进来；也避免把未遍历的重复数据加入队列中
     *  我的实现方式是：用下标相减的绝对值判断到那一层了，用链表判断重复的方式去重
     *  问题是：Queue<int[]>这类数组怎么判断去重？
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int res = bfs(matrix, i, j, m, n);
                    matrix[i][j] = res;
                }
            }
        }
        return null;
    }

    /**
     * [[0,0,0,0,0],
     *  [0,1,0,0,0],
     *  [1,1,1,1,1],
     *  [1,1,1,1,1],
     *  [1,1,1,1,1]]
     *  按照下面连接的模版：
     *  https://leetcode-cn.com/problems/word-ladder/solution/cai-yong-jing-dian-bfsmo-ban-tao-lu-by-xuncode/
     *  始终不知道怎么过滤掉不符合条件的位置。
     * @param matrix
     * @return
     */
    public int bfs(int[][] matrix, int iStart, int jStart, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{iStart, jStart});

        int sum = iStart+jStart;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            if (i-1 >= 0) {
                if (matrix[i-1][j] == 0) {
                    return Math.abs(sum-i-j+1);
                }
                queue.add(new int[]{i-1,j});
            }

            if (i+1 < m) {
                if (matrix[i+1][j] == 0) {
                    return Math.abs(sum-i-j-1);
                }
                queue.add(new int[]{i+1,j});
            }
            if (j-1 >= 0) {
                if (matrix[i][j-1] == 0) {
                    return Math.abs(sum-i-j+1);
                }
                queue.add(new int[]{i,j-1});
            }
            if (j+1 < n) {
                if (matrix[i][j+1] == 0) {
                    return Math.abs(sum-i-j-1);
                }
                queue.add(new int[]{i,j+1});
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] res = {{0,0,0,0,0}, {0,1,0,0,0}, {1,1,1,1,1}, {1,1,1,1,1},{1,1,1,1,1}};
        Solution solution = new Solution();
        solution.updateMatrix(res);
        solution.test(res);
        System.out.println("######");
    }

    private void test(int[][] matrix) {
        matrix[0][0] = 2;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
