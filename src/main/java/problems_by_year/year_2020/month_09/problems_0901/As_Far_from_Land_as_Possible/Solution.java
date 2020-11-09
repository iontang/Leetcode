package problems_by_year.year_2020.month_09.problems_0901.As_Far_from_Land_as_Possible;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/1 5:26 下午
 */
// 1162:
// As Far from Land as Possible
// as-far-from-land-as-possible

//Given an N x N grid containing only values 0 and 1, where 0 represents water and
//1 represents land, find a water cell such that its distance to the nearest land
//cell is maximized and return the distance.
//
// The distance used in this problem is the Manhattan distance: the distance bet
//ween two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
//
// If no land or water exists in the grid, return -1.
//
//
// Example 1:
//
//Input: [[1,0,1],               [[-1,0,-1],                       [[-1,1,-1],
//        [0,0,0],      -->       [0,0,0],                          [1,2,1],
//        [1,0,1]]                [-1,0,-1]]                        [-1,1,-1]]
//Output: 2
//Explanation:
//The cell (1, 1) is as far as possible from all the land with distance 2.
//
//
// Example 2:
//
//Input: [[1,0,0],                 [[-1,0,0],                 [[-1,1,2],
//        [0,0,0],      -->         [0,0,0],                   [1,2,3],
//        [0,0,0]]                  [0,0,0]]                   [2,3,4]]
//Output: 4
//Explanation:
//The cell (2, 2) is as far as possible from all the land with distance 4.
//
// Note:
//
//
// 1 <= grid.length == grid[0].length <= 100
// grid[i][j] is 0 or 1
//
// Related Topics Breadth-first Search Graph
// 👍 504 👎 27


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 获取0到最近的1 距离最大值。
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    queue.add(new int[] {i,j});
                }
            }
        }

        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0],y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && grid[newX][newY] == 0) {
                    if (grid[x][y] == -1) {
                        grid[newX][newY] = 1;
                    } else {
                        grid[newX][newY] = grid[x][y] + 1;
                    }
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        int maxRes = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxRes = Math.max(maxRes, grid[i][j]);
            }
        }
        if (maxRes == 0 || maxRes == -1) {
            return -1;
        } else {
            return maxRes;
        }
    }

    /**
     * 可以通过 boolean[][] visited记录已经被访问过的位置
     * @param grid
     * @return
     */
    public int maxDistance_A3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int result = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                result = Math.max(result, grid[cur[0]][cur[1]] - 1);
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        grid[x][y] = grid[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        return result == 0 ? -1 : result;
    }

    public int maxDistance_A2(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队。
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[] {newX, newY});
            }
        }
        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }
        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;
    }

    public int maxDistance_A1(int[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                // 201 here cuz as the despription, the size won't exceed 100.
                grid[i][j] = 201;
                if (i > 0) {
                    grid[i][j] = Math.min(grid[i][j], grid[i-1][j] + 1);
                }
                if (j > 0) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][j-1] + 1);
                }
            }
        }

        for (int i = n-1; i > -1; i--) {
            for (int j = m-1; j > -1; j--) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i < n-1) {
                    grid[i][j] = Math.min(grid[i][j], grid[i+1][j] + 1);
                }
                if (j < m-1) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][j+1] + 1);
                }
                // update the maximum
                res = Math.max(res, grid[i][j]);
            }
        }

        return res == 201 ? -1 : res - 1;

    }



}
//leetcode submit region end(Prohibit modification and deletion)

