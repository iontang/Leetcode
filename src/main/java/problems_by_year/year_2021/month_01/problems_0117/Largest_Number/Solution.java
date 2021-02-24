package problems_by_year.year_2021.month_01.problems_0117.Largest_Number;

/**
 * ClassName solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/1/19 11:23 下午
 */
// 179:
// Largest Number
// largest-number

//Given a list of non-negative integers nums, arrange them such that they form t
//he largest number.
//
// Note: The result may be very large, so you need to return a string instead of
// an integer.
//
//
// Example 1:
//
//
//Input: nums = [10,2]
//Output: "210"
//
//
// Example 2:
//
//
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
//
//
// Example 3:
//
//
//Input: nums = [1]
//Output: "1"
//
//
// Example 4:
//
//
//Input: nums = [10]
//Output: "10"
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 109
//
// Related Topics Sort
// 👍 2707 👎 292


//leetcode submit region begin(Prohibit modification and deletion)
//Input: nums = [3,30,34,5,9]
    // 11 108 109 12 10 10810 10108
    // 10 100 10010 10100
//Output: "9534330"
class Solution {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Solution solution = new Solution();
//        solution.insertSort(nums, nums.length);
        solution.quickSort(nums, nums.length);
        System.out.println("");
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
//        bubbleSort(nums, len);
        insertSort(nums, len);

        if (nums[len-1] == 0) {
            return "0";
        }
        String result = "";
        for (int i = len-1; i > -1; i--) {
            result += nums[i];
        }
        return result;
    }

    private void bubbleSort(int[] nums, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (compare(nums[j], nums[j+1])) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    private void insertSort(int[] nums, int len) {
        for (int i = 1; i < len ; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (compare(nums[j], value)) {
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+1] = value;
        }
    }

    public void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    private void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (compare(a[j], pivot)) {
                if (i == j) {
                    ++i; // i == j的情况下，不交换，较少系统CPU运行
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
//        System.out.println(pivot);
//        System.out.println("i=" + i);
        return i;
    }

    private boolean compare(int a, int b) {
        // 9 5 --> 95 vs 59 ab > ba true
        // 5 9 --> 59 vs 95 ab > ba false
        // 3 30 --> 330 303 ab > ba
        // 30 3 --> 303 330 ab > ba
        // 34 33 --> 3433 3334 ab > ba true
        // 33 34 --> 3334 3433 ab > ba false
        String ab = String.valueOf(a) + String.valueOf(b);
        String ba = String.valueOf(b) + String.valueOf(a);
        if (Long.parseLong(ab) > Long.parseLong(ba)) {
            return true;
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

