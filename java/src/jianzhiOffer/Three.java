package jianzhiOffer;


/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
        System.out.println(t.searchMatrix(matrix, 7));    // 瑕佹煡鎵剧殑鏁板湪鏁扮粍涓�  
//        System.out.println(t.searchMatrix(matrix, 5));    // 瑕佹煡鎵剧殑鏁颁笉鍦ㄦ暟缁勪腑  
//        System.out.println(t.searchMatrix(matrix, 1));    // 瑕佹煡鎵剧殑鏁版槸鏁扮粍涓渶灏忕殑鏁板瓧  
//        System.out.println(t.searchMatrix(matrix, 15));   // 瑕佹煡鎵剧殑鏁版槸鏁扮粍涓渶澶х殑鏁板瓧  
//        System.out.println(t.searchMatrix(matrix, 0));    // 瑕佹煡鎵剧殑鏁版瘮鏁扮粍涓渶灏忕殑鏁板瓧杩樺皬  
//        System.out.println(t.searchMatrix(matrix, 16));   // 瑕佹煡鎵剧殑鏁版瘮鏁扮粍涓渶澶х殑鏁板瓧杩樺ぇ  
//        System.out.println(t.searchMatrix(null, 16));     // 鍋ュ．鎬ф祴璇曪紝杈撳叆绌烘寚閽�  
		
	}
	
    public boolean searchMatrix(int [][] matrix,int target) {
   	 if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {  
            return false;  
        } 
   	for (int i=0;i<matrix.length;i++) {
   		if (isExistnum(target, matrix[i])) {
   			return true;
   		}
   	}
		return false;
   }

    // 计算中位数的方法：【错误方法】
    /**
     * 第一版代码：计算中位数错误的方法
     * @param num
     * @param arr
     * @return
     */
//    public static boolean isExistnum(int num, int[] arr) {
//    	int pre = 0;
//    	int last = arr.length-1;
//    	int middle = (last -pre) /2;
//    	System.out.println("pre=" + pre + " " + "middle=" + middle + " "+ "last = " + last);
//    	while (pre < last && (last -pre > 1)) {
//    		System.out.println("pre=" + pre + " " + "middle=" + middle + " "+ "last = " + last);
//    		if (arr[middle] > num) {
//        		last = middle-1;
//        	} else if (arr[middle] < num) {
//        		pre = middle+1;
//        	} else {
//        		return true;
//        	}
//    		middle = (last -pre)/2;
//    	}
//    	return false;
//    }
    
    
    public static boolean isExistnum(int num, int[] arr) {
    	int pre = 0;
    	int last = arr.length-1;
    	while (pre <= last) {
    		int middle = (last+pre) /2;
    		if (arr[middle] > num) {
        		last = middle-1;
        	} else if (arr[middle] < num) {
        		pre = middle+1;
        	} else {
        		return true;
        	}
    	}
    	return false;
    }
    
}
