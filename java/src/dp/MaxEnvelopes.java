package dp;

import java.util.Arrays;
import java.util.Comparator;

//类似寻找最长子串：https://leetcode.com/problems/longest-increasing-subsequence/description/
public class MaxEnvelopes {
	// 5,5,8,2,6
	public static void main(String[] args) {
		// [[5,4],[6,4],[8,9],[2,3],[6,7]]
		// 分析：如果{6,4}在{5,4}的前面，如果确定是选取{5,4}还是选取{6,4}：此处如果w或h相等，比较不等的并选取较小的那个值
		int intArray[][] = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		// int intArray[ ][ ]={{6,4},{5,4},{8,9},{2,3},{6,7}};
		MaxEnvelopes me = new MaxEnvelopes();

		me.maxEnvelopes_A1(intArray);
	}

	// 状态：dp[0][0] =0, dp[0][1] =0;
	// 状态转移：1、envelopes[x][0]小于
	// 如果是乱序的情况，不满足动态规划，因为其子问题和前面的都相关，需要先排序
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		if (n == 0) {
			return 0;
		}
		int[][] dp = new int[n][2];
		int count = 0;
		for (int x = 0; x < envelopes.length; x++) {
			System.out.println(envelopes[x][0]); // w
			System.out.println(envelopes[x][1]); // h
		}
		return dp.length;
	}
	
	public int maxEnvelopes_A1(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[0] == arr2[0]) {
					return arr2[1] - arr1[1];
				} else {
					return arr1[0] - arr2[0];
				}
			}
		});
		for (int x = 0; x < envelopes.length; x++) {
			System.out.println(envelopes[x][0]); // w
			System.out.println(envelopes[x][1]); // h
		}
		
		
//		int[] dp = new int[envelopes.length];
//		int len = 0;
//		for (int[] envelope : envelopes) {
//			int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
//			if (index < 0) {
//				index = -index - 1;
//			}
//			dp[index] = envelope[1];
//			if (index == len)
//				len++;
//		}
//		return len;
		return 0;
	}
	
}
