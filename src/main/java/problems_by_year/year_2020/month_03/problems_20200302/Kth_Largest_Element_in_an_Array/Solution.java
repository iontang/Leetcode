package year.year_2020.month_03.problems_20200302.Kth_Largest_Element_in_an_Array;

public class Solution {
    // [3,2,1,5,6,4] and k = 2
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,5,6,4};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(arr, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k);
    }

    // 也可以使用迭代算法。
    int quickSort(int[] nums, int p, int r, int k) {
        if (p >= r) return nums[p];
        int q = partiton(nums, p, r);
        if (k == q +1) {
            return nums[q];
        } else if (k < q+1) {
            return quickSort(nums, p, q-1, k);
        } else {
            return quickSort(nums, q+1, r, k);
        }
    }

    //
    int partiton(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] >= pivot) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[r];
        nums[r] = tmp;
        return i;
    }
}
