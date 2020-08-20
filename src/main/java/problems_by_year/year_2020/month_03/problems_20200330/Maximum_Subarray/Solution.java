package problems_by_year.year_2020.month_03.problems_20200330.Maximum_Subarray;

public class Solution {


    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4,};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length < 2) return nums[0];
        int max = nums[0];
        int tempMax = nums[0];
        for (int i=1; i< nums.length; i++) {
            tempMax = Math.max(nums[i]+tempMax, nums[i]);
            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }

}
