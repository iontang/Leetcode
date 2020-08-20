package problems_by_year.year_2020.month_04.problems_20200420.Number_of_Islands;

public class Solution {
    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 关于岛的定义：
     * https://juejin.im/post/5d677fadf265da03bb4abc6c
     *
     * Example 1:
     *
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * Output: 1
     * Example 2:
     *
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     * Output: 3
     *
     * 11000
     * 11000
     * 00110
     * 00100
     * Output: 2
     *
     * 00000
     * 00100
     * 01110
     * 00000
     * 00000
     * Output: 2
     */
    // [["0","0","0","0","0"],["0","0","1","0","0"],["0","1","1","1","0"],["0","0","0","0","0"],["0","0","0","0","0"]]
    public int numIslands(char[][] grid) {

        int rowLen = grid.length;
        int columnLen = grid[0].length;

        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j<columnLen; j++) {
                if (grid[i-1][j] == 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        Solution solution = new Solution();
        solution.numIslands_A1(grid);
    }
    private int n;
    private int m;
    public int numIslands_A1(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

}
