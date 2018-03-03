package src.dp;



public class LengthOfLIS {

	public static void main(String[] args) {
//		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] nums = {1,3,6,7,9,4,10,5,6};
		LengthOfLIS lolis = new LengthOfLIS();
		lolis.lengthOfLIS(nums);
	}
	
	/**
	 * 状态：dp[0] = 1
	 * 状态转移方程： dp[i]
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if (len < 2) 
			return len;
		int[] dp = new int[len];
		dp[0] = 1;
		for(int i =1;i<len;i++) {
			for (int j =0;j<i;j++) {
				if(nums[i] > nums[j]) {
					if (dp[i] < dp[j]+1) {
						dp[i] = dp[j] +1; 
					}
				} else {
					if(dp[i]<1) {
						dp[i] = 1;
					}
				}
			}
		}
		int max = 0;
		for (int k = 0;k<len; k++) {
			if(max < dp[k]) {
				max = dp[k];
			}
		}
		return max;
	}
	
	
	/**
	 * 优化代码：
	 */
	public int lengthOfLIS_A1(int[] nums) {
		int n = nums.length;
        if (n <2)
            return n;
		int[] dArr = new int[n]; // O(n)的空间
		int len = 1;
		for (int i = 0; i < n; i++) {
			System.out.println("i = " + i);
			dArr[i] = 1; // 每次初始化都为1，
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dArr[j] + 1 > dArr[i]) {
					dArr[i] = dArr[j] + 1;
				}
				if (dArr[i] > len) {
					len = dArr[i];
				}
			}
		}
		return len;
	}
	
	/**
	 * 参考答案：https://leetcode.com/articles/longest-increasing-subsequence/
	 */
	
}
