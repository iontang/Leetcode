package problems_by_year.year_2020.month_07.problems_0706.Island_Perimeter;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/7 9:38 下午
 */
public class Solution {

    private int n;
    private int m;
    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int borders = 4;
                    if (!isIllegalIndex(i-1, j) && grid[i-1][j] == 1) {
                        borders--;
                    }
                    if (!isIllegalIndex(i+1, j) && grid[i+1][j] == 1) {
                        borders--;
                    }
                    if (!isIllegalIndex(i,j-1) && grid[i][j-1] == 1) {
                        borders--;
                    }
                    if (!isIllegalIndex(i,j+1) && grid[i][j+1] == 1) {
                        borders--;
                    }
                    cnt += borders;
                }
            }
        }
        return cnt;
    }

    private boolean isIllegalIndex(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return true;
        }
        return false;
    }

    public int islandPerimeter_A1(int[][] grid) {
        if(grid.length == 0 || grid == null || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        //iterate over the matrix
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                //each time you find a 1, increase by 4
                if(grid[i][j] == 1){
                    result += 4;
                    //each time you find a 1 to left or top decrease 2
                    if(i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }
                    if(j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }

}
