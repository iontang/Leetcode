package problems_by_year.year_2020.month_06.problems_0615.Surrounded_Regions_Solution;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/6/19 5:11 下午
 */
public class Solution {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}
        };
        Solution solution = new Solution();
        solution.solve_A1(board);
    }

    int n;
    int m;


    /**
     * Input
     * [["O","O","O"],["O","O","O"],["O","O","O"]]
     * Output
     * [["O","O","O"],["O","X","O"],["O","O","O"]]
     * Expected
     * [["O","O","O"],["O","O","O"],["O","O","O"]]
     * ooo    ooo
     * ooo -> oxo
     * ooo    ooo
     *
     * @param board
     */
    public void solve_W2(char[][] board) {
        int count = 0;
        n = board.length;
        if (n == 0) {
            return ;
        }
        m = board[0].length;
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 'O') {
                    DFSMarking(board, i, j);
                }
            }
        }
    }
    private void DFSMarking(char[][] board, int i, int j) {
        if (i < 1 || j < 1 || i >= n-1 || j >= m-1 || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'X';
        DFSMarking(board, i + 1, j);
        DFSMarking(board, i - 1, j);
        DFSMarking(board, i, j + 1);
        DFSMarking(board, i, j - 1);
    }


    public void solve_A1(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        if (n == 0) {
            return;
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(board[i][j] == 'O' && isOnBorder(board, i, j)) {
                    dfs(board, i, j);
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public boolean isOnBorder(char[][] board, int i, int j) {
        if (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1) {
            return true;
        }
        return false;
    }

    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0  || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = '*';

        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);
    }

}
