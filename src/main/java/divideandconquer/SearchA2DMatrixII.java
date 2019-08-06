package divideandconquer;


import java.util.Arrays;

/**
 * 240. Search a 2D Matrix II
 *
 *
 * 题目要求：
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 * Given target = 15, return false.
 *
 */
public class SearchA2DMatrixII {


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int r=0; r<m; r++) {
            if (binarySearch(matrix[r], target, 0, matrix[r].length)) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] oneRow, int target, int left, int right) {
        // 判断停止的条件
        if (left >= right) {
            return false;
        }
        int mid = (left+right)/2;
        if (oneRow[mid] == target)
            return true;
        if (oneRow[mid] > target) {
            return binarySearch(oneRow, target, left, mid); // 不是 mid-1
        } else {
            return binarySearch(oneRow, target, mid+1, right);
        }
    }


    // 直接调用java api实现的二分查找：
    public boolean searchMatrix_A1(int[][] matrix, int target) {
        int m=matrix.length;
        for(int i=0;i<m;i++)
            if(Arrays.binarySearch(matrix[i],target)>=0)
                return true;

        return false;
    }


    public boolean searchMatrix_A2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0){
            return false;
        }
        int x=matrix.length-1;
        int y=0;
        while(x >=0 && y<= matrix[0].length-1){
            if(matrix[x][y]> target){
                x--;
            }else if(matrix[x][y]< target){
                y++;
            }else{
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        int a[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
        searchA2DMatrixII.searchMatrix(a, 5);
    }


}
