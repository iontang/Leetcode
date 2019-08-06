package divideandconquer;


/**
 * 题意：
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 */


public class SearchA2DMatrix {

    /**
     * 1、该做法的时间复杂度： O(m*n)
     * 2、二分查找的时间复杂度可为 ： O(logm + logn) = O(logm*n) ：
     * https://blog.csdn.net/linhuanmars/article/details/24216235
     * https://leetcode.com/problems/search-a-2d-matrix/discuss/26204/Share-my-two-O(logm-+-logn)-solutions
     *
     * 3、把矩阵转换为一个有序的一位数组：https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
     *
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 判断是否为二维矩阵：matrix.length == 0 || (matrix.length == 1 && matrix[0].length ==0)
        if (matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length ==0)) {
            return false;
        }
        int m = matrix.length;
        int row = 0;
        int col = matrix[0].length-1;
        while (col >= 0 && row < m) { // 跳出循环的条件是 括号内的条件都不满足
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) { // 内部条件判断使用 else if，如果都使用if独立，上一个条件满足的情况下，col为-1，会造成这个语句的数组越界
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
//        int[][] a = {{1}};
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        searchA2DMatrix.searchMatrix(a, 13);



    }

}
