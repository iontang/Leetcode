package problems_by_year.year_2020.month_10.problems_1005.Champagne_Tower;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/10/10 2:06 下午
 */
// 799:
// Champagne Tower
// champagne-tower

//We stack glasses in a pyramid, where the first row has 1 glass, the second row
// has 2 glasses, and so on until the 100th row. Each glass holds one cup (250ml)
//of champagne.
//
// Then, some champagne is poured in the first glass at the top. When the topmos
//t glass is full, any excess liquid poured will fall equally to the glass immedia
//tely to the left and right of it. When those glasses become full, any excess cha
//mpagne will fall equally to the left and right of those glasses, and so on. (A g
//lass at the bottom row has its excess champagne fall on the floor.)
//
// For example, after one cup of champagne is poured, the top most glass is full
//. After two cups of champagne are poured, the two glasses on the second row are
//half full. After three cups of champagne are poured, those two cups become full
//- there are 3 full glasses total now. After four cups of champagne are poured, t
//he third row has the middle glass half full, and the two outside glasses are a q
//uarter full, as pictured below.
//
//
//
// Now after pouring some non-negative integer cups of champagne, return how ful
//l the jth glass in the ith row is (both i and j are 0-indexed.)
//
//
// Example 1:
//
//
//Input: poured = 1, query_row = 1, query_glass = 1
//Output: 0.00000
//Explanation: We poured 1 cup of champange to the top glass of the tower (which
// is indexed as (0, 0)). There will be no excess liquid so all the glasses under
//the top glass will remain empty.
//
//
// Example 2:
//
//
//Input: poured = 2, query_row = 1, query_glass = 1
//Output: 0.50000
//Explanation: We poured 2 cups of champange to the top glass of the tower (whic
//h is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as
// (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, an
//d each will get half cup of champange.
//
//
// Example 3:
//
//
//Input: poured = 100000009, query_row = 33, query_glass = 17
//Output: 1.00000
//
//
//
// Constraints:
//
//
// 0 <= poured <= 109
// 0 <= query_glass <= query_row < 100
//
// 👍 449 👎 28


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {
        int maxRow = 100;
        double[][] dp = new double[maxRow+1][maxRow+1];
        dp[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            // j < 0 & j > i 的情况不可能
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(0, (dp[i-1][j]-1)/2);
                } else if (i == j) {
                    dp[i][j] = Math.max(0, (dp[i-1][j-1]-1)/2);
                } else {
                    dp[i][j] = Math.max(0, (dp[i-1][j]-1)/2) + Math.max(0, (dp[i-1][j-1]-1)/2);
                }
            }
        }
        return Math.min(dp[query_row][query_glass], 1.0);
    }

    public double champagneTower_A3(int poured, int query_row, int query_glass) {
        double[][] a=new double[101][101];
        a[0][0]=(double) poured;
        for(int i=0;i<=query_row;i++){
            for(int j=0;j<=i;j++){
                double q=(a[i][j]-1)/2.0;
                if(q>0){
                    a[i+1][j]+=q;
                    a[i+1][j+1]+=q;
                }
            }
        }
        return Math.min(1,a[query_row][query_glass]);
    }

    public double champagneTower_A1(int poured, int query_row, int query_glass) {
        double[] dp = new double[100];
        dp[0] = 1.0 * poured;
        if (query_row == 0 && query_glass == 0) {
            return dp[query_glass] > 1.0 ? 1.0 : dp[query_glass];
        }
        for (int i = 1; i < dp.length; i++) {
            double prev = 0.0;
            for (int j = 0; j <= i; j++) {
                double left = prev > 1 ? (prev - 1) / 2 : 0;
                double right = dp[j] > 1 ? (dp[j] - 1) / 2 : 0;
                prev = dp[j];
                dp[j] = left + right;
                if (i == query_row && j == query_glass)
                    return dp[j] > 1.0 ? 1.0 : dp[j];
            }
        }
        return 69.0;
    }

    public double champagneTower_A2(int poured, int query_row, int query_glass) {
        double[] res = new double[query_row + 2];
        res[0] = poured;
        for (int row = 1; row <= query_row; row++)
            for (int i = row; i >= 0; i--)
                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
        return Math.min(res[query_glass], 1.0);
    }

}
//leetcode submit region end(Prohibit modification and deletion)