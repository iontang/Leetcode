package sort.Based_Algorithm.sort_01;

/**
 * ClassName InsertSort
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/2/5 5:35 下午
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,6,9,1};
        InsertSort sort = new InsertSort();
        sort.insertSort(nums);
        for(int e : nums) {
            System.out.println(e);
        }
    }

    private void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = len-1; i >= 0; i--) {
            int cur = nums[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (cur < nums[j]) {
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+1] = cur;
        }
    }

}
