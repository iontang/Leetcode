package sort;
// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. 900
// [3, 30, 340, 5, 9] :"95340330"
// [2, 34444442, 34444441, 5, 9] : "9534444442344444412"

//这道题也是排序，只是排序的规格不同了

// 思路：
// 1、定义比较两个数大小的方法；
// 2、使用快排
public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
//		int[] nums = {3,322,5,321,9}; // 从这里找到最大的数，然后根据它的个数进行循环的对比
//		quickSort(nums);
//		for (int k = 0;k<nums.length;k++) {
//			System.out.println(nums[k]);
//		}
//		[121,12]
		int[] nums = {1228,12};
		if (compareNums(1,2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
//        for(int i=0;i<nums.length-1;i++){  
//            for(int j=nums.length-1;j>i;j--){  
//            	if (compareNums(nums[j-1], nums[j])) {
//					System.out.println("true");
//				} else {
//					System.out.println("false");
//				}
////                if(nums[j-1]>nums[j]){
//            	if (compareNums(nums[j-1], nums[j])) {
//                    int temp=nums[j-1];  
//                    nums[j-1]=nums[j];  
//                    nums[j]=temp;  
//                }  
//            }  
//        }
		String result="";
		for (int k = nums.length-1; k >=0; k--) {
			result += nums[k] + "";
//			System.out.println(nums[k]);
		}
		System.out.println(result);
		
	}
	
	/**
	 * 个位数相比，然后十位数，然后百位数
	 * @param nums
	 * @return
	 */
    public String largestNumber(int[] nums) {
    	if (nums.length <= 1) {
    		return (nums.length==0 ? null : nums[0]+"");
    	}
    	
        for (int i = 0;i<nums.length;i++) {
//        	System.out.println(nums[i]/10);
        	while (nums[i] >=100) {
        		
        		nums[i] /= 10;
        	}

        		
        }
    	return null;
    }

    // 参考
	public static void quickSort(int[] arr){
	    qsort(arr, 0, arr.length-1);
	}
	
	private static void qsort(int[] arr, int low, int high){
	    if (low < high){
	        int pivot=partition(arr, low, high);        //将数组分为两部分
	        qsort(arr, low, pivot-1);                   //递归排序左子数组
	        qsort(arr, pivot+1, high);                  //递归排序右子数组
	    }
	}
	
	private static int partition(int[] arr, int low, int high){
	    int pivot = arr[low];     //枢轴记录
	    while (low<high){
	        // while (low<high && arr[high]>=pivot) --high;
	    	while (low<high && compareNums(arr[high],pivot)) --high;
	        arr[low]=arr[high];             //交换比枢轴小的记录到左端
	        //  while (low<high && arr[low]<=pivot) ++low;
	        while (low<high && !compareNums(arr[low],pivot)) ++low;
	        arr[high] = arr[low];           //交换比枢轴小的记录到右端
	    }
	    //扫描完成，枢轴到位
	    arr[low] = pivot;
	    //返回的是枢轴的位置
	    return low;
	}

	/**
	 * 比较两个数的大小
	 * @param ele1
	 * @param ele2
	 */
	public static boolean compareNums(int ele1, int ele2) {
		System.out.println("ele1= " + ele1);
		System.out.println("ele2= " + ele2);
		System.out.println("===========================");
		// 这两个临时变量用于获取两个整数的位数
		int temp1 = ele1;
		int temp2 = ele2;
		int p1 = 0;
		while (temp1 >= 10) {
			p1 += 1;
			temp1 /= 10;
		}
		int p2 = 0;
		while (temp2 >= 10) {
			p2 += 1;
			temp2 /= 10;
		}
		if (p1 == p2 && ele1 > ele2) { // 位数相同的比较大小
			return true;
		}

		int num1 = ele1;
		int num2 = ele2;
		
		int digitNum1 = 0;
		int digitNum2 = 0;
		while (p1 != 0 || p1 != 0) { // 位数不同的比较大小
			System.out.println("p1=" + p1);
			System.out.println("p2=" + p2);
			int divisorNum1 = (int) Math.pow(10, p1);
			digitNum1 = num1 / divisorNum1;
			num1 %= divisorNum1; // 获得最高位之外的余数
			
//			if (num1 / divisorNum1 != 0) {
//				digitNum1 = num1 / divisorNum1;
//				num1 %= divisorNum1;
//			}
			
			if (p1 != 0) {
				p1--;
			}

			int divisorNum2 = (int) Math.pow(10, p2);
			digitNum2 = num2 / divisorNum2;
			num2 %= divisorNum2; // 获得最高位之外的余数
//			if (num2 / divisorNum2 != 0) {
//				digitNum2 = num2 / divisorNum2;
////				digitNum2 = num2 / divisorNum2;
//				num2 %= divisorNum2;
//			} 
			System.out.println("digitNum1=" + digitNum1);
			System.out.println("digitNum2=" + digitNum2);
			System.out.println("num1=" + num1);
			System.out.println("num2=" + num2);
			if (p2 != 0) {
				p2--;
			}
			if (digitNum1 > digitNum2) { // ele1比ele2大
				return true;
			}
			System.out.println("##############");
		}
		System.out.println("p1=" + p1);
		System.out.println("p2=" + p2);
		
		System.out.println("digitNum1=" + digitNum1);
		System.out.println("digitNum2=" + digitNum2);
		System.out.println("num1=" + num1);
		System.out.println("num2=" + num2);
		if (num1 > digitNum2)
			return true;
		return false;
	}
	
}
