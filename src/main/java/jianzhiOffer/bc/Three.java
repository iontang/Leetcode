package jianzhiOffer.bc;


/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author hadoop
 *
 */

public class Three {
	public static void main(String[] args) {
//		int array[ ][ ]={{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
		
		int array[ ][ ]={{1,3,5,7,9,10,11}};
		Three t = new Three();
//		if (t.Find(2, array)) {
//			System.out.println("yes");
//		} else {
//			System.out.println("no");
//		}
		
        int[][] matrix = {  
                {1, 2, 8, 9},  
                {2, 4, 9, 12},  
                {4, 7, 10, 13},  
                {6, 8, 11, 15}  
        };  
//        int[][] matrix = null;
		System.out.println(t.searchMatrix(matrix, 7));    // 要查找的数在数组中  
//        System.out.println(t.searchMatrix(matrix, 5));    // 要查找的数不在数组中  
//        System.out.println(t.searchMatrix(matrix, 1));    // 要查找的数是数组中最小的数字  
//        System.out.println(t.searchMatrix(matrix, 15));   // 要查找的数是数组中最大的数字  
//        System.out.println(t.searchMatrix(matrix, 0));    // 要查找的数比数组中最小的数字还小  
//        System.out.println(t.searchMatrix(matrix, 16));   // 要查找的数比数组中最大的数字还大  
//        System.out.println(t.searchMatrix(null, 16));     // 健壮性测试，输入空指针  
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	
//    	if (matrix == null || matrix.length<1 || matrix[0].length <1) {
//    		return false;
//    	}
    	for (int i=0;i<matrix.length;i++) {
    		if (isExistnum(target, matrix[i])) {
    			return true;
    		}
    	}
		return false;
    }
    
    // 题目分解：给定一个数，判断递增数组中是否存在这样一个数：
    // 计算中位数的方法：
//    {1,1}
    public static boolean isExistnum(int num, int[] arr) {
    	System.out.println(num);
    	num = 3;
    	int[] arr1 = {1,3,5,7};
    	arr = arr1;
    	int pre = 0;
    	int last = arr.length-1;
    	int middle = (last -pre) /2;
    	System.out.println("pre = " + pre + " " + "middle = " + middle + " " + " last = " + last);
    	while (pre < last) {
    		System.out.println("pre = " + pre + " " + "middle = " + middle + " " + " last = " + last);
    		if (arr[pre] < num && num < arr[middle]) {
        		last = middle-1;
        	} else if (arr[middle] < num && num< arr[last]) {
        		pre = middle+1;
        	} else if (arr[middle] == num){
        		return true;
        	} else {
        		return false;
        	}
    		middle = (last -pre)/2;
    	}
    	return false;
    }
    
}
