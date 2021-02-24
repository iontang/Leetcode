package sort.Based_Algorithm.sort_01;

/**
 * ClassName BubbleSort
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/2/5 5:08 下午
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,6,9,1};
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(nums);
        for(int e : nums) {
            System.out.println(e);
        }
    }

    private void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
