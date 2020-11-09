package dp.lintcode.p07_stone_game;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/12 10:37 下午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.stoneGame_A1(new int[] {4, 1, 1, 4});
    }

    /**
     * 每次只能合并相邻的石子，所有用优先队列是错误的
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame_W1(int[] A) {
        // write your code here
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : A) {
            queue.add(i);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll() + queue.poll();
            res += temp;
            if (!queue.isEmpty()) {
                queue.add(temp);
            }
        }
        return res;
    }

    /**
     * try to use dynamic programming
     * @param A
     * @return
     */
    public int stoneGame_W2(int[] A) {
        int n = A.length;
        int[][] dp = new int[n+1][n+1];
        int[] sum = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            sum[i] = sum[i-1] + A[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n -len +1; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                int leastSum = sum[j]-sum[i-1];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k+1][j] + leastSum);
                }
            }
        }
        return dp[0][n-1];
    }

    /**
     * 如果不要求相邻，用贪心算法。
     * this code is right, using dynamic programming.
     * @param A
     * @return
     */
    public int stoneGame_A1(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] sum=new int[n+1];
        // 令DP[i][j]为从第 i 堆金币到第 j 堆金币合并所需的最小代价。
        // 那么当前状态可以由前一个状态转移得到吗?如何转移?
        // 区间 [i,j] 可以从以任意的 i<=k<j 为分割点所得的两个子区间得来。
        int[][] dp=new int[n][n];
        for(int i=1;i<=n;i++) {
            // 前缀和
            sum[i]=sum[i-1]+A[i-1];
        }
        // 总结：先for循环长度，在for循环起点
        // 区间长度
        for(int len=2;len<=n;len++) {
            // 区间起点，第i堆
            for(int i=0;i<=n-len;i++) {
                // 区间终点，第j堆
                int j=i+len-1;
                dp[i][j]=100000000;
                 // 合并必要代价，一般来说，区间[i,j]的前缀和是sum[j]-sum[i-1],
                // 但是因为sum[0]是空值，且sum的length是n+1，所以前缀和是sum[j+1]-sum[i]
                int cost = sum[j+1]-sum[i];
                // 分割线：4 | 1 | 1 | 4
                for(int k=i; k<j; k++) {
                    // 状态方程怎么写?
                    int cur = dp[i][j];
                    int sec = dp[i][k]+dp[k+1][j]+cost;
                    dp[i][j]=Math.min(cur, sec);
                }
            }
        }
        return dp[0][n-1];
    }

    /**
     * 合并相邻的K个堆，区别于上面合并相邻的2个堆
     * @param stones
     * @param K
     * @return
     */
    public int mergeStones(int[] stones, int K) {
        int n=stones.length;
        if((n-1)%(K-1)!=0)
            return -1;
        int[] sum=new int[n+1];
        int[][] dp=new int[n][n];
        for(int i=1;i<=n;i++)
            sum[i]=sum[i-1]+stones[i-1];
        for(int len=K;len<=n;len++)
            for(int i=0;i<=n-len;i++) {
                int j=i+len-1;
                dp[i][j]=100000000;
                for(int k=i;k<j;k+=K-1) {
                    if((len-1)%(K-1)==0)
                        dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+sum[j+1]-sum[i]);
                    else
                        dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
                }
            }

        return dp[0][n-1];
    }

}
