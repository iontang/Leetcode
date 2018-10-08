package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortColors {
	
	// 该题拓展： 
	
	// 如果是无重复的数组，如何排序？
	public static void main(String[] args) throws IOException {
		int[] nums = {2,1};//换1,0
//		int[] nums = {0,1, 2, 1, 0,1,2}; //换完
		
//		int[] nums = {0,1, 2, 1, 0,1,2}; //换完2
//		int[] nums = {0,1, 1, 1, 0,2,2}; //换完1,2
		
//		int[] nums = {0,1, 1, 1, 0,2,2}; //换完,2
		if (null  == nums || nums.length == 0)
			return ;
		int head = 0;
		int i = 0;
		int tail = nums.length - 1;
		for (; head<nums.length && head<=tail; ) {
			if (nums[head] == 0) {
				swap(nums, i, head);
				i++;
				head++;
			} else if(nums[head] == 2 ) {
				swap(nums, head, tail);
				tail--;
			} else {
				head++;
			}
		}
		
		for (Integer ii : nums) {
			System.out.println(ii);
		}
		
	}

	private static void swap(int[] nums, int i, int temp) {
		int tValue = nums[i];
		nums[i] = nums[temp];
		nums[temp] = tValue;
	}
	/**
	 * 解决方案1
	 * @param nums
	 */
    public void sortColors(int[] nums) {

		int[] resutls = nums.clone();
		int j = 0;
        for (int i=0;i<resutls.length;i++) {
        	if (resutls[i] == 0) {
        		nums[j] = resutls[i];
        		j++;
        	}
        }
        for (int i=0;i<resutls.length;i++) {
        	if (resutls[i] == 1) {
        		nums[j] = resutls[i];
        		j++;
        	}
        }
        for (int i=0;i<resutls.length;i++) {
        	if (resutls[i] == 2) {
        		nums[j] = resutls[i];
        		j++;
        	}
        }
    	
    }
	
	
}