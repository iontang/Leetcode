package sort.Based_Algorithm.sort_01;

/**
 * ClassName SelectSort
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/2/5 5:50 下午
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,6,9,1};
        SelectSort sort = new SelectSort();
        sort.selectSort(nums);
        for(int e : nums) {
            System.out.println(e);
        }
    }

    private void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = len-1; i >=0 ; i--) {
            int maxIdx = i;
            for (int j = i-1; j >=0 ; j--) {
                if (nums[maxIdx] < nums[j]) {
                    maxIdx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxIdx];
            nums[maxIdx] = temp;
         }
    }

}
