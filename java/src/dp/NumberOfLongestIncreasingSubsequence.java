package dp;

/**
 * 子序列的个数相同最多的值
 * @author hadoop
 *
 */
public class NumberOfLongestIncreasingSubsequence {

	public static void main(String[] args) {
//		int[] nums = {1,3,6,7,9,4,10,5,6};
		int[] nums = {1,3,5,4,7};
//		int[] nums = {2,2,2,2,2};
		NumberOfLongestIncreasingSubsequence nois = new NumberOfLongestIncreasingSubsequence();
		
		nois.findNumberOfLIS(nums);
	}
	
    public int findNumberOfLIS(int[] nums) {
    	int n = nums.length;
        if (n<2)
            return n;
    	int[] dp = new int[n];
    	dp[0] =1;
    	int maxLen = 1;
    	for (int i=1;i<n;i++) {
    		dp[i] = 1;
    		for (int j = 0;j<i;j++) {
    			if (nums[i] > nums[j] && dp[i] < dp[j]+1) {
    				dp[i] = dp[j] +1;
    			}
    			if (maxLen < dp[i]) {
    				maxLen = dp[i];
    			}
    		}
    	}
    	//如何求一个数组中出现次数最多的数
    	int count =0;
    	for(int k=0;k<n;k++) {
    		System.out.println(dp[k] + " " + maxLen);
    		if (dp[k] == maxLen) {
    			System.out.println();
    			count +=1;
    		}
    	}
    	System.out.println("count=" +count);
    	return count;
    }

}
