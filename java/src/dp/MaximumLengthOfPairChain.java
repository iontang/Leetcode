package src.dp;


import java.util.Arrays;

public class MaximumLengthOfPairChain {
	// In every pair, the first number is always smaller than the second number.
	public static void main(String[] args) {
		int intArray[][] = {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}} ;
//		int intArray[ ][ ]={{5,1},{2,3},{6,9}};
//		int intArray[ ][ ]={{1,2},{2,3},{3,4}};
		MaximumLengthOfPairChain m = new MaximumLengthOfPairChain();
		m.findLongestChain(intArray);
	}
	
	// [[1,2], [2,3], [3,4]]
	// [[7,9],[3,5],[2,3],[1,2]]
    public int findLongestChain(int[][] pairs) {
    	// 先按照每列的第一行排序，因为排序说You can select pairs in any order.
//        Comparator<int[]> comparator = new Comparator<int[]>(){
//            @Override
//            public int compare(int[] a, int[] b)
//            {
//                if(a[0]==b[0])
//                    return b[1]-a[1];
//                else
//                    return a[0]-b[0];
//            }
//        };
//        Arrays.sort(pairs, comparator);
        // 上面的排序方法会出现超时
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
    	int n = pairs.length;
    	int[] dp = new int[n];
    	dp[0] = 1;
    	int maxLen = 1;
    	for (int i=1;i<n;i++) {
    		dp[i] =1;
    		for (int j = 0;j<i;j++) {
    			if (pairs[i][0] > pairs[j][1] &&  dp[i] < dp[j] +1) {
    				dp[i] = dp[j] + 1;
    			}
    		} 
    		if (maxLen < dp[i]) {
    			maxLen = dp[i];
    		}
    	}
		return maxLen;
    }
    
    /**
     * 参考答案：使用快排,然后使用贪心算法：
     * @param pairs
     * @return
     */
    public int findLongestChain_A1(int[][] pairs) {
        QuickSort(pairs, 0, pairs.length-1);
        int count = 1;
        int flag = pairs[0][1];
        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0]>flag){
                count++;
                flag = pairs[i][1];
            }
        }
        return count;
    }

    private static void QuickSort(int[][] array,int start,int end)
    {
        if(start<end)
        {
            int key=array[start][1];
            int key0 = array[start][0];//初始化保存基元
            int i=start,j;//初始化i,j
            for(j=start+1;j<=end;j++)
            {
                if(array[j][1]<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                {
                    int temp=array[j][1];
                    int temp0 = array[j][0];
                    array[j][1]=array[i+1][1];
                    array[j][0]=array[i+1][0];
                    array[i+1][1]=temp;
                    array[i+1][0]=temp0;
                    i++;
                }

            }
            array[start][1]=array[i][1];
            array[start][0]=array[i][0];//交换i处元素和基元
            array[i][1]=key;
            array[i][0]=key0;
            QuickSort(array, start, i-1);//递归调用
            QuickSort(array, i+1, end);

        }

    }

}
