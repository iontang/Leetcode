package jianzhiOffer;

/**
 * 二分法求解的demo
 * @author tangning
 *
 */
public class bsDemo {
	
	public static void main(String[] args) {
		
		
		int[] arr = {1,3,4,5,6};
		int pre = 0;
		int last = arr.length -1;
		
		int target = 2;
		while (pre <= last) {
			int middle = (pre + last) /2;
			System.out.println("pre=" + pre + " " + "middle=" + middle + " "+ "last = " + last);
			// 在左半部分，最大值缩小
			if (target < arr[middle]) {
				last = middle -1;
			} else if (target > arr[middle]) { // 在右半部分，最小值变大
				pre = middle+1;
			} else {
				System.out.println("true");
				
				break;
			}
		}
	}
}
