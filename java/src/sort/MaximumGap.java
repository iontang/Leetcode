package sort;

/**
 * 说明：排序算法有四大类：交换排序，插入排序，归并排序，快速排序。所有排序中，最快的时间复杂度是O(nlogn)
 * 这道题目要求线性的时间或空间，我现在有有个思路：
 * 1、先排序，然后求出两两之间的差，再求差的最大值。【问题：这个的时间复杂度是多少？】
 * 2、直接求出
 * @author tangning
 * 2017年11月8日 上午9:08:17
 */
public class MaximumGap {
	public static void main(String[] args) {
		int[] nums = {1,5,2,9};
		MaximumGap mg = new MaximumGap();
		mg.maximumGap(nums);
		
		// 求一个有序数组相邻元素的差：
		int[] sortedNums = {1,2,5,9};
		System.out.println(mg.subtract(sortedNums));
	}
	
	public int subtract(int[] nums) {
		if (nums.length < 2)
			return 0;
		int temp = 0;
		for (int i = 0 ;i<nums.length-1;i++) {
			int substractValue = nums[i+1] - nums[i];
			if (temp < substractValue)
				temp = substractValue;
		}
		return temp;
	}
	
    public int maximumGap(int[] nums) {
    	if (nums.length < 2)
    		return 0;
    	int start = 0;
    	int end = nums.length -1;
    	
    	int mid = nums[end]; // 基准
    	int left =start;
    	int right = end -1;
        return 0;
    }
    
    
}
