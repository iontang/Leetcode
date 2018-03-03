package src.dp;

public class IncreasingTriplet {
	
	// [7,2,8,6,5]
	public static void main(String[] args) {
//		int[] nums = {1, 2, 3, 4, 5};
//		int[] nums = {4,7,2,8,6,5};
		int[] nums = {5,2,4,1,5,2,2};
		IncreasingTriplet ii = new IncreasingTriplet();
		if(ii.increasingTriplet_A1(nums)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		};
	}
	
	/**
	 * 用dp求解：
	 * @param nums
	 * @return
	 */
    public boolean increasingTriplet(int[] nums) {
    	int n = nums.length;
    	if (n < 3)
    		return false;
    	int[] dp = new int[n];
    	dp[0] = 1;
    	for(int i = 1;i<n;i++) {
    		dp[i] = 1;// 初始化
    		for (int j =0;j<i;j++) {
    			if (nums[i]>nums[j] && dp[i] < dp[j]+1) {
    				dp[i] = dp[j] +1;
    			}
    		}
    		if (dp[i] == 3) {
    			return true;
    		};
    	}
        return false;
    }
    
    /**
     * 参考：
     * 题目要求时间复杂度和空间复杂度：
     * Your algorithm should run in O(n) time complexity and O(1) space complexity.
     * 如何理解其思路：
     * Really smart solution, though the return indexes for the subsequence are wrong. 
     * The basic idea is that the SecondMin value will be updated only if there is at least one smaller value before it.
     */
    
    /**
     * I think this line is not necessary in this case when use the foreach loop :
     * if (nums == null || nums.length < 3 ){return false;}
     * @param nums
     * @return
     */
    public boolean increasingTriplet_A1(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
        	// 找到一个较小值，此步骤将不断更新较小值，
        	System.out.print("1= " + small + " " + big + " " + n); 
        	System.out.println();
            if (n <= small) { small = n; } // update small if n is smaller than both
            // 找到一个较大值
            // update big only if greater than small but smaller than big
            // 上面的if保证了大于small，否则这个for循环会走上面一个if语句，即永远存在small < big
            else if (n <= big) { big = n; } 
            // small < big < n
            else {
            	System.out.print("##= " + small + " " + big + " " + n); 
            	return true; // return if you find a number bigger than both
            }
        }
        return false;
    }
}
