package dp.lintcode.p04_maximal_rectangle;

import java.util.Stack;

/**
 * 给你一个二维矩阵，权值为False和True，找到一个最大的矩形，使得里面的值全部为True，输出它的面积
 *
 * 样例
 * 样例1
 *
 * 输入:
 * [
 *   [1, 1, 0, 0, 1],
 *   [0, 1, 0, 0, 1],
 *   [0, 0, 1, 1, 1],
 *   [0, 0, 1, 1, 1],
 *   [0, 0, 0, 0, 1]
 * ]
 * 输出: 6
 * 样例2
 *
 * 输入:
 * [
 *     [0,0],
 *     [0,0]
 * ]
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/5 11:47 下午
 */
public class Solution {

    /**
     * [
     [1, 1, 0, 0, 1],
     [0, 1, 0, 0, 1],
     [0, 0, 1, 1, 1],
     [0, 0, 1, 1, 1],
     [0, 0, 0, 0, 1]
     * ]
     *
     * [
     *   [1, 1, 0, 0, 1],
     *   [1, 1, 0, 0, 1],
     *   [0, 0, 1, 1, 1],
     *   [0, 0, 1, 1, 1]
     * ]
     * 暴力的方式： 该代码是参考Maximal Square实现的。
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle_W1(boolean[][] matrix) {
        // write your code here
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("##");
                }
                boolean temp = matrix[i][j];
                if (temp) {
                    int width = 1;
                    boolean wFlag = true;
                    // 横向比较
                    while (i+width < rows && wFlag) {
                        for (int k = j; k < cols; k++) {
                            if (!matrix[i+width][k]) {
                                wFlag = false;
                                break;
                            }
                        }
                        if (wFlag) {
                            width++;
                        }

                    }

                    int length = 1;
                    boolean lFlag = true;
                    while (j+length < cols && lFlag) {
                        for (int k = i; k < rows; k++) {
                            if (!matrix[k][j+length]) {
                                lFlag = false;
                                break;
                            }
                            System.out.println("=======k=" + k + " j+len=" +(j + length)+ " value=" + matrix[k][j+length]);

                        }
                        if (lFlag) {
                            length++;
                        }
                        System.out.println("=======1");
                    }
                    System.out.println("i=" +i  + " j=" + j + " length= " + length + "  width= " + width);
                    max = Math.max(max, length*width);

                }
            }
        }
        return max;
    }


    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        if (rows == 0 && cols ==0) {
            return 0;
        }
        int[][] width = new int[rows][cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean temp = matrix[i][j];
                if (temp) {
                    if (j >0) {
                        width[i][j] = width[i][j-1] +1;
                    } else {
                        width[i][j] = 1;
                    }
                } else {
                    width[i][j] = 0;
                }
                int minWidth = width[i][j];
                for (int up = i; up >= 0; up--) {
                    minWidth = Math.min(minWidth, width[up][j]);
                    maxArea = Math.max(minWidth* (i-up+1), maxArea);
                }
            }
        }
        return maxArea;
    }



    public static void main(String[] args) {
        boolean[][] matrix = {{true,true,false,false,true},{false,true,false,false,true},{false,false,true,true,true},{false,false,true,true,false},{false,false,false,false,true}};
        Solution solution = new Solution();
        System.out.println(solution.maximalRectangle_W1(matrix));;
    }

}
