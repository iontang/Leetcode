package problems_by_year.year_2020.month_03.problems_20200323.Merge_Sorted_Array;

public class Solution {





    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
    }


    /**
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * Output: [1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */

    // [1] 1 [] 0

    // [4,0,0,0,0,0] 1 [1,2,3,5,6] 5

    // Output [1,4,2,3,5,6] Expected [1,2,3,4,5,6]
    public void merge_W1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = 0;
        int j = 0;
        int end = 0;
        while (i < (m + n)) {
            if (i >= m) {
                nums1[i++] = nums2[end++];
            } else if (nums1[i] <= nums2[j]) {
                ++i;
            } else {
                int tmp = nums1[i];
                nums1[i++] = nums2[j];
                nums2[j++] = tmp;
            }
        }
    }

// [1,2,3,0,0,0]
//         3
//         [2,5,6]
//         3
//
//    Output
// [1,2,3,2,5,6]
//    Expected
// [1,2,2,3,5,6]

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = m-1;
        int j = n-1;
        int total = m+n-1;
        while (j >= 0) {
            if (i < 0) {
                nums1[total--] = nums2[j--];
            } else if (nums1[i] > nums2[j]) {
                nums1[total--] = nums1[i--];
            } else {
                nums1[total--] = nums2[j--];
            }
        }
    }


}
