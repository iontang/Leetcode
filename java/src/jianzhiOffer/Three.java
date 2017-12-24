package jianzhiOffer;


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
		if (t.Find(2, array)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		
	}
	
    public boolean Find(int target, int [][] array) {
    	for (int i=0;i<array.length;i++) {
    		if (isExistnum(target, array[i])) {
    			return true;
    		}
    	}
		return false;
    }
    
    // 题目分解：给定一个数，判断递增数组中是否存在这样一个数：
    // 计算中位数的方法：
    public static boolean isExistnum(int num, int[] arr) {
    	int pre = 0;
    	int last = arr.length-1;
    	int middle = (last -pre) /2;
    	while (pre < last) {
    		if (arr[middle] > num) {
        		last = middle-1;
        	} else if (arr[middle] < num) {
        		pre = middle+1;
        	} else {
        		return true;
        	}
    		middle = (last -pre)/2;
    	}
    	return false;
    }
    
}
