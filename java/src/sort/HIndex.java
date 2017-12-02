package sort;

/**
 * 先排序【注意，一定要从大到小排序】，再取最小值里面的最大值
 * @author tangning
 * 2017年11月14日 上午9:29:37
 */
public class HIndex {

	public static void main(String[] args) {
		HIndex hi = new HIndex();
		// [1] 应该为1的
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(hi.hIndex(citations));
	}
	/**
	 * 第一版本算法：排序之后遍历比较【也可以排序之后二分搜索】，时间复杂度:O(nlogn+ n)，空间复杂度为n，可以减少为常数的线性空间
	 * @param citations
	 * @return
	 */
    public int hIndex(int[] citations) {
    	if (citations.length == 0)
    		return 0;
    	quickSort(citations);
    	int min = 0;
    	for (int i = 0;i<citations.length;i++) {
    		if (citations[i] > i) {
    			min = i+1;
    		} else {
    			min = citations[i];
    		}
    		citations[i] = min;// 重新赋值citations数组
    	}
    	
    	int max = 0;
		for (int j = 0; j < citations.length; j++) {
			if (citations[j] > max) {
				max = citations[j];
			}
		}
		return max;
    }
    
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
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[low]; // 枢轴记录
		while (low < high) {
			while (low < high && arr[high] <= pivot)
				--high;
			arr[low] = arr[high]; // 交换比枢轴小的记录到左端
			while (low < high && arr[low] >= pivot)
				++low;
			arr[high] = arr[low]; // 交换比枢轴小的记录到右端
		}
		arr[low] = pivot;
		return low;
	}

	
	
	// 参考答案1：
	public int hIndexA1(int[] citations) {
	    int len = citations.length;
	    int[] count = new int[len + 1];
	    
	    for (int c: citations)
	        if (c > len) 
	            count[len]++;
	        else 
	            count[c]++;
	    
	    
	    int total = 0;
	    for (int i = len; i >= 0; i--) {
	        total += count[i];
	        if (total >= i)
	            return i;
	    }
	    
	    return 0;
	}
}
