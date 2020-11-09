package problems_by_year.year_2020.month_08.problems_0803.Rotting_Oranges;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/5 10:08 下午
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] grids = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grids = new int[][]{{2,2,2,1,1}};
        int[][] grids = new int[][]{{2,1,1,0},{1,1,0,2}};
//        int[][] grids = new int[][]{{1,2}};

        Solution solution = new Solution();
        solution.orangesRotting_W3(grids);
    }


    /**
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     * If this is impossible, return -1 instead.
     * [[2],[1],[1],[1],[2],[1],[1]]  --> 2
     * [[2,1,1,0],[1,1,0,2],[0,0,0,1],[2,1,0,1],[0,0,0,1]] --> 3
     * 【 为什么会是4的结果？答：因为我用的是深度优先遍历，得到的是递归路径的长度，正确的做法应该是使用广度优先遍历，
     *   并且多个rotten orange同时进行取最小值】
     * 备注：像上面两个例子是多个起始点同时开始的，需要找到fresh -> rotting所有点的最短路径
     */
    public int orangesRotting_W3(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    int result = dfs(grid, i, j, 0);
                    max = Math.max(result, max);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int sr, int sc, int loopValue){
        if (sr<0 || sr >= grid.length || sc<0 || sc>=grid[0].length) {
            return loopValue;
        }
        grid[sr][sc] = 2;
        int v1=loopValue, v2 = loopValue, v3= loopValue, v4 = loopValue;
        if (sr-1 >= 0 && grid[sr-1][sc] == 1) {
            v1 = dfs(grid,sr-1, sc, v1+1);
        }
        if (sr+1 < grid.length && grid[sr+1][sc] == 1) {
            v2 = dfs(grid,sr+1, sc, v2+1);
        }
        if (sc-1 >= 0 && grid[sr][sc-1] == 1) {
            v3 = dfs(grid, sr,sc-1, v3+1);
        }
        if (sc+1 < grid[0].length && grid[sr][sc+1] == 1) {
            v4 = dfs(grid, sr,sc+1, v4+1);
        }
        return Math.max(Math.max(v1, v2), Math.max(v3, v4));
    }

    /**
     * This problems is the same as Flood Fill.
     * First, find the first position of rotten orange.
     * Second, record the minutes which any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten step by step.
     * Third, return -1 if have any fresh orange, if no fresh orange change, return minutes.
     *
     * int[][] grids = new int[][]{{2,2,2,1,1}} ——这个例子无法测试通过
     */
    public int orangesRotting_W2(int[][] grid) {
        int initRowIndex = -1;
        int initColIndex = -1;
        boolean hasFreshOrg = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2 && initRowIndex == -1 && initColIndex == -1) {
                    initRowIndex = i;
                    initColIndex = j;
                } else if (grid[i][j] == 1) {
                    hasFreshOrg = true;
                }
            }
        }

        if (initRowIndex == -1 && initColIndex == -1 && hasFreshOrg) {
            return -1;
        } else if (initRowIndex == -1 && initColIndex == -1 && !hasFreshOrg) {
            return 0;
        } else {
            int result = dfs(grid, initRowIndex, initColIndex, 0);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return result;
        }
    }

    /**
     * 这种写法是统计所有fresh -> rotting 的橘子个数
     * 正确的做法是统计递归次数，然后通过2的次方得出最后结果。
     */
    int freshOrgNums = 0;
    public int orangesRotting_W1(int[][] grid) {
        int initRowIndex = -1;
        int initColIndex = -1;
        boolean hasFreshOrg = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2 && initRowIndex == -1 && initColIndex == -1) {
                    initRowIndex = i;
                    initColIndex = j;
                } else if (grid[i][j] == 1) {
                    hasFreshOrg = true;
                }
            }
        }

        if (initRowIndex == -1 && initColIndex == -1 && hasFreshOrg) {
            return -1;
        } else if (initRowIndex == -1 && initColIndex == -1 && !hasFreshOrg) {
            return 0;
        } else {
            dfs_W1(grid, initRowIndex, initColIndex, false);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return freshOrgNums;
        }
    }
    private void dfs_W1(int[][] grid, int sr, int sc, boolean hasChange){
        if (sr<0 || sr >= grid.length || sc<0 || sc>=grid[0].length) {
            return;
        }
        grid[sr][sc] = 2;
        if (sr-1 >= 0 && grid[sr-1][sc] == 1) {
            dfs_W1(grid,sr-1, sc, true);
        }
        if (sr+1 < grid.length && grid[sr+1][sc] == 1) {
            dfs_W1(grid,sr+1, sc, true);
        }
        if (sc-1 >= 0 && grid[sr][sc-1] == 1) {
            dfs_W1(grid, sr,sc-1, true);
        }
        if (sc+1 < grid[0].length && grid[sr][sc+1] == 1) {
            dfs_W1(grid, sr,sc+1, true);
        }
        if (hasChange) {
            freshOrgNums++;
        }
        return;
    }

}
