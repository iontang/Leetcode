package year.year_2020.month_03.problems_20200302.Missing_Number;

public class Solution {


    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * [0,1] & [1,0] -> error.
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = -1;
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
            if (ele < minValue) minValue = ele;
            if (ele > maxValue) maxValue = ele;
        }
        for (int i = minValue; i <= maxValue; i++) {
            sum -= i;
        }
        // For ascending or descending order,the missing value is the head or the tail.
        if (sum == 0) {
            if (minValue == 0) {
                return maxValue + 1;
            } else {
                return 0;
            }
        }
        return Math.abs(sum);
    }

    public int missingNumber_A(int[] nums) {
        int sum = (nums.length*(nums.length + 1))/2;
        int arraySum = 0;
        for(int i: nums){
            arraySum += i;
        }
        return sum - arraySum;
    }

    public int missingNumber_A2(int[] nums) {
        int lowest = Integer.MAX_VALUE;
        int highest = -1;
        int actualSum = 0;
        int expectedSum = 0;
        for (int i=0; i<nums.length; i++) {
            lowest = Math.min(lowest, nums[i]);
            highest = Math.max(highest, nums[i]);
            actualSum += nums[i];
            expectedSum+=i;
        }
        expectedSum += nums.length;

        return expectedSum - actualSum;
    }


    /**
     * xor : https://leetcode.com/problems/missing-number/solution/
     * https://blog.csdn.net/LiuStan/article/details/6456381
     */
    public int missingNumber_A3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
