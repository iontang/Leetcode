package jianzhiOffer.bc;

/**
 * 题意：
 * @author hadoop
 *
 */
public class MergeSortedArray {
	
	public static void main(String[] args) {
		int[] nums1 = {4,6,9,10,12,14};
		int[] nums2 = {1,3,7,8};
		// 1 3 4
		
		System.out.println(nums1.length);
		
    	int i = 4;
    	int j = 3;
    	int k = 8;
    	System.out.println(k--);
	
		// 将一个数插进有序数组，使得新数组有序，空间复杂度为O(1)
//		int v = 11;
//		int pre  = nums1.length-1;
//		int last = nums1.length;
//		for (int i =nums1.length-1;i>=0;i++) {
//			if(nums1[i] > v) {
//				nums1[last] = nums1[i];
//				last--;
//				pre--;
//			} else {
//				nums1[last] = v;
//				break;
//			}
//		}
//		for (int n1:nums1) {
//			System.out.println(n1);
//		}
		
	}
	
	
	/**
	 * 有序数组
	 * 数组nums1的长度大于等于数组nums1和nums2中元素个数m+n之和
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	
//		int[] nums1 = {4,6,9,10,12,14};
//		int[] nums2 = {1,3,7,8};
    	int i = m-1;
    	int j = n-1;
    	int k = m+n-1;
    	while(i>=0 && j>=0) {
    		if (nums1[i] > nums2[j]) {
    			nums1[k--] = nums1[i--];
    		} else {
    			nums1[k--] = nums2[j--];
    		}
    	}
    	while (j>=0) {
    		nums1[k--] = nums2[j--];
    	}
    	
    }
}
