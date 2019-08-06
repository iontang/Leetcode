package divideandconquer;


/**
 *
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * // [-2,1,-3,4,-1,2,1,-5,4] ： n个数，有多少种可能的组合： 1 ，3，6，10，15 ————n(n+1)/2 ：首项加尾项乘以项数再除2
 *
 * 可用动态规划求解，如何用分治算法解决？
 * 动态规划的思路：负数必定会造成和变小，初始化一个最大值max和sum值，过程中不断更新max的值
 */


public class MaximumSubarray {

    /**
     * 分治算法，递归实现
     * 时间复杂度： O(nlogn)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        return recArray(nums, 0, nums.length-1);
    }

    public int recArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;

        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid;i>=left;i--) {
            sum += nums[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid+1;i<=right;i++) {
            sum += nums[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }
        int maxLeftRight = Integer.max(recArray(nums, left, mid),recArray(nums, mid+1, right));
        return Integer.max(maxLeftRight, leftMax+rightMax);
    }


    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] a = {-2,1,-3};
        maximumSubarray.maxSubArray(a);
    }
}
